/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class Modelo_DetalleFactura extends Detalle_Factura {

    
    ConectionBDD cpg = new ConectionBDD();
        
    public boolean crearDetalleFactura() {

        try {

            String sql_productos;
            sql_productos = "INSERT INTO detalle_factura (id_detalle, id_factura, id_producto, cantidad, costo_unitario, total)";
            sql_productos += "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = cpg.getCon().prepareStatement(sql_productos);

            ps.setInt(1, getIdDetalle());
            ps.setInt(2, getIdFactura());
            ps.setInt(3, getIdProducto());
            ps.setInt(4, getCantidad());
            ps.setDouble(5, getCosto_unitario());
            ps.setDouble(6, getTotal());

            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_DetalleFactura.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public List<Detalle_Factura> listarProductos() {

        List<Detalle_Factura> listapr = new ArrayList<Detalle_Factura>();

        String sql = " select* from producto";
        ResultSet rs = cpg.consulta(sql);

        try {
            while (rs.next()) {

                Detalle_Factura detalle = new Detalle_Factura();

                detalle.setIdDetalle(rs.getInt("id_detalle"));
                detalle.setIdFactura(rs.getInt("id_factura"));
                detalle.setIdProducto(rs.getInt("id_producto"));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setCosto_unitario(rs.getDouble("costo_unitario"));
                detalle.setTotal(rs.getDouble("total"));

                listapr.add(detalle);

            }

            rs.close();
            return listapr;

        } catch (SQLException ex) {
            Logger.getLogger(Modelo_DetalleFactura.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
