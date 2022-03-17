package Controlador;

import Modelo.ModeloProductos;
import Modelo.ClaseProductos;
import Vista.VistaRegistroProductos;
import java.awt.Image;
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

/**
 *
 * @author Equipo
 */
public class Controlador_Productos {

    private VistaRegistroProductos vista;
    private ModeloProductos modelo;
    private JFileChooser jfc;
    public static ArrayList<ClaseProductos> listaproductos = new ArrayList();

    public Controlador_Productos(VistaRegistroProductos vista, ModeloProductos modelo) {
        this.vista = vista;
        this.modelo = modelo;
        vista.setVisible(true);
        System.out.println("VistaREG.PRO");
    }

    public void iniciaControl() {
        //Estar a la escucha de todos los eventos de la vista 
        //boton actualizar

        cargarProductos();
        vista.getBtnNuevoRp().addActionListener(l -> abrirDialogo(1));
        vista.getBtnEditarRp().addActionListener(l -> abrirDialogo(2));
        vista.getBtnGuardarRp().addActionListener(l -> Crear());
        vista.getBtnAceptar().addActionListener(l -> crearEditarProducto());
        vista.getBtnCancelar().addActionListener(l -> cancelar());
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

    private void abrirDialogo(int ce) {
        String title;
        if (ce == 1) {
            title = "Crear nuevo Producto";
            vista.getDialogoProducto().setName("crear");
        } else {
            modificarProducto();
            title = "Editar Producto";
            vista.getDialogoProducto().setName("editar");
        }
        vista.getDialogoProducto().setLocationRelativeTo(null);
        vista.getDialogoProducto().setSize(800, 450);
        vista.getDialogoProducto().setTitle(title);
        vista.getDialogoProducto().setVisible(true);
        vista.getDialogoProducto().setResizable(false);
    }

    private void crearEditarProducto() {
        if (vista.getDialogoProducto().getName() == "crear") {
            Crear();

        }
        if (vista.getDialogoProducto().getName() == "editar") {
            Modificar();
        }
    }

    public void Crear() {
  
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
            cargarProductos();
            vista.getDialogoProducto().setVisible(false);
            JOptionPane.showMessageDialog(vista, "Producto Creado Satisfactoriamente");
        } else {
            JOptionPane.showMessageDialog(vista, "No se pudo crear el producto");
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
            cargarProductos();
            vista.getDialogoProducto().setVisible(false);//cierra el dialogo
            JOptionPane.showMessageDialog(vista, "Producto creada satisfactoriamente");
        } else {
            JOptionPane.showMessageDialog(vista, "No se pudo crear el producto");
        }
    }

    public void eliminar() {
        List<ClaseProductos> lista = modelo.listarProductos();
        int selec = vista.getTablaProductos().getSelectedRow();//para q aparezca lo q selecciono y saber la posicion    
        if (modelo.eliminar(lista.get(selec).getId())) {
            cargarProductos();
            JOptionPane.showMessageDialog(vista, "Se ha eliminado satisfactoriamente",
                    "Perfecto", JOptionPane.PLAIN_MESSAGE);
            // cargarPersonas();
        } else {
            JOptionPane.showMessageDialog(vista, "No se han guardado los cambios", "Error!", 0);
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
            //String[] filap={pe.getIdPersona(),pe.getNombres(),pe.getApellidos(),"25"}; 
            //tblModel.addRow(filap);
        });

    }

    private void modificarProducto() {
        
        JOptionPane.showMessageDialog(null, "Modificar");
//        vista.getTxtID().setVisible(false);
//        ClaseProductos pro = new ClaseProductos();
//        DefaultTableModel tblProductos = (DefaultTableModel) vista.getTablaProductos().getModel();
//        int fila = vista.getTablaProductos().getSelectedRow();
//        if (fila != -1) {
//
//            vista.getTxtID().setText(tblProductos.getValueAt(fila, 0).toString());
//            vista.getTxtnombreP().setText(tblProductos.getValueAt(fila, 1).toString());
//            vista.getTxtprecio().setText(tblProductos.getValueAt(fila, 2).toString());
//
//            vista.getTxtStock().setText(tblProductos.getValueAt(fila, 3).toString());
//            vista.getAreaDescripcion().setText(tblProductos.getValueAt(fila, 4).toString());
//
//            JLabel lbl = (JLabel) tblProductos.getValueAt(fila, 5);
//            vista.getLblFoto().setIcon(lbl.getIcon());
//        } else {
//            JOptionPane.showMessageDialog(vista, "DE PRIMERO CLICK ENCIMA EN ALGUN PRODCUTO Y LUEGO EN EDITAR", "AVISO", 2);
//        }

    }

    private void limpiarCampos() {

        //vista.getTxtBuscarCliente().setText(null);
        vista.getTxtID().setText(null);
        vista.getAreaDescripcion().setText(null);
        vista.getTxtnombreP().setText(null);
        vista.getTxtprecio().setText(null);
        vista.getTxtStock().setText(null);
    }

    private void cancelar() {
        vista.getDialogoProducto().setVisible(false);
    }

}
