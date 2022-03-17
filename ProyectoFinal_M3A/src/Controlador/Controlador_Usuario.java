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
    
    
    
    private Modelo_Usuario modelo;
    private VistaLogin vista;

    VistaMenuPrincipal vistaMen = new VistaMenuPrincipal();

    public Controlador_Usuario(Modelo_Usuario modelo, VistaLogin vista) {
        this.modelo = modelo;
        this.vista = vista;
    }



    public void iniciaControl() {

        vista.getBtnIniciarSesion().addActionListener(l -> iniciarLogin());

    }

    public void iniciarLogin() {

        
        Modelo_Usuario modUsuario = new Modelo_Usuario();
        
        String contraseña = new String(vista.getTxtContraseña().getPassword());
 
        if(!vista.getTxtUsuario().getText().equals("") && !contraseña.equals("")){
            
            String nuevaContraseña = ClaseHash.sha1(contraseña);
            
            modelo.setUsuario(vista.getTxtUsuario().getText());
            modelo.setContraseña(nuevaContraseña);
            
            if(modUsuario.login(modelo)){
                
                JOptionPane.showMessageDialog(null, "Acceso Correcto");
                
            }else{
                
                JOptionPane.showMessageDialog(null, "Datos Incorrectos");
            }
            
        }else{
            
            JOptionPane.showMessageDialog(null, "Complete todos los campos. Intente nuevamente");
        }
               

    }

    private void limpiarCampos() {


    }

}
