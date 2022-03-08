/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class Modelo_DetalleFactura extends Detalle_Factura{
    
    
    
    public boolean crearDetalleFactura(){
        
        try{
            
        String sql_productos;
        sql_productos = "INSERT INTO detalle_factura (id_detalle, id_factura, id_producto, cantidad, costo_unitario, total)";
        sql_productos += "VALUES (?, ?, ?, ?, ?, ?)";
        
        PreparedStatement ps = cpgp.getCon().prepareStatement(sql_productos);

            ps.setInt(1, getIdDetalle());
            ps.setInt(2, getIdFactura());
            ps.setInt(3, getIdProducto());
            ps.setInt(4, getCantidad());
            ps.setDouble(5, getCosto_unitario());
            ps.setDouble(6, getTotal());
            
            
            ps.executeUpdate();
            return true;
            
        }catch (SQLException ex) {
            Logger.getLogger(Modelo_DetalleFactura.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        
    }
}
