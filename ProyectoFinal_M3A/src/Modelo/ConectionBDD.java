
/**  @author Bryan Orellana */

package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConectionBDD {
    
        Connection con;

    String cadConexion = "jdbc:postgresql://localhost:5432/LaTiendaDB";
    String pgUser = "postgres";
    String pgPass = "Chimbo-K18";

    
    public ConectionBDD() {
        try {
            Class.forName("org.postgresql.Driver"); // carga del driver
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConectionBDD.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            con = DriverManager.getConnection(cadConexion, pgUser, pgPass);
            System.out.println("Conexion OK.");
        } catch (SQLException ex) {
            Logger.getLogger(ConectionBDD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    public ResultSet consulta(String sql) {
        try {
            Statement st = con.createStatement();
            return st.executeQuery(sql);           //ejecutamos la sentencia
        } catch (SQLException ex) {
            Logger.getLogger(ConectionBDD.class.getName()).log(Level.SEVERE, null, ex);
            return null; // si hay un problema nos regresa un nulo q quiere decir que hubo un problema en la ejecucion
        }

    }

    public boolean accion(String sql) {
        boolean correcto;
        try {
            Statement st = con.createStatement();
            correcto = st.execute(sql);
            st.close();
            correcto = true;// la consulta va a cerrar la conexion

        } catch (SQLException ex) {
            Logger.getLogger(ConectionBDD.class.getName()).log(Level.SEVERE, null, ex);
            correcto = false;
        }
        return correcto;
    }

    public Connection getCon() {
        return con;
    }

}
