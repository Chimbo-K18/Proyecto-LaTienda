package Controlador;

/**
 * @author bryan
 */
import Modelo.ClaseCliente;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import Vista.VistaRegistroVentas;
import Modelo.ModeloFacturas;
import Modelo.ModeloDetalleFactura;
import Modelo.ClaseDetalleFactura;
import Modelo.ClaseProductos;
import Modelo.ConectionBDD;

public class Controlador_Venta {

    private VistaRegistroVentas vistaVenta;
    private ModeloDetalleFactura modeloDetalle;
    private ModeloFacturas modeloFactura = new ModeloFacturas();
    public static ArrayList<ClaseDetalleFactura> listaDetalleFactura = new ArrayList();
    ModeloDetalleFactura dbp = new ModeloDetalleFactura(); //inicializar llamar al objeto de la clase
    MouseListener mouse;

    public Controlador_Venta(VistaRegistroVentas vistaVenta, ModeloDetalleFactura modeloDetalle) {
        this.vistaVenta = vistaVenta;
        this.modeloDetalle = modeloDetalle;
        vistaVenta.setVisible(true);
        CargarDisponibilidad("");
        llenaridfactura();
    }

    public void iniciaControl() throws IOException {

        KeyListener kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                CargarDisponibilidad(vistaVenta.getTxtBuscarPro().getText());
                llenarCuadrosDialogoPersona(vistaVenta.getTxtCedula().getText());
            }
        };

        vistaVenta.getTxtBuscarPro().addKeyListener(kl);
        vistaVenta.getTxtCedula().addKeyListener(kl);
        CargaImagenenes();
        suma();

        MouseListener ml = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Contar(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };

        //vista.getBtnRemover().addActionListener(l -> eliminar());
        vistaVenta.getBtnProducto01().addActionListener(l -> Botones(1));
        vistaVenta.getBtnProducto02().addActionListener(l -> Botones(2));
        vistaVenta.getBtnProducto03().addActionListener(l -> Botones(3));
        vistaVenta.getBtnProducto04().addActionListener(l -> Botones(4));
        vistaVenta.getBtnProducto05().addActionListener(l -> Botones(5));
        vistaVenta.getBtnProducto06().addActionListener(l -> Botones(6));
        vistaVenta.getBtnProducto07().addActionListener(l -> Botones(7));
        vistaVenta.getBtnProducto08().addActionListener(l -> Botones(8));
        vistaVenta.getBtnProducto09().addActionListener(l -> Botones(9));
        vistaVenta.getBtnSalir().addActionListener(l -> salir());
        vistaVenta.getBtnGenerarFactura().addActionListener(l -> GenerarVenta());
        vistaVenta.getBtnNuevo().addActionListener(l -> crearnuevaventa());
    }

    private void ImprimirListaVentas() {
        ConectionBDD connection = new ConectionBDD();
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/vista/Reportes/DetalleFactura.jasper"));//cargar reporte jasper al jr
            JasperPrint jp = JasperFillManager.fillReport(jr, null, connection.getCon());//se conecta a la base y con el fill rellena los datos al reporte. Estamos cargadon el reporte con los datos de la base
            JasperViewer jv = new JasperViewer(jp, false);//visualizar el reporte
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Controlador_Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void suma() {
        int contar = vistaVenta.getTblFactura().getRowCount();
        double suma = 0;
        for (int i = 0; i < contar; i++) {
            suma = suma + Double.parseDouble(vistaVenta.getTblFactura().getValueAt(i, 5).toString());
        }
        vistaVenta.getTxtSubtotal().setText(Double.toString(suma));
        double iva = (suma * 0.12);
        vistaVenta.getTxtIva().setText(Double.toString(iva));
        vistaVenta.getTxtTotalPagar().setText("" + (suma + iva));
    }

    int contador = 1;
    boolean a = false;

    public void Botones(int numero) {

        DefaultTableModel tblModel = (DefaultTableModel) vistaVenta.getTblFactura().getModel();
        List<ClaseProductos> listapro = modeloDetalle.productitos(numero);
        listapro.stream().forEach(lp -> {
            if (RevisaCodigo(String.valueOf(lp.getId()), tblModel)) {
                tblModel.addRow(new Object[]{lp.getId() + "", lp.getNombre(), lp.getDescripcion(), "1", lp.getPrecio(), lp.getPrecio()});
            } else {
                for (int i = 0; i < tblModel.getRowCount(); i++) {
                    String codigo = tblModel.getValueAt(i, 0).toString();
                    if (String.valueOf(lp.getId()).equals(codigo)) {

                        double precio = Double.parseDouble(tblModel.getValueAt(i, 4).toString());
                        int numerito = Integer.parseInt(tblModel.getValueAt(i, 3).toString());
                        numerito++;
                        double total = numerito * precio;
                        tblModel.setValueAt(numerito, i, 3);
                        tblModel.setValueAt(total, i, 5);
                        tblModel.fireTableRowsUpdated(i, i);

                    }
                }
            }

        });

        suma();
    }

    private int conteo_clicks = 0;

    public void Contar(MouseEvent mouseEvent) {
        conteo_clicks++;

    }

    public Icon imagenDBB(int numero) throws IOException {//aparezca la imagen de la bd
        Image imagen = modeloDetalle.obtenerImagen(modeloDetalle.imagenDeSql(numero));
        Icon icon = new ImageIcon(imagen.getScaledInstance(150, 150, Image.SCALE_SMOOTH));//aki cambias tamano 
        return icon;
    }

    public void CargaImagenenes() throws IOException {

        vistaVenta.getBtnProducto01().setIcon(imagenDBB(1));
        vistaVenta.getBtnProducto02().setIcon(imagenDBB(2));
        vistaVenta.getBtnProducto03().setIcon(imagenDBB(3));
        vistaVenta.getBtnProducto04().setIcon(imagenDBB(4));
        vistaVenta.getBtnProducto05().setIcon(imagenDBB(5));
        vistaVenta.getBtnProducto06().setIcon(imagenDBB(6));
        vistaVenta.getBtnProducto07().setIcon(imagenDBB(7));
        vistaVenta.getBtnProducto08().setIcon(imagenDBB(8));
        vistaVenta.getBtnProducto09().setIcon(imagenDBB(9));

    }

    public void CargarDisponibilidad(String busqueda) {//buscarProductos
        DefaultTableModel tblModel = (DefaultTableModel) vistaVenta.getTblPro().getModel();
        tblModel.setNumRows(0);//limpiar campos
        List<ClaseProductos> listapro = modeloDetalle.productitos(busqueda);
        listapro.stream().forEach(lp -> {
            String[] productos = {lp.getId() + "", lp.getNombre(), lp.getStock() + ""};
            tblModel.addRow(productos);

        });
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
        int codigoproducto = Integer.parseInt(vistaVenta.getTblFactura().getValueAt(vistaVenta.getTblFactura().getRowCount() - 1, 0).toString());
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

    private void llenarCuadrosDialogoPersona(String cadenaBusqueda) {//Buscar Persona
        List<ClaseCliente> listaPersona = modeloDetalle.buscarcliente(cadenaBusqueda);

        listaPersona.stream().forEach(p -> {
            String[] persona = {p.getNombre(), p.getApellido(),
                String.valueOf(p.getTelefono())};

            vistaVenta.getTxtNombre().setText(persona[0]);
            vistaVenta.getTxtApellido().setText(persona[1]);

        });
    }

    private void llenaridfactura() {
        vistaVenta.getLblFactura().setText(modeloDetalle.contar() + "");
    }

    private void crearFactura() {
        modeloFactura.setIdFactura(Integer.parseInt(vistaVenta.getLblFactura().getText()));
        modeloFactura.setFecha(((JTextField) vistaVenta.getDateFacturas().getDateEditor().getUiComponent()).getText());
        modeloFactura.setIdCliente(Integer.parseInt(vistaVenta.getTxtCedula().getText()));
        if (modeloFactura.crearFactura()) {
            crear();
            JOptionPane.showMessageDialog(vistaVenta, "Factura Creada Con Satisfaccion");
        } else {
            JOptionPane.showMessageDialog(vistaVenta, "Error");
        }

    }

    public void crear() {//crearDetalleFactura
        ModeloDetalleFactura modelodeta = new ModeloDetalleFactura();
        DefaultTableModel tblModel = (DefaultTableModel) vistaVenta.getTblFactura().getModel();
        //List<Productos> listapro = modelo.productitos(numero);
        for (int i = 0; i < tblModel.getRowCount(); i++) {
            modelodeta.setIdFactura(Integer.parseInt(vistaVenta.getLblFactura().getText()));
            modelodeta.setIdDetalle(Integer.parseInt(vistaVenta.getLblFactura().getText()));
            modelodeta.setIdProducto(Integer.parseInt(tblModel.getValueAt(i, 0).toString()));
            modelodeta.setCantidad(Integer.parseInt(tblModel.getValueAt(i, 3).toString()));
            modelodeta.setCosto_unitario(Double.parseDouble(tblModel.getValueAt(i, 4).toString()));
            modelodeta.setTotal(Double.parseDouble(tblModel.getValueAt(i, 5).toString()));
            if (modelodeta.creardetallefactura()) {
                //JOptionPane.showMessageDialog(vista, "Factura Creada Con Satisfaccion");
                //stock();
            } else {
                JOptionPane.showMessageDialog(vistaVenta, "Error");
            }
        }
    }

    private void stock() {
        DefaultTableModel tblModel = (DefaultTableModel) vistaVenta.getTblFactura().getModel();
        ModeloDetalleFactura modelodeta = new ModeloDetalleFactura();

        for (int i = 0; i < tblModel.getRowCount(); i++) {
            int count = modelodeta.buscameid(Integer.parseInt(tblModel.getValueAt(i, 0).toString()));
            int cantidad = Integer.parseInt(tblModel.getValueAt(i, 3).toString());
            int resta = count - cantidad;
            //System.out.println("La cantidad es: "+count+"  La cantidad comprada es: " +cantidad+" y me voy a guardar como: "+resta);
            modelodeta.setCantidad(resta);
            modelodeta.setIdProducto(Integer.parseInt(tblModel.getValueAt(i, 0).toString()));
            if (modelodeta.restame()) {
            } else {
                JOptionPane.showMessageDialog(vistaVenta, "Error");
            }
        }
    }

    private void GenerarVenta() {
        crearFactura();
        stock();
        CargarDisponibilidad("");
    }

    public void crearnuevaventa() {
        llenaridfactura();
        limpiarCampos();
    }

    private void limpiarCampos() {
        vistaVenta.getTxtNombre().setText(null);
        vistaVenta.getTxtApellido().setText(null);
        vistaVenta.getDateFacturas().setDate(null);
        vistaVenta.getTxtCedula().setText(null);
        vistaVenta.getTxtIva().setText(null);
        vistaVenta.getTxtSubtotal().setText(null);
        vistaVenta.getTxtTotalPagar().setText(null);
        DefaultTableModel tblModel = (DefaultTableModel) vistaVenta.getTblFactura().getModel();
        tblModel.setNumRows(0);//limpiar campos
    }

    private void salir() {
        vistaVenta.setVisible(false);
    }
;
}
//
