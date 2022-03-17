package Controlador;

import Modelo.ClaseHash;
import Modelo.Modelo_Usuario;
import Vista.VistaLogin;
import Vista.VistaRegistroUsuarios;
import javax.swing.JOptionPane;

/**
 *
 * @author Santiago
 */
public class Controlador_NuevoUsuario {

    private Modelo_Usuario modelo;
    private VistaRegistroUsuarios vista;

    public Controlador_NuevoUsuario(Modelo_Usuario modelo, VistaRegistroUsuarios vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);

    }

    public void iniciaControl() {

        vista.getBtnRegistrar().addActionListener(l -> crearUsuario());

    }

    public void crearUsuario() {

        Modelo_Usuario usuario = new Modelo_Usuario();

        String contraseña = new String(vista.getTxtContraseña().getPassword());
        String confirmaContraseña = new String(vista.getTxtConfirmarContraseña().getPassword());

        if (vista.getTxtUsuario().getText().equals("") || contraseña.equals("") || confirmaContraseña.equals("")
                || vista.getTxtNombre().getText().equals("") || vista.getTxtCorreo().getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Debe completar todos los campos");

        } else {

            if (contraseña.equals(confirmaContraseña)) {

                if (modelo.existeUsuario(vista.getTxtUsuario().getText()) == 0) {

                    if (modelo.validarEmail(vista.getTxtCorreo().getText())) {

                        String nuevaContraseña = ClaseHash.sha1(contraseña);

                        usuario.setUsuario(vista.getTxtUsuario().getText());
                        usuario.setContraseña(nuevaContraseña);
                        usuario.setNombre(vista.getTxtNombre().getText());
                        usuario.setCorreo(vista.getTxtCorreo().getText());
                        usuario.setId_tipo(1);

                        if (modelo.registrarUsuario(usuario)) {

                            JOptionPane.showMessageDialog(null, "El registro se realizo con exito");
                            limpiarCampos();

                        } else {

                            JOptionPane.showMessageDialog(null, "Error en el proceso de registro");
                        }

                    } else {
                        
                        JOptionPane.showMessageDialog(null, "El correo electronico no es válido");
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "El usuario ya existe. Intente nuevamente");
                }

            } else {

                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden. Intente nuevamente");
            }

        }

    }

    private void limpiarCampos() {

        vista.getTxtUsuario().setText("");
        vista.getTxtContraseña().setText("");
        vista.getTxtConfirmarContraseña().setText("");
        vista.getTxtNombre().setText("");
        vista.getTxtCorreo().setText("");
    }
}
