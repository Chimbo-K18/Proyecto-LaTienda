package Controlador;

import Clases.ClaseCliente;
import Clases.ClaseDetalleFactura;
import Clases.ClaseEmpleado;
import Clases.ClaseProductos;
import Modelo.ModeloCliente;
import Modelo.ModeloDetalleFactura;
import Modelo.ModeloEmpleado;
import Modelo.ModeloFacturas;
import Modelo.Modelo_Pedidos;
import Modelo.Modelo_Usuario;
import Vista.VistaMenuPrincipal;
import Vista.VistaRegistroClientes;
import Vista.VistaRegistroProductos;
import Vista.VistaRegistroFacturas;
import Vista.VistaRegistroVentas;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Santiago
 */
public class Controlador_Ventas2 {

    private VistaRegistroVentas vista;
    private ModeloDetalleFactura modelo;
    private Modelo_Usuario modeloUsu;
        VistaMenuPrincipal vistaMenu;
    private VistaRegistroProductos vistaPro;
    private int conteo_clicks = 0;
    public static ArrayList<ClaseDetalleFactura> listaDetalleFactura = new ArrayList();

    public Controlador_Ventas2(VistaRegistroVentas vista, ModeloDetalleFactura modelo) {
        this.vista = vista;
        this.modelo = modelo;
        vista.setVisible(true);
        CargarDisponibilidad("");
         numeroVentas();
    }
    
    

