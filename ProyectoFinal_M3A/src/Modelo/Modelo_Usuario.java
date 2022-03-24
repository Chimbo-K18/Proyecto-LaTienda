package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Santiago
 */
public class Modelo_Usuario extends ClaseUsuario {

    ConectionBDD cpg = new ConectionBDD();

    public Modelo_Usuario() {
    }

    public Modelo_Usuario(int id, String usuario, String contraseña, String nombre, String correo, String ultima_sesion, int id_tipo) {
        super(id, usuario, contraseña, nombre, correo, ultima_sesion, id_tipo);
    }

    public boolean registrarUsuario(Modelo_Usuario usr) {

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

    public int existeUsuario(String usuario) {

        try {
            String sql;
            sql = "SELECT count(id_usuario) FROM usuarios WHERE usuario = ?";

            PreparedStatement ps = cpg.getCon().prepareStatement(sql);
            ResultSet rs = null;
            ps.setString(1, usuario);

            rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getInt(1);
            }

            return 1;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }

    }

    public boolean login(Modelo_Usuario usua) {
            String sql;
            sql = "SELECT u.id_usuario, u.usuario, u.contraseña, u.nombre, u.id_tipo, t.nombre FROM usuarios AS u "
                    + "INNER JOIN tipousuarios AS t ON u.id_tipo = t.id WHERE usuario = ?";
            ResultSet rs = null;
            
        try {
            
            PreparedStatement ps = cpg.getCon().prepareStatement(sql);
            
            ps.setString(1, getUsuario());
            rs = ps.executeQuery();

            if (rs.next()) {

                if (getContraseña().equals(rs.getString(3))) {

//                    String sqlUpdate = "UPDATE usuarios SET ultima_sesion = ? where id_usuario = ?";
//            
//                    ps = cpg.getCon().prepareStatement(sqlUpdate);
//                    ps.setString(1, getUltima_sesion());
//                    ps.setInt(2, rs.getInt(1));
//                    ps.execute();
                    
                    setId(rs.getInt(1));
                    setNombre(rs.getString(4));
                    setId_tipo(rs.getInt(5));
                    setNombre_tipo(rs.getString(6));

                    return true;

                } else {
                    return false;

                }
            }

            return false;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
//            String sql;
//            sql = "SELECT id_usuario, usuario, contraseña, nombre, id_tipo FROM usuarios WHERE usuario = ?";
//            ResultSet rs = null;
//            
//        try {
//            
//            PreparedStatement ps = cpg.getCon().prepareStatement(sql);
//            
//            ps.setString(1, getUsuario());
//            rs = ps.executeQuery();
//
//            if (rs.next()) {
//
//                if (getContraseña().equals(rs.getString(3))) {
//
////                    String sqlUpdate = "UPDATE usuarios SET ultima_sesion = ? where id_usuario = ?";
////            
////                    ps = cpg.getCon().prepareStatement(sqlUpdate);
////                    ps.setString(1, getUltima_sesion());
////                    ps.setInt(2, rs.getInt(1));
////                    ps.execute();
//                    
//                    setId(rs.getInt(1));
//                    setNombre(rs.getString(4));
//                    setId_tipo(rs.getInt(5));
//
//                    return true;
//
//                } else {
//                    return false;
//
//                }
//            }
//
//            return false;
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Modelo_Usuario.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }

    }
   
    public boolean eliminarUsuario(String usuario) {
        String sql;

        sql = "DELETE FROM usuarios WHERE usuario = '" + usuario + "'";

        return cpg.accion(sql);
    }

    public boolean validarEmail(String correo) {

        Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+´)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = patron.matcher(correo);
        return mather.find();
    }

}
