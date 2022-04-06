package Controlador;

import Modelo.ClaseEmpleado;
import Modelo.ModeloEmpleado;
import Vista.VistaRegistroEmpleados;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
        cargarEmpleados();
    }
    
    public void iniciarControl(){
        KeyListener k1 = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                cargaLista(vistaE.getTxtBuscar().getText());
            }
        };
        vistaE.getTxtBuscar().addKeyListener(k1);
        vistaE.getBtnCrear().addActionListener(l->abrirDialogoEmpleados(1));
        vistaE.getBtnEditar().addActionListener(l->abrirDialogoEmpleados(2));
        vistaE.getBtnEliminar().addActionListener(l->eliminarEmpleado());
        vistaE.getBtnActualizar().addActionListener(l->cargarEmpleados());
        vistaE.getBtnExaminar().addActionListener(l->examinaFoto());
        vistaE.getBtnGuardar().addActionListener(l->crearEditarEmpleado());
    }
    
    private void abrirDialogoEmpleados(int ce){
        String title;
        if(ce==1){
            title="CREAR EMPLEADO";
            vistaE.getTxtIdEmpleado().setEnabled(true);
            vistaE.getTxtCedulaEmpleado().setEnabled(true);
            vistaE.getLblFoto().setText("");
            vistaE.getDlgEmpleados().setName("crear");
            limpiarCampos();
        }else{
            title="EDITAR EMPLEADO";
            vistaE.getTxtIdEmpleado().setEnabled(false);
            vistaE.getTxtCedulaEmpleado().setEnabled(false);
            vistaE.getDlgEmpleados().setName("editar");
            modificarEmpleado();
            //cargarEmpleados();
        }
        vistaE.getDlgEmpleados().setLocationRelativeTo(vistaE);
        vistaE.getDlgEmpleados().setSize(550,600);
        vistaE.getDlgEmpleados().setTitle(title);
        vistaE.getDlgEmpleados().setVisible(true);
        vistaE.getDlgEmpleados().setLocationRelativeTo(vistaE);
        //vista.getBtnSalir().addActionListener(l->salir());
    }
    
    private void crearEditarEmpleado(){
        
        if(vistaE.getDlgEmpleados().getName()=="crear"){
            //crear
            if(vistaE.getTxtIdEmpleado().getText().equals("")||vistaE.getTxtCedulaEmpleado().getText().equals("")||vistaE.getTxtNombre().getText().equals("")||vistaE.getTxtApellido().getText().equals("")||vistaE.getTxtDireccion().getText().equals("")||
                    vistaE.getTxtEdad().getText().equals("")||vistaE.getTxtSalario().getText().equals("")){ 
                JOptionPane.showMessageDialog(vistaE, "HAY CAMPOS VACIOS");
                
            }else{
                if(modeloE.existeEmpleado(Integer.parseInt(vistaE.getTxtIdEmpleado().getText()))==0){
                    if(modeloE.validarDeCedula(vistaE.getTxtCedulaEmpleado().getText())){
                        if(modeloE.validarEdad(vistaE.getTxtEdad().getText())){
                            if(modeloE.ValidarSalario(vistaE.getTxtSalario().getText())){
                                if(modeloE.validaOtrosCampoc(vistaE.getTxtNombre().getText())){
                                    if(modeloE.validaOtrosCampoc(vistaE.getTxtApellido().getText())){
                                        if(modeloE.validaOtrosCampoc(vistaE.getTxtDireccion().getText())){

                                            String id_empleado=vistaE.getTxtIdEmpleado().getText();
                                            String cedula=vistaE.getTxtCedulaEmpleado().getText();
                                            String nombre=vistaE.getTxtNombre().getText();
                                            String apellido=vistaE.getTxtApellido().getText();
                                            String direccion=vistaE.getTxtDireccion().getText();
                                            String genero=vistaE.getCbSexo().getSelectedItem().toString();
                                            String edad = vistaE.getTxtEdad().getText();
                                            String id_usuario= vistaE.getTxtId_Usuario().getText();
                                            String salario =vistaE.getTxtSalario().getText();

                                            ModeloEmpleado empleado = new ModeloEmpleado();
                                            empleado.setId_empleado(Integer.parseInt(String.valueOf(id_empleado)));
                                            empleado.setCedula(cedula);
                                            empleado.setNombre(nombre);
                                            empleado.setApellido(apellido);
                                            empleado.setDireccion(direccion);
                                            empleado.setGenero(genero);
                                            empleado.setEdad(Integer.parseInt(String.valueOf(edad)));
                                            empleado.setId_usuario(Integer.parseInt(String.valueOf(id_usuario)));
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
                                        }else{
                                                JOptionPane.showMessageDialog(vistaE, "El campo de la dirección debe contener solo letras");
                                            }
                                    }else{
                                            JOptionPane.showMessageDialog(vistaE, "El campo del apellido debe contener solo letras");
                                        }    
                                }else{
                                        JOptionPane.showMessageDialog(vistaE, "El campo de nombre debe contener solo letras");
                                    }
                            }else{
                                    JOptionPane.showMessageDialog(vistaE, "El salario debe ser un valor numerico");
                                }    
                        }else{
                                JOptionPane.showMessageDialog(vistaE, "Debe ser mayor de edad");
                        }    
                   }else{
                            JOptionPane.showMessageDialog(vistaE, "Cédula incorrecta");
                    }
               }else{
                    JOptionPane.showMessageDialog(vistaE, "El ID ya existe");
                }
           }     
        }else if(vistaE.getDlgEmpleados().getName()=="editar"){
           if(vistaE.getTxtIdEmpleado().getText().equals("")||vistaE.getTxtCedulaEmpleado().getText().equals("")||vistaE.getTxtNombre().getText().equals("")||vistaE.getTxtApellido().getText().equals("")||vistaE.getTxtDireccion().getText().equals("")||
                    vistaE.getTxtEdad().getText().equals("")||vistaE.getTxtSalario().getText().equals("")){ 
                JOptionPane.showMessageDialog(vistaE, "HAY CAMPOS VACIOS");
                
            }else{ 
               
                    
                if (modeloE.validarEdad(vistaE.getTxtEdad().getText())) {
                   if (modeloE.ValidarSalario(vistaE.getTxtSalario().getText())) {
                       if (modeloE.validaOtrosCampoc(vistaE.getTxtNombre().getText())) {
                           if (modeloE.validaOtrosCampoc(vistaE.getTxtApellido().getText())) {
                               if (modeloE.validaOtrosCampoc(vistaE.getTxtDireccion().getText())) {
                                   ModeloEmpleado emp = new ModeloEmpleado();
                                   emp.setId_empleado(Integer.parseInt(String.valueOf(vistaE.getTxtIdEmpleado().getText())));
                                   emp.setCedula(vistaE.getTxtCedulaEmpleado().getText());
                                   emp.setNombre(vistaE.getTxtNombre().getText());
                                   emp.setApellido(vistaE.getTxtApellido().getText());
                                   emp.setDireccion(vistaE.getTxtDireccion().getText());
                                   emp.setGenero(vistaE.getCbSexo().getSelectedItem().toString());
                                   emp.setEdad(Integer.parseInt(String.valueOf(vistaE.getTxtEdad().getText())));
                                   emp.setId_usuario(Integer.parseInt(String.valueOf(vistaE.getTxtId_Usuario().getText())));
                                   emp.setSalario(Double.parseDouble(String.valueOf(vistaE.getTxtSalario().getText())));
                                   //ep.setFoto((Image) vista.getLblFoto().getIcon());

                                   //if(emp.editarEmpleado()){
                                   //JOptionPane.showMessageDialog(vistaE, "Editado exitosamente");
                                   // vistaE.getDlgEmpleados().setVisible(false);
                                   //}else{
                                   // JOptionPane.showMessageDialog(vistaE, "No se edito");
                                   //}
                                   if (emp.editarEmpleado()) {
                                       JOptionPane.showMessageDialog(vistaE, "Editado exitosamente");
                                       vistaE.getDlgEmpleados().setVisible(false);
                                   } else {
                                       JOptionPane.showMessageDialog(vistaE, "No se edito");
                                   }
                               } else {
                                   JOptionPane.showMessageDialog(vistaE, "El campo de la dirección debe contener solo letras");
                               }
                           } else {
                               JOptionPane.showMessageDialog(vistaE, "El campo del apellido debe contener solo letras");
                           }
                       } else {
                           JOptionPane.showMessageDialog(vistaE, "El campo de nombre debe contener solo letras");
                       }
                   } else {
                       JOptionPane.showMessageDialog(vistaE, "El salario debe ser un valor numerico");
                   }
               } else {
                   JOptionPane.showMessageDialog(vistaE, "Debe ser mayor de edad");
               }   
                   
               
            }
           cargarEmpleados();
        }
        
    }
    
    public void modificarEmpleado(){
        
        ClaseEmpleado emp = new ClaseEmpleado();
        DefaultTableModel tblEmpleados = (DefaultTableModel) vistaE.getTablaEmpleados().getModel();
        int fila = vistaE.getTablaEmpleados().getSelectedRow();
        if (fila != -1) {

            vistaE.getTxtIdEmpleado().setText(tblEmpleados.getValueAt(fila, 0).toString());
            vistaE.getTxtCedulaEmpleado().setText(tblEmpleados.getValueAt(fila, 1).toString());
            vistaE.getTxtNombre().setText(tblEmpleados.getValueAt(fila, 2).toString());
            vistaE.getTxtApellido().setText(tblEmpleados.getValueAt(fila, 3).toString());
            vistaE.getTxtDireccion().setText(tblEmpleados.getValueAt(fila, 4).toString());
            vistaE.getCbSexo().setSelectedItem(tblEmpleados.getValueAt(fila, 5).toString());
            vistaE.getTxtEdad().setText(tblEmpleados.getValueAt(fila, 6).toString());
            vistaE.getTxtId_Usuario().setText(tblEmpleados.getValueAt(fila, 7).toString());
            vistaE.getTxtSalario().setText(tblEmpleados.getValueAt(fila, 8).toString());

            JLabel lbl = (JLabel) tblEmpleados.getValueAt(fila, 9);
           vistaE.getLblFoto().setIcon(lbl.getIcon());
       } else {
            JOptionPane.showMessageDialog(vistaE, "Seleccione una fila", "AVISO", 2);
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
                String id_empleado=vistaE.getTablaEmpleados().getValueAt(fila, 0).toString();
                elEm.eliminarEmpleado(id_empleado);
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

            tblModel.addRow(new Object[10]);//Creo una fila vacia/
            vistaE.getTablaEmpleados().setValueAt(pe.getId_empleado(), i.value, 0);
            vistaE.getTablaEmpleados().setValueAt(pe.getCedula(), i.value, 1);
            vistaE.getTablaEmpleados().setValueAt(pe.getNombre(), i.value, 2);
            vistaE.getTablaEmpleados().setValueAt(pe.getApellido(), i.value, 3);
            vistaE.getTablaEmpleados().setValueAt(pe.getDireccion(), i.value, 4);
            vistaE.getTablaEmpleados().setValueAt(pe.getGenero(), i.value, 5);
            vistaE.getTablaEmpleados().setValueAt(pe.getEdad(), i.value, 6);
            vistaE.getTablaEmpleados().setValueAt(pe.getId_usuario(), i.value, 7);
            vistaE.getTablaEmpleados().setValueAt(pe.getSalario(), i.value, 8);

            Image foto=pe.getFoto();
            if(foto!=null){
            
                Image nimg= foto.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icono=new ImageIcon(nimg);
                DefaultTableCellRenderer renderer= new DefaultTableCellRenderer();
                renderer.setIcon(icono);
                vistaE.getTablaEmpleados().setValueAt(new JLabel(icono), i.value, 9);
                
            }else{
                 vistaE.getTablaEmpleados().setValueAt(null, i.value, 9);
            }
            i.value++;
        });
    }
    
    private void cargaLista(String aguja) {

       vistaE.getTablaEmpleados().setDefaultRenderer(Object.class, new ImagenTablaEmpleado());//La manera de renderizar la tabla.
        vistaE.getTablaEmpleados().setRowHeight(100);
        
        //Enlazar el modelo de tabla con mi controlador.
        DefaultTableModel tblModel;
        tblModel=(DefaultTableModel)vistaE.getTablaEmpleados().getModel();
        tblModel.setNumRows(0);//limpio filas de la tabla.

        List<ClaseEmpleado> listap=modeloE.buscarEmpleado(aguja);//Enlazo al Modelo y obtengo los datos
        Holder<Integer> i = new Holder<>(0);//contador para el no. fila
        
        listap.stream().forEach(pe->{

            tblModel.addRow(new Object[10]);//Creo una fila vacia/
            vistaE.getTablaEmpleados().setValueAt(pe.getId_empleado(), i.value, 0);
            vistaE.getTablaEmpleados().setValueAt(pe.getCedula(), i.value, 1);
            vistaE.getTablaEmpleados().setValueAt(pe.getNombre(), i.value, 2);
            vistaE.getTablaEmpleados().setValueAt(pe.getApellido(), i.value, 3);
            vistaE.getTablaEmpleados().setValueAt(pe.getDireccion(), i.value, 4);
            vistaE.getTablaEmpleados().setValueAt(pe.getGenero(), i.value, 5);
            vistaE.getTablaEmpleados().setValueAt(pe.getEdad(), i.value, 6);
            vistaE.getTablaEmpleados().setValueAt(pe.getId_usuario(), i.value, 7);
            vistaE.getTablaEmpleados().setValueAt(pe.getSalario(), i.value, 8);

            Image foto=pe.getFoto();
            if(foto!=null){
            
                Image nimg= foto.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icono=new ImageIcon(nimg);
                DefaultTableCellRenderer renderer= new DefaultTableCellRenderer();
                renderer.setIcon(icono);
                vistaE.getTablaEmpleados().setValueAt(new JLabel(icono), i.value, 9);
                
            }else{
                 vistaE.getTablaEmpleados().setValueAt(null, i.value, 9);
            }
            i.value++;
        });
    }
    
    public void limpiarCampos(){
        vistaE.getTxtCedulaEmpleado().setText("");
        vistaE.getTxtNombre().setText("");
        vistaE.getTxtApellido().setText("");
        vistaE.getTxtDireccion().setText("");
        vistaE.getTxtEdad().setText("");
        vistaE.getTxtSalario().setText("");
        vistaE.getTxtIdEmpleado().setText("");
        vistaE.getTxtId_Usuario().setText("");
        vistaE.getLblFoto().setText("");
    }
}