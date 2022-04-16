
/**  @author Bryan Orellana */

package Controlador;

import Clases.ClaseCliente;
import Modelo.ModeloCliente;
import Vista.VistaRegistroClientes;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;


public class Controlador_Cliente {
    private ModeloCliente  modelo;
    private VistaRegistroClientes vista;

    public Controlador_Cliente(ModeloCliente modelo, VistaRegistroClientes vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        //vista.setSize(1100,700);
        cargarClientes();
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
                buscarCliente(vista.getTxtBuscar().getText());
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

        vista.getTxtBuscar().addKeyListener(k1);
        vista.getTblClientes().addMouseListener(ml);

        vista.getBtnActualizar().addActionListener(l->cargarClientes());
        vista.getBtnEditar().addActionListener(l-> EditarCliente());
        vista.getBtnEliminar().addActionListener(l->eliminarCliente());
        vista.getBtnOk().addActionListener(l->crearEditarClientes());
    }
    
public void EditarCliente(){
      if(vista.getTxtCedula().getText().equals("")||vista.getTxtNombre().getText().equals("")||
                    vista.getTxtApellido().getText().equals("")||vista.getTxtDireccion().getText().equals("")||
                    vista.getTxtTelefono().getText().equals("")||vista.getTxtEmail().getText().equals("")){ 
                JOptionPane.showMessageDialog(vista, "HAY CAMPOS VACIOS");
                
            }else{ 
                
//                if (modelo.ValidarTelefono(vista.getTxtTelefono().getText())) {
                    if (modelo.validarCorreo(vista.getTxtEmail().getText())) {

                        ModeloCliente ec = new ModeloCliente();

                        ec.setCedula(vista.getTxtCedula().getText());
                        ec.setNombre(vista.getTxtNombre().getText());
                        ec.setApellido(vista.getTxtApellido().getText());
                        ec.setDireccion(vista.getTxtDireccion().getText());
                        ec.setTelefono(Integer.parseInt(String.valueOf(vista.getTxtTelefono().getText())));
                        ec.setEmail(vista.getTxtEmail().getText());

                        if (ec.editarCliente()) {
                            JOptionPane.showMessageDialog(vista, "Editado exitosamente");
                            vista.getDlgClientes().setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(vista, "No se edito");
                        }
                    } else {
                        JOptionPane.showMessageDialog(vista, "El correo no cumple con los parametros");
                    }
//                } else {
//                    JOptionPane.showMessageDialog(vista, "El número de télefono debe contener unicamente valores numericos");
//                }
                cargarClientes();
                    
           }     
    
      }
    private void crearEditarClientes(){
        
     
            //crear
            if(vista.getTxtCedula().getText().equals("")||vista.getTxtNombre().getText().equals("")||
                    vista.getTxtApellido().getText().equals("")||vista.getTxtDireccion().getText().equals("")||
                    vista.getTxtTelefono().getText().equals("")||vista.getTxtEmail().getText().equals("")){ 
                JOptionPane.showMessageDialog(vista, "HAY CAMPOS VACIOS");
                
            }else{    
                if(modelo.existeCliente(vista.getTxtCedula().getText())==0){
                    if(modelo.validarDeCedula(vista.getTxtCedula().getText())){
                        if(modelo.validaOtrosCampoc(vista.getTxtNombre().getText())){
                            if(modelo.validaOtrosCampoc(vista.getTxtApellido().getText())){
                                if(modelo.ValidarTelefono(vista.getTxtTelefono().getText())){

                                    if(modelo.validarCorreo(vista.getTxtEmail().getText())){

                                        String cedula = vista.getTxtCedula().getText();
                                        String nombre = vista.getTxtNombre().getText();
                                        String apellido = vista.getTxtApellido().getText();
                                        String direccion = vista.getTxtDireccion().getText();
                                        String telefono = vista.getTxtTelefono().getText();
                                        String email = vista.getTxtEmail().getText();

                                        ModeloCliente cliente = new ModeloCliente();

                                        cliente.setCedula(cedula);
                                        cliente.setNombre(nombre);
                                        cliente.setApellido(apellido);
                                        cliente.setDireccion(direccion);
                                        cliente.setTelefono(Integer.parseInt(String.valueOf(telefono)));
                                        cliente.setEmail(email);

                                        if (cliente.crearCliente()) {
                                            JOptionPane.showMessageDialog(vista, "Creado exitosamente");
                                            limpiarCampos();
                                        } else {
                                            JOptionPane.showMessageDialog(vista, "No se creo");
                                        }

                                    }else{
                                        JOptionPane.showMessageDialog(vista, "El correo no cumple con los parametros");
                                    }
                               }else{
                                    JOptionPane.showMessageDialog(vista, "El número de télefono debe contener unicamente valores numericos");
                                }
                            }else{
                                    JOptionPane.showMessageDialog(vista, "El número de télefono debe contener unicamente valores numericos");
                                }    
                        }else{
                                JOptionPane.showMessageDialog(vista, "El campo del nombre debe contener solo letras");
                            }
                    }else{
                        JOptionPane.showMessageDialog(vista, "La cédula no es válida");
                    }
                    
               }else{
                        JOptionPane.showMessageDialog(vista, "La cédula ya esta registrada");
                    
           }     
        }
        
       
        
    }
    
