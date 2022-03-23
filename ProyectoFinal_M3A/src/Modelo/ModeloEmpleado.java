package Modelo;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
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
public class ModeloEmpleado extends ClaseEmpleado{
    ConectionBDD cpg = new ConectionBDD();
    PreparedStatement ps;
    ResultSet rs;

    public ModeloEmpleado() {
    }

    public ModeloEmpleado(int id_empleado, String cedula, String nombre, String apellido, String direccion, String genero, int edad, int id_usuario, Double salario, Image foto, FileInputStream imagen, int largo) {
        super(id_empleado, cedula, nombre, apellido, direccion, genero, edad, id_usuario, salario, foto, imagen, largo);
    }

    public List <ClaseEmpleado> listaEmpleados(){
        List<ClaseEmpleado>lista=new ArrayList<ClaseEmpleado>();
        try {
            
            String sql= "SELECT * from empleados";
            ResultSet rs= cpg.consulta(sql);
            byte[] bytea;
            while(rs.next()){
                ClaseEmpleado empleado = new ClaseEmpleado();
                empleado.setId_empleado(rs.getInt("id_empleado"));
                empleado.setCedula(rs.getString("cedula"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setDireccion(rs.getString("direccion"));
                empleado.setGenero(rs.getString("genero"));
                empleado.setEdad(rs.getInt("edad"));
                empleado.setId_usuario(rs.getInt("id_usuario"));
                empleado.setSalario(rs.getDouble("salario"));
               //bytea> Bytes Array
                bytea=rs.getBytes("foto");
                if (bytea!=null){
                //Decodificando del formato de la base.(Base64)
                
                 //bytea=Base64.decode(bytea,0,bytea.length);
                    try {
                        empleado.setFoto(obtenerImagen(bytea));
                    } catch (IOException ex) {
                        Logger.getLogger(ModeloEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                lista.add(empleado);
            }
            rs.close();
            return lista;
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeloEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private Image obtenerImagen(byte[] bytes) throws IOException{
        ByteArrayInputStream bis=new ByteArrayInputStream(bytes);
        Iterator it= ImageIO.getImageReadersByFormatName("jpeg");
        ImageReader reader=(ImageReader)it.next();
        Object source=bis;
        ImageInputStream iis=ImageIO.createImageInputStream(source);
        reader.setInput(iis,true);
        ImageReadParam param= reader.getDefaultReadParam();
        param.setSourceSubsampling(1, 1, 0, 0);
        return reader.read(0,param);
    }
    
    public boolean crearEmpleado(){
        try {
            String sql;
            sql="INSERT INTO empleados(id_empleado,cedula,nombre,apellido,direccion,genero,edad,id_usuario,salario,foto)";
            sql+="VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cpg.getCon().prepareStatement(sql);
            ps.setInt(1, getId_empleado());
            ps.setString(2, getCedula());
            ps.setString(3, getNombre());
            ps.setString(4, getApellido());
            ps.setString(5, getDireccion());
            ps.setString(6, getGenero());
            ps.setInt(7, getEdad());
            ps.setInt(8, getId_usuario());
            ps.setDouble(9, getSalario());
            ps.setBinaryStream(10,getImagen(),getLargo() );
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    /*public boolean editarEmpleado(){
        
        String sql="UPDATE empleados SET \n"+
                "cedula='"+getCedula()+"',nombre='"+getNombre()+"',apellido='"+getApellido()+"',direccion='"+getDireccion()+
                "',usuario='"+getUsuario()+"',contraseña='"+getContraseña()+"',salario='"+getSalario()+"'"+
                "WHERE cedula='"+getCedula()+"';";
        return cpg.accion(sql);
    }*/
    
    public boolean eliminarEmpleado(String id_empleado){
        String sql="DELETE FROM empleados where cedula='"+id_empleado+"'";
        return cpg.accion(sql);
    }
}
