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
public class ModeloDetalleFactura extends ClaseDetalleFactura {

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
            Logger.getLogger(ModeloDetalleFactura.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public List<ClaseDetalleFactura> listarProductos() {
        List<ClaseDetalleFactura> listapr = new ArrayList<ClaseDetalleFactura>();
        String sql = " SELECT * FROM producto";
        ResultSet rs = cpg.consulta(sql);

        try {
            while (rs.next()) {
                ClaseDetalleFactura detalle = new ClaseDetalleFactura();
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
            Logger.getLogger(ModeloDetalleFactura.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<ClaseProductos> productitos (int numero) {
        try {
            List<ClaseProductos> listaproductos = new ArrayList<ClaseProductos>();
            String sql = "SELECT id_producto, nombre, descripcion, precio  "
                    + "FROM public.producto "
                    + "WHERE id_producto = '" + numero + "';";
            ResultSet rs = cpg.consulta(sql);
            while (rs.next()) {
                ClaseProductos producto = new ClaseProductos();
                producto.setId(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                listaproductos.add(producto);

            }
            rs.close();
            return listaproductos;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDetalleFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<ClaseProductos> productitos(String Buscar) {
        try {
            List<ClaseProductos> listaproductos = new ArrayList<ClaseProductos>();
            String sql = "SELECT id_producto, nombre, stock  "
                             + "FROM public.producto "
                             + "WHERE lower (nombre) like lower ('%" + Buscar + "%') ;";
            ResultSet rs = cpg.consulta(sql);
            while (rs.next()) {
                ClaseProductos producto = new ClaseProductos();
                producto.setId(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setStock(rs.getInt("stock"));

                listaproductos.add(producto);

            }
            rs.close();
            return listaproductos;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDetalleFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<ClaseCliente> buscarcliente(String Buscar) {
        try {
            List<ClaseCliente> listacliente = new ArrayList<ClaseCliente>();
            String sql = "SELECT nombres, apellidos, telefono "
                    + "FROM public.clientes"
                    + "WHERE cedula = '" + Buscar + "';";
            ResultSet rs = cpg.consulta(sql);
            while (rs.next()) {
                ClaseCliente persona = new ClaseCliente();
                persona.setNombre(rs.getString("nombres"));
                persona.setApellido(rs.getString("apellidos"));
                persona.setTelefono(rs.getInt("telefono"));

                listacliente.add(persona);

            }
            rs.close();
            return listacliente;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDetalleFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int contar() {//Cuenta numFactura
        try {
            String sql = "SELECT count(id) AS numero "
                    + "FROM factura;";
            ResultSet rs = cpg.consulta(sql);
            while (rs.next()) {
                return rs.getInt("numero") + 1;

            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
