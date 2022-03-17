package Controlador;

import Modelo.ClaseHash;
import Modelo.ModeloProductos;
import Modelo.Modelo_Usuario;
import Vista.VistaLogin;
import Vista.VistaMenuPrincipal;
import Vista.VistaRegistroProductos;
import Vista.VistaRegistroUsuarios;
import javax.swing.JOptionPane;


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
        vistaInicio.getBtnIniciarSesion().addActionListener(l-> iniciarSesion());

    }
    
    
    private void registrarUsuario(){
        
        Modelo_Usuario modeloUsuario = new Modelo_Usuario();
        VistaRegistroUsuarios vistaRegistroUsuarios = new VistaRegistroUsuarios();
        Controlador_NuevoUsuario controladorRegUsuarios = new Controlador_NuevoUsuario(modeloUsuario, vistaRegistroUsuarios);
        
        controladorRegUsuarios.iniciaControl();
    }
    
    
//    private void iniciarSesion(){
//        
//        Modelo_Usuario modUsuario = new Modelo_Usuario();
//        VistaLogin visLogin = new VistaLogin();
//        Controlador_Usuario controladorUsuarios = new Controlador_Usuario(modUsuario, visLogin);
//        
//        controladorUsuarios.iniciaControl();
//    }

    private void iniciarSesion(){
        
        Modelo_Usuario modUsuario = new Modelo_Usuario();
        VistaMenuPrincipal visLogin = new VistaMenuPrincipal();
        
        visLogin.setVisible(true);
      
    }

               

    }
    

