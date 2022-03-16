package Controlador;

import Modelo.Modelo_Usuario;
import Vista.VistaRegistroUsuarios;
/**
 *
 * @author Santiago
 */
public class Controlador_InicioSesion {
    
    VistaRegistroUsuarios vistaLogin;

    public Controlador_InicioSesion(VistaRegistroUsuarios vistaLogin) {
        this.vistaLogin = vistaLogin;
        vistaLogin.setVisible(true);
    }
    
    
    public void iniciaControl(){
        
        vistaLogin.getBtnRegistrar().addActionListener(l-> registrarUsuario());
        
        
    }
    
    
    private void registrarUsuario(){
        
        Modelo_Usuario modeloUsuario = new Modelo_Usuario();
        VistaRegistroUsuarios vistaRegistroUsuarios = new VistaRegistroUsuarios();
        Controlador_RegistroUsuarios controladorRegUsuarios = new Controlador_RegistroUsuarios(modeloUsuario, vistaRegistroUsuarios);
        
        controladorRegUsuarios.iniciaControl();
    }
    
}
