package Controlador;

/**
 *
 * @author bryan
 */
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

import Vista.VistaRegistroClientes;
import Vista.VistaRegistroVentas;
import Modelo.ModeloFacturas;
import Modelo.ModeloDetalleFactura;
import Modelo.ClaseDetalleFactura;
import Modelo.ClasePersona;
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

    public void CargarDisponibilidad(String busqueda) {//buscarProductos
        DefaultTableModel tblModel = (DefaultTableModel) vistaVenta.getTblPro().getModel();
        tblModel.setNumRows(0);//limpiar campos
        List<ClaseProductos> listapro = modeloDetalle.productitos(busqueda);
        listapro.stream().forEach(lp -> {
            String[] productos = {lp.getId() + "", lp.getNombre(), lp.getStock() + ""};
            tblModel.addRow(productos);

        });
    }

    private void llenaridfactura() {
        vistaVenta.getLblFactura().setText(modeloDetalle.contar() + "");
    }
    
    private void ImprimirListaVentas() {
        ConectionPg connection = new ConectionPg();
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/vista/Reportes/DetalleFactura.jasper"));//cargar reporte jasper al jr
            JasperPrint jp = JasperFillManager.fillReport(jr, null, connection.getCon());//se conecta a la base y con el fill rellena los datos al reporte. Estamos cargadon el reporte con los datos de la base
            JasperViewer jv = new JasperViewer(jp, false);//visualizar el reporte
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ControlerVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