    public void iniciaControl() throws IOException {
      
        KeyListener kl = new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            CargarDisponibilidad(vista.getTxtbuscarPro().getText());

                
            }
            
        };
        
        vista.getBtnProducto01().addActionListener(l -> Botones(1));
        vista.getBtnProducto02().addActionListener(l -> Botones(2));
        vista.getBtnProducto03().addActionListener(l -> Botones(3));
        vista.getBtnProducto04().addActionListener(l -> Botones(4));
        vista.getBtnProducto05().addActionListener(l -> Botones(5));
        vista.getBtnProducto06().addActionListener(l -> Botones(6));
        vista.getBtnBuscarCliente().addActionListener(l -> buscarPersona(vista.getTxtBuscarCliente().getText()));
        vista.getBtnBuscarEmpleado().addActionListener(l -> buscarEmpleado(vista.getTxtBuscarEmpleado().getText()));
        vista.getBtnGenerarVenta().addActionListener(l -> abrirVentana3());
        vista.getBtnCrearCliente().addActionListener(l -> crearClienteVentana());
        vista.getBtnNuevaVenta().addActionListener(l-> crearnuevaventa());

         
        CargaImagenenes();
        suma();
        
       
        vista.getTxtbuscarPro().addKeyListener(kl);//
        fechaActual();


    }

    public void buscarPersona(String busqueda) {

        List<ClaseCliente> lista = modelo.BuscarPersona(busqueda);

//        if(vista.getTxtBuscarCliente().equals(busqueda)){
//             
        for (int i = 0; i < lista.size(); i++) {

            String cedula = lista.get(i).getCedula();
            String nombre = lista.get(i).getNombre();

            //vista.getTxtCedula().setText(cedula);
            vista.getLblNombreCliente().setText(nombre);

        }

//         }else{
//                JOptionPane.showMessageDialog(vista, "Cliente No Encontrado en el Registro");
//                }
    }

    public void buscarProducto(String busqueda) {

        List<ClaseProductos> lista = modelo.BuscarProducto(busqueda);

//        if(vista.getTxtBuscarCliente().equals(busqueda)){
//             
        for (int i = 0; i < lista.size(); i++) {

            String nombre = lista.get(i).getNombre();
            Double precio = lista.get(i).getPrecio();
            Integer stock = lista.get(i).getStock();

            //vista.getTxtCedula().setText(cedula);


        }

//         }else{
//                JOptionPane.showMessageDialog(vista, "Cliente No Encontrado en el Registro");
//                }
    }
    
    public void buscarEmpleado(String busqueda) {

        List<ClaseEmpleado> lista = modelo.BuscarEmpleado(busqueda);

//        if(vista.getTxtBuscarCliente().equals(busqueda)){
//             
        for (int i = 0; i < lista.size(); i++) {

            String nombre = lista.get(i).getNombre();
            String codigo = String.valueOf(lista.get(i).getId_empleado());

            //vista.getTxtCedula().setText(cedula);
            vista.getLblIdEmpleado().setText(codigo);
            vista.getLblNombreEmpleado().setText(nombre);

        }

//         }else{
//                JOptionPane.showMessageDialog(vista, "Cliente No Encontrado en el Registro");
//                }
    }

    public void Botones(int numero) {

        DefaultTableModel tblModel = (DefaultTableModel) vista.getTblPedido().getModel();
        List<ClaseProductos> listapro = modelo.productitos(numero);
        listapro.stream().forEach(lp -> {
            if (RevisaCodigo(String.valueOf(lp.getId()), tblModel)) {
                tblModel.addRow(new Object[]{lp.getId() + "", lp.getNombre(), "1", lp.getPrecio(), lp.getPrecio()});
            } else {
                for (int i = 0; i < tblModel.getRowCount(); i++) {
                    String codigo = tblModel.getValueAt(i, 0).toString();
                    if (String.valueOf(lp.getId()).equals(codigo)) {
                        double precio = Double.parseDouble(tblModel.getValueAt(i, 3).toString());
                        int numerito = Integer.parseInt(tblModel.getValueAt(i, 2).toString());
                        numerito++;
                        double total = numerito * precio;
                        tblModel.setValueAt(numerito, i, 2);
                        tblModel.setValueAt(total, i, 4);
                        tblModel.fireTableRowsUpdated(i, i);

                    }
                }
            }
        });
        suma();
    }

    private boolean RevisaCodigo(String codigo, DefaultTableModel modelo) {
        if (codigo != null && modelo != null) {
            for (int renglon = 0; renglon < modelo.getRowCount(); renglon++) {
                String codigoEnRenglon = (String) modelo.getValueAt(renglon, 0);
                if (codigo.equals(codigoEnRenglon)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private int codigo() {

        int codigoproducto = Integer.parseInt(vista.getTblPedido().getValueAt(vista.getTblPedido().getRowCount() - 1, 0).toString());
        System.out.println(codigoproducto);

        return codigoproducto;
    }

    private int buscaUltimaCantidad(String codigo, DefaultTableModel modelo) {
        int cuentame = 1;
        if (codigo != null && modelo != null) {
            for (int i = 0; i < modelo.getRowCount(); i++) {
                String codigoEnRenglon = (String) modelo.getValueAt(i, 0);
                if (codigo.equals(codigoEnRenglon)) {
                    return cuentame++;
                }
            }
        }
        return cuentame++;
    }
    
    public void suma() {
        int contar = vista.getTblPedido().getRowCount();
        double suma = 0;
        for (int i = 0; i < contar; i++) {
            suma = suma + Double.parseDouble(vista.getTblPedido().getValueAt(i, 4).toString());


        }
        vista.getTxtSubTotal().setText(Double.toString(suma));

        double iva = (suma * 0.12);
        vista.getTxtIva().setText(Double.toString(iva));

        vista.getTxtTotalPagar().setText("" + (suma + iva));
        }
    

    public Icon imagenDBB(int numero) throws IOException {//aparezca la imagen de la bd
        Image imagen = modelo.obtenerImagen(modelo.imagenDeSql(numero));
        Icon icon = new ImageIcon(imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH));//aki cambias tamano 
        return icon;
    }

    public void CargaImagenenes() throws IOException {
        vista.getBtnProducto01().setIcon(imagenDBB(1));
        vista.getBtnProducto02().setIcon(imagenDBB(2));
        vista.getBtnProducto03().setIcon(imagenDBB(3));
        vista.getBtnProducto04().setIcon(imagenDBB(4));
        vista.getBtnProducto05().setIcon(imagenDBB(5));
        vista.getBtnProducto06().setIcon(imagenDBB(6));
    }

    public void Contar(MouseEvent mouseEvent) {
        conteo_clicks++;

    }

    private void numeroVentas() {

        vista.getLblFactura().setText(modelo.contar() + "");
    }

    public void crearnuevaventa() {
        numeroVentas();
        limpiarCampos();
    }
    private void stock() {

        DefaultTableModel tblModel = (DefaultTableModel) vista.getTablapro().getModel();
        ModeloDetalleFactura modelodeta = new ModeloDetalleFactura();

        for (int i = 0; i < tblModel.getRowCount(); i++) {
            int count = modelodeta.buscameid(Integer.parseInt(tblModel.getValueAt(i, 0).toString()));
            int cantidad = Integer.parseInt(tblModel.getValueAt(i, 2).toString());
            int resta = count - cantidad;
            //System.out.println("La cantidad es: "+count+"  La cantidad comprada es: " +cantidad+" y me voy a guardar como: "+resta);
            modelodeta.setCantidad(resta);
            modelodeta.setIdProducto(Integer.parseInt(tblModel.getValueAt(i, 0).toString()));
            
             if (modelodeta.controlStock()) {

                System.out.println("Conexion Fresh X4");
            } else {
                JOptionPane.showMessageDialog(vista, "Error");
            }

        }

    }

    private void abrirVentana3() {

        crearPedidos();
        crearFactura();
        stock();
        JOptionPane.showMessageDialog(vista, "Factura Creada con Exito");

    }

    public void crearPedidos() {

        Modelo_Pedidos pedido = new Modelo_Pedidos();
        DefaultTableModel tblModel = (DefaultTableModel) vista.getTblPedido().getModel();

        for (int i = 0; i < tblModel.getRowCount(); i++) {

            pedido.setNombrProducto(vista.getTblPedido().getValueAt(i, 1).toString());
            pedido.setCantidadProd(Integer.valueOf(vista.getTblPedido().getValueAt(i, 2).toString()));
            pedido.setCedulaCliente(vista.getTxtBuscarCliente().getText());

            if (pedido.InsertarPedido()) {
                System.out.println("Creacion Fresh");

            } else {
                JOptionPane.showMessageDialog(vista, "Error en el proceso de registro");
            }

        }
    }

    public void crear() {
        
        ModeloDetalleFactura modelodeta = new ModeloDetalleFactura();
        DefaultTableModel tblModel = (DefaultTableModel) vista.getTblPedido().getModel();

        for (int i = 0; i < tblModel.getRowCount(); i++) {

            modelodeta.setIdFactura(Integer.parseInt(vista.getLblFactura().getText()));
            modelodeta.setIdProducto(Integer.parseInt(tblModel.getValueAt(i, 0).toString()));
            modelodeta.setCantidad(Integer.parseInt(tblModel.getValueAt(i, 2).toString()));
            modelodeta.setCosto_unitario(Double.parseDouble(tblModel.getValueAt(i, 3).toString()));
            modelodeta.setTotal(Double.parseDouble(tblModel.getValueAt(i, 4).toString()));

            if (modelodeta.crearDetalleFactura()) {
                System.out.println("Creacion Fresh X2");
            } else {
                JOptionPane.showMessageDialog(vista, "Error");
            }

        }
    }

    private void crearFactura() {

        ModeloFacturas modeloFactura = new ModeloFacturas();
        
        Modelo_Pedidos pedido = new Modelo_Pedidos();
        DefaultTableModel tblModel = (DefaultTableModel) vista.getTblPedido().getModel();
        String fecha = vista.getLblFecha().getText();
        for (int i = 0; i < tblModel.getRowCount(); i++) {
 
        modeloFactura.setFecha(fecha);
        modeloFactura.setTotal(Double.parseDouble(vista.getTblPedido().getValueAt(i, 4).toString()));
        modeloFactura.setIdCliente(vista.getTxtBuscarCliente().getText());
        modeloFactura.setIdEmpleado(Integer.parseInt(vista.getLblIdEmpleado().getText()));

        if (modeloFactura.crearFactura()) {
            crear();

            System.out.println("Creacion Fresh X3");
        } else {
            JOptionPane.showMessageDialog(vista, "Error");
        }

    }
}
    
    public void CargarDisponibilidad(String busqueda) {//buscarProductos
        DefaultTableModel tblModel = (DefaultTableModel) vista.getTablapro().getModel();
        tblModel.setNumRows(0);//limpiar campos
        List<ClaseProductos> listapro = modelo.productitos(busqueda);
        listapro.stream().forEach(lp -> {
            String[] productos = {lp.getId() + "", lp.getNombre(), lp.getStock()+ ""};
            tblModel.addRow(productos);

        });

    }
    
    
    
    private void crearClienteVentana(){
               
        vistaMenu.setVisible(true);
        
        ModeloCliente mCliente = new ModeloCliente();
        VistaRegistroClientes vClientes = new VistaRegistroClientes();
        
        vistaMenu.getjDeskPanel().add(vClientes);
        Controlador_Cliente cCliente = new Controlador_Cliente(mCliente, vClientes);
        cCliente.iniciarControl();
    }
    
    private void fechaActual(){
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String fechaComoCadena = sdf.format(new Date());
        //System.out.println(fechaComoCadena);
        vista.getLblFecha().setText(fechaComoCadena);
        

    }
    
    
    
        private void limpiarCampos() {
        vista.getLblIdEmpleado().setText(null);
        vista.getLblNombreCliente().setText(null);
        vista.getLblNombreEmpleado().setText(null);
        vista.getLblFecha().setText(null);
        vista.getTxtBuscarCliente().setText(null);
        vista.getTxtIva().setText(null);
        vista.getTxtSubTotal().setText(null);
        vista.getTxtTotalPagar().setText(null);
        vista.getTxtbuscarPro().setText(null);
        DefaultTableModel tblModel = (DefaultTableModel) vista.getTblPedido().getModel();
        tblModel.setNumRows(0);// campos
    }
    


}

