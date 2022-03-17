package Controlador;

import Modelo.ModeloCliente;
import Modelo.ModeloEmpleado;
import Modelo.ModeloProductos;
import Modelo.Modelo_Usuario;
import Vista.VistaMenuPrincipal;
import Vista.VistaRegistroClientes;
import Vista.VistaRegistroProductos;
import Vista.VistaRegistroEmpleados;

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

    }
    
    
        private void crudProductos() {

        ModeloProductos modeloCrudProductos = new ModeloProductos();
        VistaRegistroProductos vistaCrudProductos = new VistaRegistroProductos();
     
        vistaMenu.getjDeskPanel().add(vistaCrudProductos);
        
        Controlador_Productos controladorCrudProductos = new Controlador_Productos(vistaCrudProductos, modeloCrudProductos);
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
    
}
