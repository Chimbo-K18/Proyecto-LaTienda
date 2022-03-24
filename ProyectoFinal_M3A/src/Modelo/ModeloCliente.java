package Modelo;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 *
 * @author Santiago
 */
public class ModeloCliente extends ClaseCliente{
    
    
        ConectionBDD cpg = new ConectionBDD();
        PreparedStatement ps;
        ResultSet rs;

    public ModeloCliente() {
    }

    public List<ClaseCliente> listarClientes() {
        List<ClaseCliente> lista = new ArrayList<ClaseCliente>();
        try {
            String sql = "SELECT * from clientes";
            ResultSet rs = cpg.consulta(sql);
            byte[] bytea;
            while (rs.next()) {
                ClaseCliente cliente = new ClaseCliente();
                cliente.setCedula(rs.getString("cedula"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setEmail(rs.getString("email"));
                lista.add(cliente);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean crearCliente() {
        String sql;
        sql="INSERT INTO clientes(cedula,nombre,apellido,direccion,telefono,email)";
        sql+="VALUES ('" +getCedula()+ "' , '" +getNombre()+ "' , '" +getApellido()+ "' ,'" +getDireccion()+ "' , '" +getTelefono()+ "','" +getEmail()+ "')";
        
        return cpg.accion(sql);
    }

    public boolean eliminar(String cedula) { //eliminar
        String sql="DELETE FROM persona where clientes='"+cedula+"'";
        return cpg.accion(sql);
    }
    
    public boolean editarCliente(){
        
        String sql="UPDATE clientes SET \n"+
                "cedula='"+getCedula()+"',nombre='"+getNombre()+"',apellido='"+getApellido()+"',direccion='"+getDireccion()+
                "',telefono='"+getTelefono()+"',email='"+getEmail()+"'"+
                "WHERE cedula='"+getCedula()+"';";
        return cpg.accion(sql);
    }
    
    public boolean crearPersonaByte() {
        try {
            String sql;
            sql = "INSERT INTO persona (idpersona, nombres, apellidos, edad, direccion, genero)";
            sql += "VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = cpg.getCon().prepareStatement(sql);

            //ps.setString(4, getEdad());
            ps.setString(5, getDireccion());
            //ps.setString(6, getGenero());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public int existeCliente(String cedula){
        //PreparedStatement ps = null;
        ResultSet rs = null;
        ConectionBDD cpg = new ConectionBDD();
        
        String sql1 = "SELECT count(cedula) FROM clientes WHERE cedula=?";
        
        try {
            PreparedStatement ps = cpg.getCon().prepareStatement(sql1);
            ps.setString(1, cedula);
            rs = ps.executeQuery();
            
            if(rs.next()){
                return rs.getInt(1);
            }
            
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
        
    }
    
    public boolean validarCorreo(String correo){

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correo);
        
        return mather.find();

    }
    
    public boolean ValidarTelefono(String telefono){
        if(telefono.matches("[0-9]{10}") == true){ 
            return true; 
        } else { 
            return false; 
        } 
    }
    
    public boolean validarDeCedula(String cedula) {
        boolean cedulaCorrecta = false;

        try {
            if (cedula.length() == 10) // LongitudCedula
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
                    // Coeficientes de validación cédula
                    // El decimo digito se lo considera dígito verificador
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }

        if (!cedulaCorrecta) {
            System.out.println("La Cédula ingresada es Incorrecta");
        }
        return cedulaCorrecta;
    }
    
    public List<ClaseCliente> buscar2(String aguja) {

        try {
            String sql = " select cedula,nombre,apellido,direccion,telefono,email from clientes WHERE";
            sql += " UPPER(nombre) like UPPER('" + aguja + "%') or ";
            sql += " UPPER(cedula) like UPPER('" + aguja + "%') ";
           // sql += " UPPER(precio) like UPPER('" + aguja + "%')";
            ResultSet rs = cpg.consulta(sql);
            List<ClaseCliente> lp = new ArrayList<ClaseCliente>();
            byte[] bytea;
            while (rs.next()) {
                ClaseCliente cli = new ClaseCliente();
                cli.setCedula(rs.getString("cedula"));
                cli.setNombre(rs.getString("nombre"));
                cli.setApellido(rs.getString("apellido"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setTelefono(rs.getInt("telefono"));
                cli.setEmail(rs.getString("email"));
                lp.add(cli);
            }
            rs.close();
            return lp;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
}