    private void cargarClientes(){

        DefaultTableModel tblModel;
        tblModel=(DefaultTableModel)vista.getTblClientes().getModel();
        tblModel.setNumRows(0); //Limpia filas de la tabla
        
        List<ClaseCliente>listap = modelo.listarClientes();
        listap.stream().forEach(pe->{

            String[] filap={pe.getCedula(),pe.getNombre(),pe.getApellido(),
                pe.getDireccion(),String.valueOf(pe.getTelefono()),
                pe.getEmail()};
            tblModel.addRow(filap);
        });
    }
    
    private void modificarProducto(MouseEvent evento) {

        int seleccionar = vista.getTblClientes().rowAtPoint(evento.getPoint());

            vista.getTxtCedula().setText(String.valueOf(vista.getTblClientes().getValueAt(seleccionar, 0)));
            vista.getTxtNombre().setText(String.valueOf(vista.getTblClientes().getValueAt(seleccionar, 1)));
            vista.getTxtApellido().setText(String.valueOf(vista.getTblClientes().getValueAt(seleccionar, 2)));
            vista.getTxtDireccion().setText(String.valueOf(vista.getTblClientes().getValueAt(seleccionar, 3)));
            vista.getTxtTelefono().setText(String.valueOf(vista.getTblClientes().getValueAt(seleccionar, 4)));
            vista.getTxtEmail().setText(String.valueOf(vista.getTblClientes().getValueAt(seleccionar, 5)));

    }

    
    public void eliminarCliente(){
        ModeloCliente cl = new ModeloCliente();
        int fila=vista.getTblClientes().getSelectedRow();

        if(fila==-1){
            JOptionPane.showConfirmDialog(vista, "SELECCIONA UN REGISTRO");
        }else{
            int rsp =0;
            rsp=JOptionPane.showConfirmDialog(vista, "SEGURO QUE DESEAS ELIMINAR EL REGISTRO");

            if(rsp==0){
                String cedula=vista.getTblClientes().getValueAt(fila, 0).toString();
                cl.eliminar(cedula);
                cargarClientes();
            }else{
               JOptionPane.showConfirmDialog(vista, "NO SE ELIMINO"); 
            }
        }
        
    }
    
    private void buscarCliente(String aguja) {
        DefaultTableModel tblModel;
        tblModel=(DefaultTableModel)vista.getTblClientes().getModel();
        tblModel.setNumRows(0); //Limpia filas de la tabla
        
        List<ClaseCliente>listap = modelo.buscar2(aguja);
        listap.stream().forEach(pe->{

            String[] filap={pe.getCedula(),pe.getNombre(),pe.getApellido(),
                pe.getDireccion(),String.valueOf(pe.getTelefono()),
                pe.getEmail()};
            tblModel.addRow(filap);
        });
    
    }
    
    public void limpiarCampos(){
        vista.getTxtCedula().setText("");
        vista.getTxtNombre().setText("");
        vista.getTxtApellido().setText("");
        vista.getTxtTelefono().setText("");
        vista.getTxtDireccion().setText("");
        vista.getTxtEmail().setText("");
    }
}
