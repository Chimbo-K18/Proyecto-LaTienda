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
    Modelo_Usuario modelo;

    public Controlador_Login(VistaLogin vistaInicio) {
        this.vistaInicio = vistaInicio;
        vistaInicio.setVisible(true);
    }

    public void iniciaControl() {

        vistaInicio.getBtnRegistrarse().addActionListener(l -> registrarUsuario());
        vistaInicio.getBtnIniciarSesion().addActionListener(l -> iniciarSesion());

    }

    private void registrarUsuario() {

        Modelo_Usuario modeloUsuario = new Modelo_Usuario();
        VistaRegistroUsuarios vistaRegistroUsuarios = new VistaRegistroUsuarios();
        Controlador_NuevoUsuario controladorRegUsuarios = new Controlador_NuevoUsuario(modeloUsuario, vistaRegistroUsuarios);

        controladorRegUsuarios.iniciaControl();
    }


    private void iniciarSesion(){
        
        VistaMenuPrincipal visLogin = new VistaMenuPrincipal();
        Controlador_MenuPrincipal controlador = new Controlador_MenuPrincipal(visLogin);
        controlador.iniciaControl();
        visLogin.setVisible(true);
      
    }
    
    
    private void abrirMenuPrincipal() {
        
        Modelo_Usuario modUsuario = new Modelo_Usuario();

        String contraseña = new String(vistaInicio.getTxtContraseña().getPassword());

        if (!vistaInicio.getTxtUsuario().getText().equals("") && !contraseña.equals("")) {

            String nuevaContraseña = ClaseHash.sha1(contraseña);

            modelo.setUsuario(vistaInicio.getTxtUsuario().getText());
            modelo.setContraseña(nuevaContraseña);

            if (modUsuario.login(modelo)) {

                JOptionPane.showMessageDialog(null, "Acceso Correcto");
                

            } else {

                JOptionPane.showMessageDialog(null, "Datos Incorrectos");
            }

        } else {

            JOptionPane.showMessageDialog(null, "Complete todos los campos. Intente nuevamente");
        }

    }

}
