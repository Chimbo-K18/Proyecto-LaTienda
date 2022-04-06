package Controlador;

import Modelo.ClaseCliente;
import Modelo.ClaseDetalleFactura;
import Modelo.ClaseProductos;
import Modelo.ModeloDetalleFactura;
import Vista.VistaVentas2;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Santiago
 */
public class Controlador_Ventas2 {

    private VistaVentas2 vista;
    private ModeloDetalleFactura modelo;

    public Controlador_Ventas2(VistaVentas2 vista, ModeloDetalleFactura modelo) {
        this.vista = vista;
        this.modelo = modelo;
        vista.setVisible(true);
    }

    public void iniciaControl() {

        vista.getBtnBuscarCliente().addActionListener(l -> buscarPersona(vista.getTxtBuscarCliente().getText()));
        vista.getBtnBuscarProducto().addActionListener(l -> buscarProducto(vista.getTxtBuscarProducto().getText()));


     
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
    
    
    }

