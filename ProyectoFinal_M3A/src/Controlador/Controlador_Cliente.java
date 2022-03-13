
/**  @author Bryan Orellana */

package Controlador;

import Modelo.ClaseCliente;
import Modelo.ModeloCliente;
import Vista.VistaRegistroClientes;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Controlador_Cliente {
    private ModeloCliente  modelo;
    private VistaRegistroClientes vista;

    public Controlador_Cliente(ModeloCliente modelo, VistaRegistroClientes vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        vista.setSize(1100,750);
        cargarClientes();
    }
    
    public void iniciarControl(){
        vista.getBtnActualizar().addActionListener(l->cargarClientes());
        vista.getBtnCrear().addActionListener(l->abrirDialogo(1));
        vista.getBtnEditar().addActionListener(l->abrirDialogo(2));
        vista.getBtnEliminar().addActionListener(l->eliminarCliente());
    }
    
    private void abrirDialogo(int ce){
        String title;
        if(ce==1){
            title="CREAR CLIENTE";
            vista.getDlgClientes().setName("crear");
            //limpiarCampos();
        }else{
            title="EDITAR CLIENTE";
            vista.getDlgClientes().setName("editar");
            //modificar();
            //cargarPersonas();
        }
        vista.getDlgClientes().setLocationRelativeTo(vista);
        vista.getDlgClientes().setSize(600,600);
        vista.getDlgClientes().setTitle(title);
        vista.getDlgClientes().setVisible(true);
        vista.getDlgClientes().setLocationRelativeTo(vista);
    }
    
    private void crearEditarClientes(){
        
        if(vista.getDlgClientes().getName()=="crear"){
            //crear
                    
            String cedula=vista.getTxtCedula().getText();
            String nombre=vista.getTxtNombre().getText();
            String apellido=vista.getTxtApellido().getText();
            String direccion=vista.getTxtDireccion().getText();
            String telefono = vista.getTxtTelefono().getText();
            String email =vista.getTxtEmail().getText();
            
            ModeloCliente cliente = new ModeloCliente();
            
            cliente.setCedula(cedula);
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setDireccion(direccion);
            cliente.setTelefono(Integer.parseInt(String.valueOf(telefono)));
            cliente.setEmail(email);

            if(cliente.crearCliente()){
                JOptionPane.showMessageDialog(vista, "Creado exitosamente");
                vista.getDlgClientes().setVisible(false);
            }else{
                JOptionPane.showMessageDialog(vista, "No se creo");
            }
        }else if(vista.getDlgClientes().getName()=="editar"){
            
            ModeloCliente ec = new ModeloCliente();
            
            ec.setCedula(vista.getTxtCedula().getText());
            ec.setNombre(vista.getTxtNombre().getText());
            ec.setApellido(vista.getTxtApellido().getText());
            ec.setDireccion(vista.getTxtDireccion().getText());
            ec.setTelefono(Integer.parseInt(String.valueOf(vista.getTxtTelefono().getText())));
            ec.setEmail(vista.getTxtEmail().getText());
            
            if(ec.editarCliente()){
                JOptionPane.showMessageDialog(vista, "Editado exitosamente");
                vista.getDlgClientes().setVisible(false);
            }else{
                JOptionPane.showMessageDialog(vista, "No se edito");
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
    
    public void modificar(){
        int select = vista.getTblClientes().getSelectedRow();
        
        if(select!=-1){
            String rsp = vista.getTblClientes().getValueAt(select, 0).toString();
            List<ClaseCliente> tabla = modelo.listarClientes();
            
            for(int j= 0; j<tabla.size(); j++){
                if(tabla.get(j).getCedula().equals(rsp)){
                    vista.getTxtCedula().setText(tabla.get(j).getCedula());
                    vista.getTxtNombre().setText(tabla.get(j).getNombre());
                    vista.getTxtApellido().setText(tabla.get(j).getApellido());
                    vista.getTxtDireccion().setText(tabla.get(j).getDireccion());
                    vista.getTxtTelefono().setText(String.valueOf(tabla.get(j).getTelefono()));
                    vista.getTxtEmail().setText(tabla.get(j).getEmail());
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(vista, "NO SE SELECCIONO NINGUNA FILA");
        }
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
    
    public void limpiarCampos(){
        vista.getTxtCedula().setText("");
        vista.getTxtNombre().setText("");
        vista.getTxtApellido().setText("");
        vista.getTxtTelefono().setText("");
        vista.getTxtDireccion().setText("");
        vista.getTxtEmail().setText("");
    }
}
