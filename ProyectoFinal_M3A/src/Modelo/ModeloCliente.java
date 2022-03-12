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
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 *
 * @author Santiago
 */
public class ModeloCliente extends ClaseCliente{
    
    
        ConectionBDD cpg = new ConectionBDD(); //INVOCA A LA CONEXION DE LA BASE DE DATOS
        PreparedStatement ps;
        ResultSet rs;
//    public ModeloCliente(String idPersona, String nombres, String apellidos, String edad, String direccion, String genero) {
//        super(idPersona, nombres, apellidos, edad, direccion, genero);
//    }

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

    //**********************OBTENER IMAGEN******************************************************
    /*private Image obtenerImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator it = ImageIO.getImageReadersByFormatName("png");
        ImageReader reader = (ImageReader) it.next();
        Object source = bis;
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        param.setSourceSubsampling(1, 1, 0, 0);
        return reader.read(0, param);

    }*/

    //**********************CREAR PERSONA******************************************************
    public boolean crearCliente() {
        String sql;
        sql="INSERT INTO clientes(cedula,nombre,apellido,direccion,telefono,email)";
        sql+="VALUES ('" +getCedula()+ "' , '" +getNombre()+ "' , '" +getApellido()+ "' ,'" +getDireccion()+ "' , '" +getTelefono()+ "','" +getEmail()+ "')";
        
        return cpg.accion(sql);
    }

    //**********************ELIMINAR PERSONA******************************************************
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


    //**********************CREAR PERSONA BYTE******************************************************
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

}
