package Controlador;

import Modelo.Modelo_Usuario;
import Vista.VistaMenuPrincipal;
import Vista.VistaRegistroUsuarios;
/**
 *
 * @author Santiago
 */
public class Controlador_RegistroUsuario {
    
    VistaRegistroUsuarios vistaLogin;
    VistaMenuPrincipal vistaMenu;

    public Controlador_RegistroUsuario(VistaRegistroUsuarios vistaLogin) {
        this.vistaLogin = vistaLogin;
        vistaLogin.setVisible(true);
    }
    
    
    public void iniciaControl(){
        
        vistaLogin.getBtnRegistrar().addActionListener(l-> registrarUsuario());
        
    }
    
    
    private void registrarUsuario(){
        
        Modelo_Usuario modeloUsuario = new Modelo_Usuario();
        VistaRegistroUsuarios vistaRegistroUsuarios = new VistaRegistroUsuarios();
        Controlador_RegistroNuevoUsuario controladorRegUsuarios = new Controlador_RegistroNuevoUsuario(modeloUsuario, vistaRegistroUsuarios);
        
        controladorRegUsuarios.iniciaControl();
    }
    
}
