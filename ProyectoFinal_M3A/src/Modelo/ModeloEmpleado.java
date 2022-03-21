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
    
    public boolean editarEmpleado(){
        
        String sql="UPDATE empleados SET \n"+
                "id_empleado='"+getId_empleado()+"',cedula='"+getCedula()+"',nombre='"+getNombre()+"',apellido='"+getApellido()+"',direccion='"+getDireccion()+
                "',genero='"+getGenero()+"',edad='"+getEdad()+"',id_usuario='"+getId_usuario()+"',salario='"+getSalario()+"'"+
                "WHERE id_empleado='"+getId_empleado()+"';";
        return cpg.accion(sql);
    }
    
    public boolean eliminarEmpleado(String id_empleado){
        String sql="DELETE FROM empleados where id_empleado='"+id_empleado+"'";
        return cpg.accion(sql);
    }
    
     public int existeEmpleado(Integer id_empleado){
        //PreparedStatement ps = null;
        ResultSet rs = null;
        ConectionBDD cpg = new ConectionBDD();
        
        String sql1 = "SELECT count(id_empleado) FROM empleados WHERE id_empleado=?";
        
        try {
            PreparedStatement ps = cpg.getCon().prepareStatement(sql1);
            ps.setInt(1, id_empleado);
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
    
    public boolean ValidarSalario(String salario){
        if(salario.matches("[0-9]{1,5}") == true){ 
            return true; 
        } else { 
            return false; 
        } 
    }
    
    public boolean validarEdad(String edad){
        if(Integer.parseInt(edad)>18){
            return true;
        }else{
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
    
    public List<ClaseEmpleado> buscarEmpleado(String aguja) {

        try {
            String sql = " select id_empleado,cedula,nombre,apellido,direccion,genero,edad,id_usuario,salario,foto from empleados WHERE";
            sql += " UPPER(nombre) like UPPER('" + aguja + "%') or ";
            sql += " UPPER(cedula) like UPPER('" + aguja + "%') ";
           // sql += " UPPER(precio) like UPPER('" + aguja + "%')";
            ResultSet rs = cpg.consulta(sql);
            List<ClaseEmpleado> lp = new ArrayList<ClaseEmpleado>();
            byte[] bytea;
            while (rs.next()) {
                ClaseEmpleado emp = new ClaseEmpleado();
                
                emp.setId_empleado(rs.getInt("id_empleado"));
                emp.setCedula(rs.getString("cedula"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApellido(rs.getString("apellido"));
                emp.setDireccion(rs.getString("direccion"));
                emp.setGenero(rs.getString("genero"));
                emp.setEdad(rs.getInt("edad"));
                emp.setId_usuario(rs.getInt("id_usuario"));
                emp.setSalario(rs.getDouble("salario"));
                bytea=rs.getBytes("foto");
                if (bytea!=null){
                //Decodificando del formato de la base.(Base64)
                
                 //bytea=Base64.decode(bytea,0,bytea.length);
                    try {
                       emp.setFoto(obtenerImagen(bytea));
                    } catch (IOException ex) {
                        Logger.getLogger(ModeloEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                lp.add(emp);
            }
            rs.close();
            return lp;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    public boolean validaOtrosCampoc(String campo){
        if(campo.matches("[a-zA-Z\\s]{1,50}") == true){ 
            return true; 
        }else{
            return false;
        }
    }
}
