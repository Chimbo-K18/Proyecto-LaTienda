package Controlador;

import Clases.ClaseDetalleFactura;
import Modelo.ModeloDetalleFactura;
import Modelo.ModeloFacturas;
import Modelo.Modelo_Pedidos;
import Vista.VistaRegistroProductos;
import Vista.VistaRegistroFacturas;
import Vista.VistaRegistroVentas;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Santiago
 */
public class Controlador_Ventas3 {

    private VistaRegistroFacturas vista;
    private ModeloDetalleFactura modelo;
    private VistaRegistroVentas vistaVentas;

    public Controlador_Ventas3(VistaRegistroFacturas vista, ModeloDetalleFactura modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    public void iniciaControl() {

        //vista.getBtnGenerarFactura().addActionListener(l -> guardarRegistro());

        //cargarRegistros();
    }

    private void guardarRegistro() {

    }

    private void cargarRegistros() {

        }

}
