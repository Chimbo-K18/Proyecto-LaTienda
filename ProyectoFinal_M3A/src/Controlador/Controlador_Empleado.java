package Controlador;

import Modelo.ClaseEmpleado;
import Modelo.ModeloEmpleado;
import Vista.VistaRegistroEmpleados;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;

/**
 *
 * @author bryan
 */
public class Controlador_Empleado {
    private ModeloEmpleado  modeloE;
    private VistaRegistroEmpleados vistaE;
    private JFileChooser jfc;

    public Controlador_Empleado(ModeloEmpleado modeloE, VistaRegistroEmpleados vistaE) {
        this.modeloE = modeloE;
        this.vistaE = vistaE;
        vistaE.setVisible(true);
        vistaE.setSize(1100,750);
        //cargarEmpleados();
    }
    
    public void iniciarControl(){
        vistaE.getBtnCrear().addActionListener(l->abrirDialogoEmpleados(1));
        vistaE.getBtnEditar().addActionListener(l->abrirDialogoEmpleados(2));
        vistaE.getBtnEliminar().addActionListener(l->abrirDialogoEmpleados(1));
        vistaE.getBtnActualizar().addActionListener(l->cargarEmpleados());
        vistaE.getBtnExaminar().addActionListener(l->examinaFoto());
    }
    
    private void abrirDialogoEmpleados(int ce){
        String title;
        if(ce==1){
            title="CREAR EMPLEADO";
            vistaE.getDlgEmpleados().setName("crear");
            //limpiarCampos();
        }else{
            title="EDITAR EMPLEADO";
            vistaE.getDlgEmpleados().setName("editar");
            //modificar();
            //cargarPersonas();
        }
        vistaE.getDlgEmpleados().setLocationRelativeTo(vistaE);
        vistaE.getDlgEmpleados().setSize(600,600);
        vistaE.getDlgEmpleados().setTitle(title);
        vistaE.getDlgEmpleados().setVisible(true);
        vistaE.getDlgEmpleados().setLocationRelativeTo(vistaE);
        //vista.getBtnSalir().addActionListener(l->salir());
    }
    
