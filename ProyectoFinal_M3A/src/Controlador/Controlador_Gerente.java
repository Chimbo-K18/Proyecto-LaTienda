package Controlador;
import Clases.ClaseAdministrador;
import Modelo.Modelo_Administrador;
import Vista.VistaRegistroEmpleados;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;


public class Controlador_Gerente {
     private VistaRegistroEmpleados vista_Empleado_Gerente;
     private Modelo_Administrador modeloGerente;

 public Controlador_Gerente(VistaRegistroEmpleados vista_Empleado_Gerente, Modelo_Administrador modeloGerente) {
        this.vista_Empleado_Gerente = vista_Empleado_Gerente;
        this.modeloGerente = modeloGerente;
    }
     
 public void iniciaControl(){
       vista_Empleado_Gerente.getBtnActualizar().addActionListener(l->cargarGerentes());
      
        
     }
     
      
          //Mostrar datos en la tabla
      
 private void cargarGerentes(){
    vista_Empleado_Gerente.getTablaEmpleados().setDefaultRenderer(Object.class, new ImagenTablaEmpleado());//La manera de renderizar la tabla.
    vista_Empleado_Gerente.getTablaEmpleados().setRowHeight(100);
        
     //Enlazar el modelo de tabla con el controlador
    DefaultTableModel tblModel;
    tblModel=(DefaultTableModel)vista_Empleado_Gerente.getTablaEmpleados().getModel();
    tblModel.setNumRows(0);//limpiamos las filas de las tablas

    List<ClaseAdministrador> listaGerente=modeloGerente.listaGerente();//Enlazo el modelo y obtengo los datos
    Holder<Integer> i = new Holder<>(0);//contador para el no. fila
        
    listaGerente.stream().forEach(pe->{

    tblModel.addRow(new Object[8]);//Creo una fila vacia/
          vista_Empleado_Gerente.getTablaEmpleados().setValueAt(pe.getCedulaGerente(), i.value, 0);
          vista_Empleado_Gerente.getTablaEmpleados().setValueAt(pe.getNombreGerente(), i.value, 1);
          vista_Empleado_Gerente.getTablaEmpleados().setValueAt(pe.getApellidoGerente(), i.value, 2);
          vista_Empleado_Gerente.getTablaEmpleados().setValueAt(pe.getDireccionGerente(), i.value, 3);
          vista_Empleado_Gerente.getTablaEmpleados().setValueAt(pe.getUsuarioGerente(), i.value, 4);
          vista_Empleado_Gerente.getTablaEmpleados().setValueAt(pe.getContraseñaGerente(), i.value, 5);
          vista_Empleado_Gerente.getTablaEmpleados().setValueAt(pe.getSalarioGerente(), i.value, 6);
   //Obtenemos la foto 
    Image foto=pe.getFoto();
     if(foto!=null){
     Image nimg= foto.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
     ImageIcon icono=new ImageIcon(nimg);
     DefaultTableCellRenderer renderer= new DefaultTableCellRenderer();
     renderer.setIcon(icono);
     vista_Empleado_Gerente.getTablaEmpleados().setValueAt(new JLabel(icono), i.value, 7);}
     else{
     vista_Empleado_Gerente.getTablaEmpleados().setValueAt(null, i.value, 8);  }
     i.value++;});
    }
    
      
     
     
     
     
     
     
     

}
