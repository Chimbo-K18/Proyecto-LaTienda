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
public class ModeloCliente extends Cliente{
    
    
        ConctionBDD cpg = new ConctionBDD();//INVOCA A LA CONEXION DE LA BASE DE DATOS

//    public ModeloCliente(String idPersona, String nombres, String apellidos, String edad, String direccion, String genero) {
//        super(idPersona, nombres, apellidos, edad, direccion, genero);
//    }

    public ModeloCliente() {
    }

    public List<Persona> listarPersonas() {
        List<Persona> lista = new ArrayList<Persona>();
        try {
            String sql = "SELECT idpersona, nombres, apellidos, fechanacimiento,substring(cast(age(fechanacimiento) as varchar),1,2) edad , telefono, sexo, sueldo, cupo, foto FROM public.persona;";

            ResultSet rs = cpg.consulta(sql);
            byte[] bytea;
            while (rs.next()) {
                Persona persona = new Persona();
                persona.setIdPersona(rs.getString("idpersona"));
                persona.setNombres(rs.getString("nombres"));
                persona.setApellidos(rs.getString("apellidos"));
                persona.setEdad(rs.getString("edad"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setGenero(rs.getString("genero"));
                //Proceso de conversion del formato de la base (Base64) a el formato Image
                //bytea> Bytes Array
                bytea = rs.getBytes("foto");
                if (bytea != null) {
                    //Decodificando del formato de la base.(Base64)
                    //bytea=Base64.decode(bytea,0,bytea.length);
                    try {
                        persona.setFoto(obtenerImagen(bytea));
                    } catch (IOException ex) {
                        Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                lista.add(persona);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //**********************OBTENER IMAGEN******************************************************
    private Image obtenerImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator it = ImageIO.getImageReadersByFormatName("png");
        ImageReader reader = (ImageReader) it.next();
        Object source = bis;
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        param.setSourceSubsampling(1, 1, 0, 0);
        return reader.read(0, param);

    }

    //**********************CREAR PERSONA******************************************************
    public boolean crearPersona() {
        String sql;
        sql = "INSERT INTO persona (idpersona, nombres, apellidos, edad, direccion, genero)";
        sql += "VALUES('" + getIdPersona() + "',' " + getNombres() + "','" + getApellidos() + "','" + getEdad()+ "','" + getDireccion()+ "',' " + getGenero()+"');";
        return cpg.accion(sql);
    }

    //**********************ELIMINAR PERSONA******************************************************
    public boolean eliminar(String identificador) { //eliminar
        String sql = "DELETE from persona WHERE \"idpersona\"= '" + identificador + "'";
        return cpg.accion(sql);
    }

    //**********************MODIFICAR PERSONA******************************************************
    public boolean modificar(String identificador) { //modificar identificador es la llave primaria UPDATE= MODIFICAR
        String sql =
                "UPDATE public.persona "
                + "SET nombres='" + getNombres() + "', apellidos='" + getApellidos() +"',edad='" + getEdad()+ "', direccion='" + getDireccion()+ "', genero='" + getGenero() 
                + "' WHERE idpersona = '" + identificador + "';";
        return cpg.accion(sql);
    }

    //**********************CREAR PERSONA BYTE******************************************************
    public boolean crearPersonaByte() {
        try {
            String sql;
            sql = "INSERT INTO persona (idpersona, nombres, apellidos, edad, direccion, genero)";
            sql += "VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = cpg.getCon().prepareStatement(sql);
            ps.setString(1, getIdPersona());
            ps.setString(2, getNombres());
            ps.setString(3, getApellidos());
            ps.setString(4, getEdad());
            ps.setString(5, getDireccion());
            ps.setString(6, getGenero());
            ps.setBinaryStream(7, getImagen(), getLargo());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