    private void crearEditarEmpleado(){
        
        if(vistaE.getDlgEmpleados().getName()=="crear"){
            //crear
            if(vistaE.getTxtCedulaEmpleado().getText().equals("")||vistaE.getTxtNombre().getText().equals("")||vistaE.getTxtApellido().getText().equals("")||vistaE.getTxtDireccion().getText().equals("")||
                    vistaE.getTxtUsuario().getText().equals("")||vistaE.getTxtUsuarioE().getText().equals("")||vistaE.getTxtSalario().getText().equals("")){ 
                JOptionPane.showMessageDialog(vistaE, "HAY CAMPOS VACIOS");
                
            }else{        
                String cedula=vistaE.getTxtCedulaEmpleado().getText();
                String nombre=vistaE.getTxtNombre().getText();
                String apellido=vistaE.getTxtApellido().getText();
                String direccion=vistaE.getTxtDireccion().getText();
                String usuario=vistaE.getTxtUsuario().getText();
                String contra = vistaE.getTxtUsuarioE().getText();
                String salario =vistaE.getTxtSalario().getText();

                ModeloEmpleado empleado = new ModeloEmpleado();

                empleado.setCedula(cedula);
                empleado.setNombre(nombre);
                empleado.setApellido(apellido);
                empleado.setDireccion(direccion);
                empleado.setUsuario(usuario);
                empleado.setContraseña(contra);
                empleado.setSalario(Double.parseDouble(String.valueOf(salario)));
                try {
                    FileInputStream img = new FileInputStream(jfc.getSelectedFile());
                    int largo=(int)jfc.getSelectedFile().length();
                    empleado.setImagen(img);
                    empleado.setLargo(largo);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Controlador_Empleado.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(empleado.crearEmpleado()){
                    JOptionPane.showMessageDialog(vistaE, "Creado exitosamente");
                    vistaE.getDlgEmpleados().setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(vistaE, "No se creo");
                }
           }     
        }else if(vistaE.getDlgEmpleados().getName()=="editar"){
           if(vistaE.getTxtCedulaEmpleado().getText().equals("")||vistaE.getTxtNombre().getText().equals("")||vistaE.getTxtApellido().getText().equals("")||vistaE.getTxtDireccion().getText().equals("")||
                    vistaE.getTxtUsuario().getText().equals("")||vistaE.getTxtUsuarioE().getText().equals("")||vistaE.getTxtSalario().getText().equals("")){ 
                JOptionPane.showMessageDialog(vistaE, "HAY CAMPOS VACIOS");
                
            }else{ 
                ModeloEmpleado emp = new ModeloEmpleado();

                emp.setCedula(vistaE.getTxtCedulaEmpleado().getText());
                emp.setNombre(vistaE.getTxtNombre().getText());
                emp.setApellido(vistaE.getTxtApellido().getText());
                emp.setDireccion(vistaE.getTxtDireccion().getText());
                emp.setUsuario(vistaE.getTxtUsuario().getText());
                emp.setContraseña(vistaE.getTxtUsuarioE().getText());
                emp.setSalario(Double.parseDouble(String.valueOf(vistaE.getTxtSalario().getText())));
                //ep.setFoto((Image) vista.getLblFoto().getIcon());

                if(emp.editarEmpleado()){
                    JOptionPane.showMessageDialog(vistaE, "Editado exitosamente");
                    vistaE.getDlgEmpleados().setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(vistaE, "No se edito");
                }
            }
        }
        
    }
    
    public void modificarEmpleado(){
        int select = vistaE.getTablaEmpleados().getSelectedRow();
        
        if(select!=-1){
            String rsp = vistaE.getTablaEmpleados().getValueAt(select, 0).toString();
            List<ClaseEmpleado> tabla = modeloE.listaEmpleados();
            
            for(int j= 0; j<tabla.size(); j++){
                if(tabla.get(j).getCedula().equals(rsp)){
                    vistaE.getTxtCedulaEmpleado().setText(tabla.get(j).getCedula());
                    vistaE.getTxtNombre().setText(tabla.get(j).getNombre());
                    vistaE.getTxtApellido().setText(tabla.get(j).getApellido());
                    vistaE.getTxtDireccion().setText(tabla.get(j).getDireccion());
                    vistaE.getTxtUsuario().setText(tabla.get(j).getUsuario());
                    vistaE.getTxtUsuarioE().setText(tabla.get(j).getContraseña());
                    vistaE.getTxtSalario().setText(String.valueOf(tabla.get(j).getSalario()));
                    //vista.getLblFoto().setIcon((Icon) tabla.get(j).getFoto());
                    vistaE.getLblFoto().setIcon((Icon) tabla.get(j).getImagen());
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(vistaE, "NO SE SELECCIONO NINGUNA FILA");
        }
    }
    
    public void eliminarEmpleado(){
        ModeloEmpleado elEm = new ModeloEmpleado();
        int fila=vistaE.getTablaEmpleados().getSelectedRow();

        if(fila==-1){
            JOptionPane.showConfirmDialog(vistaE, "SELECCIONA UN REGISTRO");
        }else{
            int rsp =0;
            rsp=JOptionPane.showConfirmDialog(vistaE, "SEGURO QUE DESEAS ELIMINAR EL REGISTRO");
            //cargarPersonas();
            
            if(rsp==0){
                String cedula=vistaE.getTablaEmpleados().getValueAt(fila, 0).toString();
                elEm.eliminarEmpleado(cedula);
                cargarEmpleados();
            }else{
               JOptionPane.showConfirmDialog(vistaE, "NO SE ELIMINO"); 
            }
        }
        
    }
    
    private void examinaFoto(){
        jfc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG,PNG & GIF", "jpg","png","gif");
        jfc.setFileFilter(filtro);
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado=jfc.showOpenDialog(vistaE);
        
        if(estado==JFileChooser.APPROVE_OPTION){
            try {
                Image imagen = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(
                        vistaE.getLblFoto().getWidth(),
                        vistaE.getLblFoto().getHeight(),
                        Image.SCALE_DEFAULT);
                Icon icono = new ImageIcon(imagen);
                vistaE.getLblFoto().setIcon(icono);
                vistaE.getLblFoto().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(Controlador_Empleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void cargarEmpleados(){
        vistaE.getTablaEmpleados().setDefaultRenderer(Object.class, new ImagenTablaEmpleado());//La manera de renderizar la tabla.
        vistaE.getTablaEmpleados().setRowHeight(100);
        
        //Enlazar el modelo de tabla con mi controlador.
        DefaultTableModel tblModel;
        tblModel=(DefaultTableModel)vistaE.getTablaEmpleados().getModel();
        tblModel.setNumRows(0);//limpio filas de la tabla.

        List<ClaseEmpleado> listap=modeloE.listaEmpleados();//Enlazo al Modelo y obtengo los datos
        Holder<Integer> i = new Holder<>(0);//contador para el no. fila
        
        listap.stream().forEach(pe->{

            tblModel.addRow(new Object[8]);//Creo una fila vacia/
            vistaE.getTablaEmpleados().setValueAt(pe.getCedula(), i.value, 0);
            vistaE.getTablaEmpleados().setValueAt(pe.getNombre(), i.value, 1);
            vistaE.getTablaEmpleados().setValueAt(pe.getApellido(), i.value, 2);
            vistaE.getTablaEmpleados().setValueAt(pe.getDireccion(), i.value, 3);
            vistaE.getTablaEmpleados().setValueAt(pe.getUsuario(), i.value, 4);
            vistaE.getTablaEmpleados().setValueAt(pe.getContraseña(), i.value, 5);
            vistaE.getTablaEmpleados().setValueAt(pe.getSalario(), i.value, 6);

            Image foto=pe.getFoto();
            if(foto!=null){
            
                Image nimg= foto.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icono=new ImageIcon(nimg);
                DefaultTableCellRenderer renderer= new DefaultTableCellRenderer();
                renderer.setIcon(icono);
                vistaE.getTablaEmpleados().setValueAt(new JLabel(icono), i.value, 7);
                
            }else{
                 vistaE.getTablaEmpleados().setValueAt(null, i.value, 8);
            }
            i.value++;
        });
    }
    
    public void limpiarCampos(){
        vistaE.getTxtCedulaEmpleado().setText("");
        vistaE.getTxtNombre().setText("");
        vistaE.getTxtApellido().setText("");
        vistaE.getTxtDireccion().setText("");
        vistaE.getTxtUsuario().setText("");
        vistaE.getTxtUsuarioE().setText("");
        vistaE.getTxtSalario().setText("");
        vistaE.getLblFoto().setText("");
    }
}