package Controlador;

import Clases.ClaseEmpleado;
import Modelo.ModeloEmpleado;
import Modelo.Modelo_Usuario;
import Vista.TextPrompt;
import Vista.VistaMenuPrincipal;
import Vista.VistaRegistroEmpleados;
import Vista.VistaRegistroUsuarios;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

    private ModeloEmpleado modeloE;
    private VistaRegistroEmpleados vistaE;
    VistaMenuPrincipal vistaMenu;
    private JFileChooser jfc;
    private Image foto;


    public Controlador_Empleado(ModeloEmpleado modeloE, VistaRegistroEmpleados vistaE) {
        this.modeloE = modeloE;
        this.vistaE = vistaE;
        vistaE.setVisible(true);
    }

    public void iniciarControl() {
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
        
        
        MouseListener ml = new MouseListener() {


            @Override
            public void mouseClicked(MouseEvent e) {
                modificarEmpleado(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
            
        };

            
        vistaE.getTxtBuscar().addKeyListener(k1);
        vistaE.getTablaEmpleados().addMouseListener(ml);

        vistaE.getBtnEliminar().addActionListener(l -> eliminarEmpleado());
        vistaE.getBtnActualizar().addActionListener(l -> cargarEmpleados());
        vistaE.getBtnExaminar().addActionListener(l -> examinaFoto());
        vistaE.getBtnEditar().addActionListener(l -> EditarEmpleado());
        vistaE.getBtnGuardar().addActionListener(l -> crearEditarEmpleado());
        vistaE.getBtnCrearUsuario().addActionListener(l -> crearUsuario());
        vistaE.getBtnAsignarUsuario().addActionListener(l-> numeroIdUsuario());
        dise??oLabels();
        cargarEmpleados();
    }


    public void EditarEmpleado() {

        int fila = vistaE.getTablaEmpleados().getSelectedRow();

        if (fila != -1) {
            
            if (vistaE.getTxtIdEmpleado().getText().equals("") || vistaE.getTxtCedulaEmpleado().getText().equals("") || vistaE.getTxtNombre().getText().equals("") || vistaE.getTxtApellido().getText().equals("") || vistaE.getTxtDireccion().getText().equals("")
                    || vistaE.getTxtEdad().getText().equals("") || vistaE.getTxtSalario().getText().equals("")) {
                JOptionPane.showMessageDialog(vistaE, "HAY CAMPOS VACIOS");

            } else {

                if (modeloE.validarEdad(vistaE.getTxtEdad().getText())) {
//                    if (modeloE.ValidarSalario(vistaE.getTxtSalario().getText())) {
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
                                    JOptionPane.showMessageDialog(vistaE, "El campo de la direcci??n debe contener solo letras");
                                }
                            } else {
                                JOptionPane.showMessageDialog(vistaE, "El campo del apellido debe contener solo letras");
                            }
                        } else {
                            JOptionPane.showMessageDialog(vistaE, "El campo de nombre debe contener solo letras");
                        }
//                    } else {
//                        JOptionPane.showMessageDialog(vistaE, "El salario debe ser un valor numerico");
//                    }
                } else {
                    JOptionPane.showMessageDialog(vistaE, "Debe ser mayor de edad");
                }

            }

        } else {

            JOptionPane.showConfirmDialog(vistaE, "Debe elegir una fila ");
            //cargarPersonas();

//            if(rsp==0){
//              
//           cargarEmpleados();
//                
//            }else{
//               JOptionPane.showConfirmDialog(vistaE, "NO SE ELIMINO"); 
//            }
        }

    }

    private void crearEditarEmpleado() {

        //crear
        if (vistaE.getTxtCedulaEmpleado().getText().equals("") || vistaE.getTxtNombre().getText().equals("") || vistaE.getTxtApellido().getText().equals("") || vistaE.getTxtDireccion().getText().equals("")
                || vistaE.getTxtEdad().getText().equals("") || vistaE.getTxtSalario().getText().equals("")) {
            JOptionPane.showMessageDialog(vistaE, "HAY CAMPOS VACIOS");

        } else {
//            if (modeloE.existeEmpleado(Integer.parseInt(vistaE.getTxtIdEmpleado().getText())) == 0) {
                if (modeloE.validarDeCedula(vistaE.getTxtCedulaEmpleado().getText())) {
                    if (modeloE.validarEdad(vistaE.getTxtEdad().getText())) {
                        if (modeloE.ValidarSalario(vistaE.getTxtSalario().getText())) {
                            if (modeloE.validaOtrosCampoc(vistaE.getTxtNombre().getText())) {
                                //if (modeloE.validaOtrosCampoc(vistaE.getTxtApellido().getText())) {
                                    if (modeloE.validaOtrosCampoc(vistaE.getTxtDireccion().getText())) {

                                        String cedula = vistaE.getTxtCedulaEmpleado().getText();
                                        String nombre = vistaE.getTxtNombre().getText();
                                        String apellido = vistaE.getTxtApellido().getText();
                                        String direccion = vistaE.getTxtDireccion().getText();
                                        String genero = vistaE.getCbSexo().getSelectedItem().toString();
                                        String edad = vistaE.getTxtEdad().getText();
                                        String idusuario = vistaE.getTxtId_Usuario().getText();
                                        String salario = vistaE.getTxtSalario().getText();

                                        ModeloEmpleado empleado = new ModeloEmpleado();
                                        empleado.setId_empleado(empleado.contar());
                                        empleado.setCedula(cedula);
                                        empleado.setNombre(nombre);
                                        empleado.setApellido(apellido);
                                        empleado.setDireccion(direccion);
                                        empleado.setGenero(genero);
                                        empleado.setEdad(Integer.parseInt(String.valueOf(edad)));
                                        empleado.setId_usuario(Integer.parseInt(idusuario));
                                        empleado.setSalario(Double.parseDouble(String.valueOf(salario)));
                                        empleado.setFoto(foto);
                                        if(foto == null){
                                          
                                            try {
                                            FileInputStream img = new FileInputStream(jfc.getSelectedFile());
                                            int largo = (int) jfc.getSelectedFile().length();
                                            empleado.setImagen(img);
                                            empleado.setLargo(largo);
                                        } catch (FileNotFoundException ex) {
                                            Logger.getLogger(Controlador_Empleado.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                            
                                        }
                                        
                                        if (empleado.crearEmpleado()) {
                                            JOptionPane.showMessageDialog(vistaE, "Creado exitosamente");
                                            limpiarCampos();
                                        } else {
                                            JOptionPane.showMessageDialog(vistaE, "No se creo");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(vistaE, "El campo de la direcci??n debe contener solo letras");
                                    }
//                                } else {
//                                    JOptionPane.showMessageDialog(vistaE, "El campo del apellido debe contener solo letras");
//                                }
                            } else {
                                JOptionPane.showMessageDialog(vistaE, "El campo de nombre debe contener solo letras");
                            }
                        } else {
                            JOptionPane.showMessageDialog(vistaE, "El salario debe ser un valor numerico");
                        }
                    } else {
                        JOptionPane.showMessageDialog(vistaE, "Debe ser mayor de edad");
                    }
                } else {
                    JOptionPane.showMessageDialog(vistaE, "C??dula incorrecta");
                }
//            } else {
//                JOptionPane.showMessageDialog(vistaE, "El ID ya existe");
//            }
        }

    }

    public void modificarEmpleado(MouseEvent evento) {
        
        int seleccionar = vistaE.getTablaEmpleados().rowAtPoint(evento.getPoint());

            vistaE.getTxtIdEmpleado().setText(String.valueOf(vistaE.getTablaEmpleados().getValueAt(seleccionar, 0)));
            vistaE.getTxtCedulaEmpleado().setText(String.valueOf(vistaE.getTablaEmpleados().getValueAt(seleccionar, 1)));
            vistaE.getTxtNombre().setText(String.valueOf(vistaE.getTablaEmpleados().getValueAt(seleccionar, 2)));
            vistaE.getTxtApellido().setText(String.valueOf(vistaE.getTablaEmpleados().getValueAt(seleccionar, 3)));
            vistaE.getTxtDireccion().setText(String.valueOf(vistaE.getTablaEmpleados().getValueAt(seleccionar, 4)));
            vistaE.getCbSexo().setSelectedItem(String.valueOf(vistaE.getTablaEmpleados().getValueAt(seleccionar, 5)));
            vistaE.getTxtEdad().setText(String.valueOf(vistaE.getTablaEmpleados().getValueAt(seleccionar, 6)));
            vistaE.getTxtId_Usuario().setText(String.valueOf(vistaE.getTablaEmpleados().getValueAt(seleccionar, 7)));
            vistaE.getTxtSalario().setText(String.valueOf(vistaE.getTablaEmpleados().getValueAt(seleccionar, 8)));

            JLabel lbl = (JLabel) vistaE.getTablaEmpleados().getValueAt(seleccionar, 9);
            vistaE.getLblFoto().setIcon(lbl.getIcon());


    }

    public void eliminarEmpleado() {
        ModeloEmpleado elEm = new ModeloEmpleado();
        int fila = vistaE.getTablaEmpleados().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showConfirmDialog(vistaE, "SELECCIONA UN REGISTRO");
        } else {
            int rsp = 0;
            rsp = JOptionPane.showConfirmDialog(vistaE, "SEGURO QUE DESEAS ELIMINAR EL REGISTRO");
            //cargarPersonas();

            if (rsp == 0) {
                String id_empleado = vistaE.getTablaEmpleados().getValueAt(fila, 0).toString();
                elEm.eliminarEmpleado(id_empleado);
                cargarEmpleados();
            } else {
                JOptionPane.showConfirmDialog(vistaE, "NO SE ELIMINO");
            }
        }

    }

    private void examinaFoto() {
        jfc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG,PNG & GIF", "jpg", "png", "gif");
        jfc.setFileFilter(filtro);
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = jfc.showOpenDialog(vistaE);

        if (estado == JFileChooser.APPROVE_OPTION) {
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

    private void cargarEmpleados() {
        vistaE.getTablaEmpleados().setDefaultRenderer(Object.class, new ImagenTablaEmpleado());//La manera de renderizar la tabla.
        vistaE.getTablaEmpleados().setRowHeight(100);

        //Enlazar el modelo de tabla con mi controlador.
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vistaE.getTablaEmpleados().getModel();
        tblModel.setNumRows(0);//limpio filas de la tabla.

        List<ClaseEmpleado> listap = modeloE.listaEmpleados();//Enlazo al Modelo y obtengo los datos
        Holder<Integer> i = new Holder<>(0);//contador para el no. fila

        listap.stream().forEach(pe -> {

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

            Image foto = pe.getFoto();
            if (foto != null) {

                Image nimg = foto.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icono = new ImageIcon(nimg);
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setIcon(icono);
                vistaE.getTablaEmpleados().setValueAt(new JLabel(icono), i.value, 9);

            } else {
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
        tblModel = (DefaultTableModel) vistaE.getTablaEmpleados().getModel();
        tblModel.setNumRows(0);//limpio filas de la tabla.

        List<ClaseEmpleado> listap = modeloE.buscarEmpleado(aguja);//Enlazo al Modelo y obtengo los datos
        Holder<Integer> i = new Holder<>(0);//contador para el no. fila

        listap.stream().forEach(pe -> {

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

            Image foto = pe.getFoto();
            if (foto != null) {

                Image nimg = foto.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icono = new ImageIcon(nimg);
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setIcon(icono);
                vistaE.getTablaEmpleados().setValueAt(new JLabel(icono), i.value, 9);

            } else {
                vistaE.getTablaEmpleados().setValueAt(null, i.value, 9);
            }
            i.value++;
        });
    }

    public void limpiarCampos() {
        vistaE.getTxtCedulaEmpleado().setText("");
        vistaE.getTxtNombre().setText("");
        vistaE.getTxtApellido().setText("");
        vistaE.getTxtDireccion().setText("");
        vistaE.getTxtEdad().setText("");
        vistaE.getTxtSalario().setText("");
        vistaE.getTxtIdEmpleado().setText("");
        vistaE.getTxtId_Usuario().setText("");

    }

    public void crearUsuario() {

        Modelo_Usuario modeloUsu = new Modelo_Usuario();
        VistaRegistroUsuarios vistaRegistroUsu = new VistaRegistroUsuarios();
        Controlador_NuevoUsuario controladorRegUsuarios = new Controlador_NuevoUsuario(modeloUsu, vistaRegistroUsu);

        controladorRegUsuarios.iniciaControl();
    }

    private void numeroIdUsuario() {

        vistaE.getTxtId_Usuario().setText(modeloE.codigoEmpleado() + "");

    }

    private void dise??oLabels() {

        TextPrompt texto = new TextPrompt("Nombre", vistaE.getTxtNombre());
        TextPrompt texto1 = new TextPrompt("Apellido", vistaE.getTxtApellido());
        TextPrompt texto2 = new TextPrompt("Direccion", vistaE.getTxtDireccion());
        TextPrompt texto3 = new TextPrompt("ID Empleado", vistaE.getTxtIdEmpleado());
        TextPrompt texto7 = new TextPrompt("Edad", vistaE.getTxtEdad());
        TextPrompt texto8 = new TextPrompt("Salario", vistaE.getTxtSalario());
        TextPrompt texto9 = new TextPrompt("C??dula", vistaE.getTxtCedulaEmpleado());
        TextPrompt texto90 = new TextPrompt("Id Usuario", vistaE.getTxtId_Usuario());

    }
}
