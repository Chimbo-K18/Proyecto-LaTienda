package Controlador;

import Modelo.ClaseHash;
import Modelo.Modelo_Usuario;
import Vista.VistaLogin;
import Vista.VistaMenuPrincipal;
import Vista.VistaRegistroUsuarios;
import javax.swing.JOptionPane;

/**
 *
 * @author Santiago
 */
public class Controlador_Usuario {

    private VistaLogin vista;


    public Controlador_Usuario(VistaLogin vista, Modelo_Usuario modelo) {
        this.vista = vista;
    }

    public void iniciaControl() {

        vista.getBtnIniciarSesion().addActionListener(l -> iniciarLogin());

    }

    
    public void iniciarLogin(){
        
        VistaLogin vista = new VistaLogin();
        Modelo_Usuario modelo = new Modelo_Usuario();
        Controlador_Login controla = new Controlador_Login(vista);
        
    }


    }




