
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
    String cadConexion="jdbc:postgresql://localhost:5432/LaTiendaDB";
    String pgUser="postgres";
    String pgPass="1234";

    public ConectionBDD() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConectionBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con=DriverManager.getConnection(cadConexion,pgUser,pgPass);
            System.out.println("Conecxion OK");
        } catch (SQLException ex) {
            Logger.getLogger(ConectionBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public ResultSet consulta(String sql){ //recibe comando sql y ejecuta
         try {
           
            Statement st = con.createStatement();
            return st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConectionBDD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        }
        
    
        
        public boolean accion(String sql) {

        boolean correcto;
        try {
            Statement st = con.createStatement();
            correcto = st.execute(sql);
            st.close();
            correcto=true;
        } catch (SQLException ex) {
            Logger.getLogger(ConectionBDD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            correcto = false;
        }


        return correcto;
        }
    public Connection getCon() {
        return con;
    }
}
