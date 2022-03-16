package Controlador;

import Modelo.ModeloProductos;
import Modelo.Modelo_Usuario;
import Vista.VistaLogin;
import Vista.VistaMenuPrincipal;
import Vista.VistaRegistroProductos;
import Vista.VistaRegistroUsuarios;


/**
 *
 * @author Santiago
 */
public class Controlador_Login {
 
        VistaLogin vistaInicio;


    public Controlador_Login(VistaLogin vistaInicio) {
        this.vistaInicio = vistaInicio;
        vistaInicio.setVisible(true);
    }


    public void iniciaControl(){
        
        vistaInicio.getBtnRegistrarse().addActionListener(l-> registrarUsuario());
        vistaInicio.getBtnIniciarSesion().addActionListener(l-> abrirMenuPrincipal());

    }
    
    
    private void registrarUsuario(){
        
        Modelo_Usuario modeloUsuario = new Modelo_Usuario();
        VistaRegistroUsuarios vistaRegistroUsuarios = new VistaRegistroUsuarios();
        Controlador_RegistroNuevoUsuario controladorRegUsuarios = new Controlador_RegistroNuevoUsuario(modeloUsuario, vistaRegistroUsuarios);
        
        controladorRegUsuarios.iniciaControl();
    }
    
    private void abrirMenuPrincipal(){
        
        VistaMenuPrincipal vistaMenuPrincipal = new VistaMenuPrincipal();
        Controlador_MenuPrincipal controladorMenu = new Controlador_MenuPrincipal(vistaMenuPrincipal);
        
        controladorMenu.iniciaControl();
    }


}
