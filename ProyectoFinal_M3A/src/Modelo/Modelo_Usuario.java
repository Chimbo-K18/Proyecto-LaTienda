package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class Modelo_Usuario extends ClaseUsuario{
    
    ConectionBDD cpg = new ConectionBDD();

    public Modelo_Usuario() {
    }

    public Modelo_Usuario(int id, String usuario, String contraseña, String nombre, String correo, String ultima_sesion, int id_tipo) {
        super(id, usuario, contraseña, nombre, correo, ultima_sesion, id_tipo);
    }

    public boolean registrarUsuario(Modelo_Usuario usr){
        
        try {
        String sql;
        sql = "INSERT INTO usuarios (usuario, contraseña, nombre, correo, id_tipo)";
        sql += "VALUES(?,?,?,?,?)";
        
            
            PreparedStatement ps = cpg.getCon().prepareStatement(sql);
            
            ps.setString(1, usr.getUsuario());
            ps.setString(2, usr.getContraseña());
            ps.setString(3, usr.getNombre());
            ps.setString(4, usr.getCorreo());
            ps.setInt(5, usr.getId_tipo());
            
            ps.executeUpdate();
            return true;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    
    public boolean eliminarUsuario(String usuario){
        String sql;
        
        sql = "DELETE FROM usuarios WHERE usuario = '" + usuario + "'";
        
        return cpg.accion(sql);
    }
}
