package Modelo;

import Clases.Clase_Pedido;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diana
 */
public class Modelo_Pedidos extends Clase_Pedido {
//Constructor

    ConectionBDD conexion = new ConectionBDD();

    public Modelo_Pedidos(int idPedidos, String nombrProducto, int cantidadProd, String cedulaCliente) {
        super(idPedidos, nombrProducto, cantidadProd, cedulaCliente);
    }

    public Modelo_Pedidos() {
    }

    public boolean InsertarPedido() {

        String sql;
        sql = "INSERT INTO pedidos(\n"
                + "            orden, producto, cantidad, cliente)\n"
                + "    VALUES ('" + getIdPedidos() + "', '" + getNombrProducto() + "', '" + getCantidadProd() + "', '" + getCedulaCliente() + "');";
        return conexion.accion(sql);

    }

    public String GenerarIdPedido() {

        String serie = "";
        try {

            String nsql = "SELECT MAX(orden)\n"
                    + "  FROM  pedidos;";
            ResultSet Resultados = conexion.consulta(nsql);

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
