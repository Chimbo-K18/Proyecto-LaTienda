package Modelo;

import Clases.Clase_Pedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Modelo_Pedidos extends Clase_Pedido {
//Constructor

    ConectionBDD cpg = new ConectionBDD();

    
    public Modelo_Pedidos() {
    }
    
    public Modelo_Pedidos(int idPedidos, String nombrProducto, int cantidadProd, String cedulaCliente) {
        super(idPedidos, nombrProducto, cantidadProd, cedulaCliente);
    }

    public boolean InsertarPedido() {

        try {
        String sql;
        sql = "INSERT INTO pedidos (producto, cantidad, id_cliente)";
        sql += "VALUES (?,?,?);";
    
        
            PreparedStatement ps = cpg.getCon().prepareStatement(sql);
            
            ps.setString(1, getNombrProducto());
            ps.setInt(2, getCantidadProd());
            ps.setString(3, getCedulaCliente());
            
            ps.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Pedidos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public String GenerarIdPedido() {

        String serie = "";
        try {

            String nsql = "SELECT MAX(orden)\n"
                    + "  FROM  pedidos;";
            ResultSet Resultados = cpg.consulta(nsql);

            while (Resultados.next()) {
                serie = Resultados.getString(1);
            }
            Resultados.close();

        } catch (SQLException e) {
            Logger.getLogger(ConectionBDD.class.getName()).log(Level.SEVERE, null, e);
        }

        return serie;

    }

}
