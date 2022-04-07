package Controlador;

import Clases.ClaseCliente;
import Clases.ClaseDetalleFactura;
import Clases.ClaseProductos;
import Modelo.ModeloDetalleFactura;
import Modelo.ModeloFacturas;
import Vista.VistaRegistroProductos;
import Vista.VistaRegistroFacturas;
import Vista.VistaRegistroVentas;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Santiago
 */
public class Controlador_Ventas2 {

    private VistaRegistroVentas vista;
    private ModeloDetalleFactura modelo;
    private VistaRegistroProductos vistaPro;
    private ModeloFacturas modeloFactura = new ModeloFacturas();
    public static ArrayList<ClaseDetalleFactura> listaDetalleFactura = new ArrayList();

    public Controlador_Ventas2(VistaRegistroVentas vista, ModeloDetalleFactura modelo) {
        this.vista = vista;
        this.modelo = modelo;
        vista.setVisible(true);
    }

    public void iniciaControl() throws IOException {
        vista.getBtnProducto01().addActionListener(l -> Botones(1));
        vista.getBtnProducto02().addActionListener(l -> Botones(2));
        vista.getBtnBuscarCliente().addActionListener(l -> buscarPersona(vista.getTxtBuscarCliente().getText()));
        vista.getBtnBuscarProducto().addActionListener(l -> buscarProducto(vista.getTxtBuscarProducto().getText()));
        vista.getBtnGenerarVenta().addActionListener(l-> abrirVentana3());
        CargaImagenenes();
        suma();
        numeroVentas();
        
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
            vista.getLblNombreProducto().setText(nombre);
            vista.getTxtPrecioProducto().setText(String.valueOf(precio));
            vista.getTxtStockProducto().setText(String.valueOf(stock));

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
    
    public void suma() {
        int contar = vista.getTblPedido().getRowCount();
        double suma = 0;
        for (int i = 0; i < contar; i++) {
            suma = suma + Double.parseDouble(vista.getTblPedido().getValueAt(i, 4).toString());
   
        }
     
        vista.getTxtTotal().setText(Double.toString(suma));
    }

    public Icon imagenDBB(int numero) throws IOException {//aparezca la imagen de la bd
        Image imagen = modelo.obtenerImagen(modelo.imagenDeSql(numero));
        Icon icon = new ImageIcon(imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH));//aki cambias tamano 
        return icon;
    }

    public void CargaImagenenes() throws IOException {
        vista.getBtnProducto01().setIcon(imagenDBB(1));
        vista.getBtnProducto02().setIcon(imagenDBB(2));
    }

    private int conteo_clicks = 0;
    public void Contar(MouseEvent mouseEvent) {
        conteo_clicks++;

    }

        private void numeroVentas() {
            
        vista.getLblFactura().setText(modelo.contar() + "");
    }
        
        
        private void stock() {
        
        DefaultTableModel tblModel = (DefaultTableModel) vistaPro.getTablaProductos().getModel();
        ModeloDetalleFactura modelodeta = new ModeloDetalleFactura();

        for (int i = 0; i < tblModel.getRowCount(); i++) {
            int count = modelodeta.numeroStock(Integer.parseInt(tblModel.getValueAt(i, 0).toString()));
            int cantidad = Integer.parseInt(tblModel.getValueAt(i, 3).toString());
            int resta = count - cantidad;
            //System.out.println("La cantidad es: "+count+"  La cantidad comprada es: " +cantidad+" y me voy a guardar como: "+resta);
            modelodeta.setCantidad(resta);
            vista.getTxtStockProducto().setText(vistaPro.getTablaProductos().getValueAt(i, 4).toString());
            if (modelodeta.controlStock()) {

            } else {
                JOptionPane.showMessageDialog(vista, "Error");
            }

        }

    }
        
        
    private void abrirVentana3(){
        
        ModeloDetalleFactura modeloV = new ModeloDetalleFactura();
        VistaRegistroFacturas vistaVentas = new VistaRegistroFacturas();
        Controlador_Ventas3 controla = new Controlador_Ventas3(vistaVentas, modeloV);
        vistaVentas.setVisible(true);
        controla.iniciaControl();
    }
}
