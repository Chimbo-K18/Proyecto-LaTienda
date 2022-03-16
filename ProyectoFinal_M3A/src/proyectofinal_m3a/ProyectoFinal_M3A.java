
package proyectofinal_m3a;

import Controlador.Controlador_InicioSesion;
import Controlador.Controlador_Login;
import Controlador.Controlador_RegistroUsuarios;
import Vista.VistaLogin;
import Vista.VistaRegistroUsuarios;

/**
 *
 * @author Santiago
 */
public class ProyectoFinal_M3A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      
        VistaLogin vista = new VistaLogin();
        Controlador_Login controlador = new Controlador_Login(vista);
        controlador.iniciaControl();
    }
    
}
