package Controlador;

import Clases.ClaseHash;
import Clases.ClaseUsuario;
import Modelo.ModeloProductos;
import Modelo.Modelo_Usuario;
import Vista.VistaLogin;
import Vista.VistaMenuPrincipal;
import Vista.VistaRegistroProductos;
import Vista.VistaRegistroUsuarios;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Santiago
 */
public class Controlador_Login {

    private VistaLogin vistaInicio;
    private Modelo_Usuario modelo;

    public Controlador_Login(VistaLogin vistaInicio) {
        this.vistaInicio = vistaInicio;
        vistaInicio.setVisible(true);
    }

    public void iniciaControl() {

     
        vistaInicio.getBtnIniciarSesion().addActionListener(l -> iniciarSistema());

    }

    private void registrarUsuario() {

        Modelo_Usuario modeloUsuario = new Modelo_Usuario();
        VistaRegistroUsuarios vistaRegistroUsuarios = new VistaRegistroUsuarios();
        Controlador_NuevoUsuario controladorRegUsuarios = new Controlador_NuevoUsuario(modeloUsuario, vistaRegistroUsuarios);

        controladorRegUsuarios.iniciaControl();
    }
  
    private void iniciarSistema() {
        

        Modelo_Usuario modUsuario = new Modelo_Usuario();
        ClaseUsuario mod = new ClaseUsuario();

        //Date date = new Date();
        //DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        String contraseña = new String(vistaInicio.getTxtContraseña().getPassword());

        if (!vistaInicio.getTxtUsuario().getText().equals("") && !contraseña.equals("")) {

            String nuevaContraseña = ClaseHash.sha1(contraseña);

            modUsuario.setUsuario(vistaInicio.getTxtUsuario().getText());
            modUsuario.setContraseña(nuevaContraseña);
            //modUsuario.setUltima_sesion(fechaHora.format(date));

            if (modUsuario.login(modelo)) {

                VistaMenuPrincipal vista = new VistaMenuPrincipal();
                Controlador_MenuPrincipal controla = new Controlador_MenuPrincipal(vista);
                
                controla.iniciaControl();
                
                vista.getLblNombre().setText(modUsuario.getNombre());
                vista.getLblTipoUsuario().setText(modUsuario.getNombre_tipo());
                
                if(modUsuario.getId_tipo() == 1){
                    
                }else if(modUsuario.getId_tipo() == 2){
                    
                    vista.getMenuCrearUsuarios().setVisible(false);
                }

            } else {

                JOptionPane.showMessageDialog(null, "Datos Incorrectos");
            }

        } else {

            JOptionPane.showMessageDialog(null, "Complete todos los campos. Intente nuevamente");
        }

    }

}
