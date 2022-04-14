package Controlador;

import Modelo.ModeloCliente;
import Modelo.ModeloDetalleFactura;
import Modelo.ModeloEmpleado;
import Modelo.ModeloProductos;
import Modelo.Modelo_Pedidos;
import Modelo.Modelo_Usuario;
import Vista.VistaLogin;
import Vista.VistaMenuPrincipal;
import Vista.VistaRegistroClientes;
import Vista.VistaRegistroProductos;
import Vista.VistaRegistroEmpleados;
import Vista.VistaRegistroVentas;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Equipo
 */
public class Controlador_MenuPrincipal {
    
    
    VistaMenuPrincipal vistaMenu;
    

    public Controlador_MenuPrincipal(VistaMenuPrincipal vistaMenu) {
        this.vistaMenu = vistaMenu;
        vistaMenu.setVisible(true);
    }
    
    public void iniciaControl(){
        
        vistaMenu.getBtnAdminProductos().addActionListener(l-> crudProductos());
        vistaMenu.getBtnAdminPersonal().addActionListener(l-> crudEmpleados());
        vistaMenu.getBtnRegistrarClientes().addActionListener(l->crudClientes());
        vistaMenu.getMnSalir().addActionListener(l->cerrar());
        vistaMenu.getBtnV2().addActionListener(l-> {
            try {
                abrirVentas2();
            } catch (IOException ex) {
                Logger.getLogger(Controlador_MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    
        private void crudProductos() {

        ModeloProductos modeloCrudProductos = new ModeloProductos();
        VistaRegistroProductos vistaProductos = new VistaRegistroProductos();
        vistaMenu.getjDeskPanel().add(vistaProductos);
        
        Controlador_Productos controladorCrudProductos = new Controlador_Productos(vistaProductos, modeloCrudProductos);
        controladorCrudProductos.iniciaControl();
    }
        
        
        
        private void crudEmpleados() {

        ModeloEmpleado modeloCrudEmpleados = new ModeloEmpleado();
        VistaRegistroEmpleados vistaCrudEmpleados = new VistaRegistroEmpleados();
     
        vistaMenu.getjDeskPanel().add(vistaCrudEmpleados);
        
        Controlador_Empleado controladorCrudProductos = new Controlador_Empleado(modeloCrudEmpleados, vistaCrudEmpleados);
        controladorCrudProductos.iniciarControl();
    }
        
    private void crudClientes(){
        ModeloCliente mCliente = new ModeloCliente();
        VistaRegistroClientes vClientes = new VistaRegistroClientes();
        
        vistaMenu.getjDeskPanel().add(vClientes);
        Controlador_Cliente cCliente = new Controlador_Cliente(mCliente, vClientes);
        cCliente.iniciarControl();
    }
    
    public void abrirVentas2() throws IOException{
        
        ModeloDetalleFactura modeloV = new ModeloDetalleFactura();
        VistaRegistroVentas vistaVentas = new VistaRegistroVentas();
        vistaMenu.getjDeskPanel().add(vistaVentas);

        Controlador_Ventas2 controla = new Controlador_Ventas2(vistaVentas, modeloV);
        controla.iniciaControl();
       
    }
    public void cerrar(){
        VistaLogin vl = new VistaLogin();
        Controlador_Login cl = new Controlador_Login(vl);
        cl.iniciaControl();
        vistaMenu.dispose();
        vl.setVisible(true);
    }
    
}
