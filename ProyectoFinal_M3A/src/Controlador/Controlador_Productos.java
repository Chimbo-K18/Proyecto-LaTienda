package Controlador;

import Modelo.ModeloProductos;
import Clases.ClaseProductos;
import Vista.VistaRegistroProductos;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;

public class Controlador_Productos {

    private VistaRegistroProductos vista;
    private ModeloProductos modelo;
    private JFileChooser jfc;
    private Image foto;
    public static ArrayList<ClaseProductos> listaproductos = new ArrayList();

    public Controlador_Productos(VistaRegistroProductos vista, ModeloProductos modelo) {
        this.vista = vista;
        this.modelo = modelo;
        vista.setVisible(true);
        
    }

    public void iniciaControl() {
        //Estar a la escucha de todos los eventos de la vista 
        //boton actualizar
        KeyListener kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                CargarDisponibilidad(vista.getTxtBuscarRp().getText());

            }
        };
        
        
        MouseListener ml = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {        
            modificarProducto(e);
   
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
        vista.getTxtBuscarRp().addKeyListener(kl);//
        vista.getTablaProductos().addMouseListener(ml);
        //cargarProductos();
        
        //   vista.getBtnNuevoRp().addActionListener(l -> abrirDialogo(1));
        vista.getBtnEditarRp().addActionListener(l -> Modificar());
        vista.getBtnGuardarRp().addActionListener(l -> cargarProductos());
        vista.getBtnAceptar().addActionListener(l -> Crear());

        vista.getBtnEliminarRp().addActionListener(l -> eliminar());
        vista.getBtnExaminar().addActionListener(l -> examinaFoto());
        //vista.getBtnImprimir().addActionListener(l->ImprimirListaProductos());

        
    }

    private void examinaFoto() {
        jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = jfc.showOpenDialog(vista);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image imagen = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(
                        vista.getLblFoto().getWidth(),
                        vista.getLblFoto().getHeight(),
                        Image.SCALE_DEFAULT);

                Icon icono = new ImageIcon(imagen);
                vista.getLblFoto().setIcon(icono);
                vista.getLblFoto().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(Controlador_Productos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void Crear() {

        //int id = Integer.parseInt(vista.getTxtID().getText());
        if (vista.getTxtnombreP().getText().isEmpty() && vista.getTxtStock().getText().isEmpty() && vista.getTxtprecio().getText().isEmpty() && vista.getAreaDescripcion().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Todos los campos deben ser llenados", "Campos Vacios", 2);
        } else {
            if (modelo.ValidarNum(vista.getTxtStock().getText())) {
                if (modelo.validaletras(vista.getTxtnombreP().getText())) {
                    String nombre = vista.getTxtnombreP().getText();
                    double precio = Double.valueOf(vista.getTxtprecio().getText());
                    int stock = Integer.parseInt(vista.getTxtStock().getText());
                    String descripcion = vista.getAreaDescripcion().getText();

                    ModeloProductos producto = new ModeloProductos();
                    //producto.setId(id);
                    producto.setId(producto.contar());
                    producto.setNombre(nombre);
                    producto.setPrecio(precio);
                    producto.setStock(stock);

                    producto.setDescripcion(descripcion);
                    producto.setFoto(foto);

                    if (foto == null) {
                        int devuelve = JOptionPane.showConfirmDialog(vista, "??Seguro que desea guardar sin cargar la imagen?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (devuelve == JOptionPane.YES_OPTION) {

                            try {
                                //Foto
                                FileInputStream img = new FileInputStream(jfc.getSelectedFile());
                                int largo = (int) jfc.getSelectedFile().length();
                                producto.setImagen(img);
                                producto.setLargo(largo);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Controlador_Productos.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            if (producto.crearProductoByte()) {
                                //cargarProductos();
                                limpiarCampos();
                                JOptionPane.showMessageDialog(vista, "Producto Creado Satisfactoriamente");
                            } else {
                                JOptionPane.showMessageDialog(vista, "No se pudo crear el producto");
                            }
                        }

                    } else {

                        JOptionPane.showMessageDialog(vista, "Necesita cargar la imagen del producto");
                    }

                } else {

                    JOptionPane.showMessageDialog(vista, "En el campo de nombre ingrese solo letras");
                }
            } else {

                JOptionPane.showMessageDialog(vista, "En el campo de stock ingrese solo numeros");

            }
        }

    }

    public void Modificar() {
        
        int id = Integer.parseInt(vista.getTxtID().getText());
        String nombre = vista.getTxtnombreP().getText();
        double precio = Double.valueOf(vista.getTxtprecio().getText());
        int stock = Integer.parseInt(vista.getTxtStock().getText());
        String descripcion = vista.getAreaDescripcion().getText();
       
        ModeloProductos producto = new ModeloProductos();
        producto.setId(id);
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setStock(stock);

        producto.setDescripcion(descripcion);
        ImageIcon ic = (ImageIcon) vista.getLblFoto().getIcon();
        producto.setFoto(ic.getImage());

        if (producto.modificar(vista.getTxtID().getText())) {
            //cargarProductos();
            
            JOptionPane.showMessageDialog(vista, "Producto modificado satisfactoriamente");
        } else {
            JOptionPane.showMessageDialog(vista, "No se pudo modificar el producto");
        }
    }

    public void eliminar() {
        List<ClaseProductos> lista = modelo.listarProductos();
        int selec = vista.getTablaProductos().getSelectedRow();//para q aparezca lo q selecciono y saber la posicion 

        if (selec != -1) {
            int confirmar = JOptionPane.showOptionDialog(null, "Esta seguro que desea eliminar el producto", "Confirmacion", JOptionPane.YES_NO_OPTION, 3, null,
                    new Object[]{"Si", "No"}, null);
            if (confirmar == 0) {
                if (modelo.eliminar(lista.get(selec).getId())) {
                    //cargarProductos();
                    JOptionPane.showMessageDialog(vista, "Se ha eliminado satisfactoriamente",
                            "Perfecto", JOptionPane.PLAIN_MESSAGE);
                    // cargarPersonas();
                } else {
                    JOptionPane.showMessageDialog(vista, "No se han guardado los cambios", "Error!", 0);
                }
            }
        } else {
            JOptionPane.showMessageDialog(vista, "DE PRIMERO CLICK ENCIMA EN ALGUN PRODUCTO Y LUEGO EN EDITAR", "AVISO", 2);
        }
    }

    private void cargarProductos() {
 
        vista.getTablaProductos().setDefaultRenderer(Object.class, new ImagenTablaEmpleado());//La manera de renderizar la tabla.
        vista.getTablaProductos().setRowHeight(100);
        //Enlazar el modelo de tabla con mi controlador.
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTablaProductos().getModel();
        tblModel.setNumRows(0);//limpio filas de la tabla.
        List<ClaseProductos> listap = modelo.listarProductos();//Enlazo al Modelo y obtengo los datos
        Holder<Integer> i = new Holder<>(0);//contador para el no. fila
        listap.stream().forEach(pe -> {

            tblModel.addRow(new Object[11]);//Creo una fila vacia/
            vista.getTablaProductos().setValueAt(pe.getId(), i.value, 0);
            vista.getTablaProductos().setValueAt(pe.getNombre(), i.value, 1);
            vista.getTablaProductos().setValueAt(pe.getPrecio(), i.value, 2);
            vista.getTablaProductos().setValueAt(pe.getStock(), i.value, 3);
            vista.getTablaProductos().setValueAt(pe.getDescripcion(), i.value, 4);
            Image foto = pe.getFoto();
            if (foto != null) {

                Image nimg = foto.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icono = new ImageIcon(nimg);
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setIcon(icono);
                vista.getTablaProductos().setValueAt(new JLabel(icono), i.value, 5);

            } else {
                vista.getTablaProductos().setValueAt(null, i.value, 5);
            }
            i.value++;

        });

    }


    private void modificarProducto(MouseEvent evento) {

        int seleccionar = vista.getTablaProductos().rowAtPoint(evento.getPoint());

            vista.getTxtID().setText(String.valueOf(vista.getTablaProductos().getValueAt(seleccionar, 0)));
            vista.getTxtnombreP().setText(String.valueOf(vista.getTablaProductos().getValueAt(seleccionar, 1)));
            vista.getTxtprecio().setText(String.valueOf(vista.getTablaProductos().getValueAt(seleccionar, 2)));
            vista.getTxtStock().setText(String.valueOf(vista.getTablaProductos().getValueAt(seleccionar, 3)));
            vista.getAreaDescripcion().setText(String.valueOf(vista.getTablaProductos().getValueAt(seleccionar, 4)));

            JLabel lbl = (JLabel) vista.getTablaProductos().getValueAt(seleccionar, 5);
            vista.getLblFoto().setIcon(lbl.getIcon());


    }

    public void CargarDisponibilidad(String busqueda) {//buscarProductos
        vista.getTablaProductos().setDefaultRenderer(Object.class, new ImagenTablaEmpleado());//La manera de renderizar la tabla.
        vista.getTablaProductos().setRowHeight(100);
        //Enlazar el modelo de tabla con mi controlador.
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTablaProductos().getModel();
        tblModel.setNumRows(0);//limpio filas de la tabla.
        List<ClaseProductos> listap = modelo.productitos(busqueda);//Enlazo al Modelo y obtengo los datos
        Holder<Integer> i = new Holder<>(0);//contador para el no. fila
        listap.stream().forEach(pe -> {

            tblModel.addRow(new Object[11]);//Creo una fila vacia/
            vista.getTablaProductos().setValueAt(pe.getId(), i.value, 0);
            vista.getTablaProductos().setValueAt(pe.getNombre(), i.value, 1);
            vista.getTablaProductos().setValueAt(pe.getPrecio(), i.value, 2);
            vista.getTablaProductos().setValueAt(pe.getStock(), i.value, 3);
            vista.getTablaProductos().setValueAt(pe.getDescripcion(), i.value, 4);

            Image foto = pe.getFoto();
            if (foto != null) {

                Image nimg = foto.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icono = new ImageIcon(nimg);
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setIcon(icono);
                vista.getTablaProductos().setValueAt(new JLabel(icono), i.value, 5);

            } else {
                vista.getTablaProductos().setValueAt(null, i.value, 5);
            }
            i.value++;
        });

    }

    private void limpiarCampos() {

        //vista.getTxtBuscarCliente().setText(null);
        vista.getTxtID().setText(null);
        vista.getAreaDescripcion().setText(null);
        vista.getTxtnombreP().setText(null);
        vista.getTxtprecio().setText(null);
        vista.getTxtStock().setText(null);

    }

}
