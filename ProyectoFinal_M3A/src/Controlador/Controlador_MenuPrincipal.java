package Controlador;

import Modelo.ModeloProductos;
import Vista.VistaMenuPrincipal;
import Vista.VistaRegistroProductos;

/**
 *
 * @author Equipo
 */
public class Controlador_MenuPrincipal {
    VistaMenuPrincipal vistaMenuPrincipal;
    //viewProductos vistaProductos;

    public Controlador_MenuPrincipal(VistaMenuPrincipal vista) {
        this.vistaMenuPrincipal = vista;
        vista.setVisible(true);
    }
    public void iniciaCotrol() {
       
        vistaMenuPrincipal.getBtnAdminProductos().addActionListener(l -> crudProductos());
        //vistaMenuPrincipal.getMenuItemProductos().addActionListener(l -> crudProductos());
        

    }
     private void crudProductos() {
        //Instacio las clases de modelo y vista
        ModeloProductos modeloCrudProductos = new ModeloProductos();

        VistaRegistroProductos vistaCrudProductos = new VistaRegistroProductos();
        //Agregar el frame personas al desk panel
        vistaMenuPrincipal.getjDeskPanel().add(vistaCrudProductos);
        //vistaProductos.getDeskprincipal().add(vistaCrudProductos);
        Controlador_Productos controladorCrudProductos = new Controlador_Productos(vistaCrudProductos, modeloCrudProductos);
        controladorCrudProductos.iniciaControl(); //empezamos los escuchas a los eventos
    }
}
