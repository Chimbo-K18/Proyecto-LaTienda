
package proyectofinal_m3a;

import Controlador.Controlador_MenuPrincipal;
import Controlador.Controlador_Productos;
import Modelo.ModeloProductos;
import Vista.VistaMenuPrincipal;
import Vista.VistaRegistroProductos;

/**
 *
 * @author Santiago
 */
public class ProyectoFinal_M3A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      VistaMenuPrincipal vista = new VistaMenuPrincipal();
       Controlador_MenuPrincipal controler = new Controlador_MenuPrincipal(vista); 
       controler.iniciaCotrol();
    
    }
    
}
