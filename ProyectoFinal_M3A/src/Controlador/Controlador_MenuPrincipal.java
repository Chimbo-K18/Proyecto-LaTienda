package Controlador;

import Modelo.ModeloCliente;
import Modelo.ModeloDetalleFactura;
import Modelo.ModeloEmpleado;
import Modelo.ModeloProductos;
import Modelo.Modelo_Pedidos;
import Modelo.Modelo_Usuario;
import Vista.VistaMenuPrincipal;
import Vista.VistaRegistroClientes;
import Vista.VistaRegistroProductos;
import Vista.VistaRegistroEmpleados;
import Vista.VistaRegistroVentas;
import Vista.VistaVentas2;

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
        vistaMenu.getBtnVentas().addActionListener(l->Ventas());
        vistaMenu.getBtnV2().addActionListener(l-> abrirVentas2());
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
    
    public void Ventas (){
        Modelo_Pedidos pedidos = new Modelo_Pedidos ();
        VistaRegistroVentas ventas = new VistaRegistroVentas ();
         vistaMenu.getjDeskPanel().add( ventas );
         
         Controlador_Pedido cPedido = new  Controlador_Pedido(ventas, pedidos);
         cPedido.iniciaControl();
    }
    
    public void abrirVentas2(){
        
        ModeloDetalleFactura modeloV = new ModeloDetalleFactura();
        VistaVentas2 vistaVentas = new VistaVentas2();
        Controlador_Ventas2 controla = new Controlador_Ventas2(vistaVentas, modeloV);
        controla.iniciaControl();
    }
    
}
