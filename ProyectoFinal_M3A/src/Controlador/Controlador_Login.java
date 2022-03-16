package Controlador;

import Modelo.Modelo_Usuario;
import Vista.VistaLogin;
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
        
        
    }
    
    
    private void registrarUsuario(){
        
        Modelo_Usuario modeloUsuario = new Modelo_Usuario();
        VistaRegistroUsuarios vistaRegistroUsuarios = new VistaRegistroUsuarios();
        Controlador_RegistroUsuarios controladorRegUsuarios = new Controlador_RegistroUsuarios(modeloUsuario, vistaRegistroUsuarios);
        
        controladorRegUsuarios.iniciaControl();
    }
}
