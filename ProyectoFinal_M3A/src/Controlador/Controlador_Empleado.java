package Controlador;

import Modelo.ModeloEmpleado;
import Vista.VistaRegistroEmpleados;

/**
 *
 * @author bryan
 */
public class Controlador_Empleado {
    private ModeloEmpleado  modeloE;
    private VistaRegistroEmpleados vistaE;

    public Controlador_Empleado(ModeloEmpleado modeloE, VistaRegistroEmpleados vistaE) {
        this.modeloE = modeloE;
        this.vistaE = vistaE;
        vistaE.setVisible(true);
        vistaE.setSize(1100,750);
        //cargarEmpleados();
    }
    
    public void iniciarControl(){
        
    }
    
    
}
