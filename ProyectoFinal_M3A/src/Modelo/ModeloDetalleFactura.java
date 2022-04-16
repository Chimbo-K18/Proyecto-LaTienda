package Modelo;

import Clases.ClaseDetalleFactura;
import Clases.ClaseCliente;
import Clases.ClaseEmpleado;
import Clases.ClaseProductos;
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
public class ModeloDetalleFactura extends ClaseDetalleFactura {

    ConectionBDD cpg = new ConectionBDD();

    public ModeloDetalleFactura() {
    }

    public ModeloDetalleFactura(int idDetalle, int idFactura, int idProducto, int cantidad, double costo_unitario, double total) {
        super(idDetalle, idFactura, idProducto, cantidad, costo_unitario, total);
    }

    public List<ClaseDetalleFactura> listarDetalleFactura() {
        List<ClaseDetalleFactura> listaDetalleFactura = new ArrayList<ClaseDetalleFactura>();
        try {
            String sql = "select * from detalle_factura";
            ResultSet rs = cpg.consulta(sql);
            while (rs.next()) {
                ClaseDetalleFactura detalleFactura = new ClaseDetalleFactura();
                detalleFactura.setIdDetalle(rs.getInt("iddetallefactura"));
                detalleFactura.setIdFactura(rs.getInt("idfactura"));
                detalleFactura.setIdProducto(rs.getInt("idproducto"));
                detalleFactura.setCantidad(rs.getInt("cantidad"));
                detalleFactura.setCosto_unitario(rs.getDouble("precio"));
                detalleFactura.setTotal(rs.getDouble("total"));

                listaDetalleFactura.add(detalleFactura);
            }
            rs.close();
            return listaDetalleFactura;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDetalleFactura.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean crearDetalleFactura() {

        try {

            String sql_productos;
            sql_productos = "INSERT INTO detalle_factura (id_factura, id_producto, cantidad, precio, total)";
            sql_productos += "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = cpg.getCon().prepareStatement(sql_productos);

            ps.setInt(1, getIdFactura());
            ps.setInt(2, getIdProducto());
            ps.setInt(3, getCantidad());
            ps.setDouble(4, getCosto_unitario());
            ps.setDouble(5, getTotal());

            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ModeloDetalleFactura.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public List<ClaseDetalleFactura> listarProductos() {
        List<ClaseDetalleFactura> listapr = new ArrayList<ClaseDetalleFactura>();
        String sql = " SELECT * FROM productos";
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

    public Image obtenerImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator it = ImageIO.getImageReadersByFormatName("png"); //recuerda buscar un solo formato 
        ImageReader reader = (ImageReader) it.next();
        Object source = bis;
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        param.setSourceSubsampling(1, 1, 0, 0);
        return reader.read(0, param);
    }

    public boolean modificarDetalleFactura() {
        String sql = "UPDATE  detallefactura "
                + "SET factura= '" + getIdFactura() + "',producto= '" + getIdProducto() + "', cantidad= '" + getCantidad()
                + "', precio= '" + getCosto_unitario() + "', total= '" + getTotal()
                + "' WHERE id = '" + getIdDetalle() + "'";
        return cpg.accion(sql);

    }

    public boolean eliminarDetalleFactura() {
        String sql = "DELETE FROM  detallefactura "
                + "WHERE id = '" + getIdDetalle() + "'";
        return cpg.accion(sql);
    }

    public byte[] imagenDeSql(int numero) {
        try {
            String sql = "SELECT  foto "
                    + "FROM public.productos "
                    + "WHERE id_producto = '" + numero + "';";
            ResultSet rs = cpg.consulta(sql);
            byte[] bytea = null;
            while (rs.next()) {
                bytea = rs.getBytes("foto");
            }
            return bytea;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDetalleFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<ClaseProductos> productitos(int numero) {
        try {
            List<ClaseProductos> listaproductos = new ArrayList<ClaseProductos>();
            String sql = "SELECT id_producto, nombre, precio  "
                    + "FROM productos "
                    + "WHERE id_producto = '" + numero + "';";
            ResultSet rs = cpg.consulta(sql);
            while (rs.next()) {
                ClaseProductos producto = new ClaseProductos();
                producto.setId(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
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
            String sql = "SELECT id_producto, nombre, stock  FROM productos where  lower(nombre) like lower('%" + Buscar + "%') ;";
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



    public int contar() {
        try {
            String sql = "SELECT count(id_factura) AS numero "
                    + "FROM facturas;";
            
            ResultSet rs = cpg.consulta(sql);
            while (rs.next()) {
                return rs.getInt("numero") + 1;

            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDetalleFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public boolean controlStock() {
        try {
            String sql = "UPDATE productos "
                    + "SET stock= ? "
                    + "WHERE id_producto=? ;";
            PreparedStatement ps = cpg.getCon().prepareStatement(sql);
            
            ps.setInt(1, getCantidad());
            ps.setInt(2, getIdProducto());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDetalleFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

         public int buscameid(int numero) {
        try {
            String sql = "select stock from productos where id_producto='"+numero+"';";
            ResultSet rs = cpg.consulta(sql);
            while (rs.next()) {
                return rs.getInt("stock");

            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDetalleFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public List<ClaseCliente> BuscarPersona(String busqueda) {

        List<ClaseCliente> lp = new ArrayList<ClaseCliente>();

        try {
            String sql = "select * from clientes where cedula = '" + busqueda + "'";

            ResultSet rs = cpg.consulta(sql);
            byte[] bytea;
            while (rs.next()) {

                ClaseCliente persona = new ClaseCliente();

                persona.setCedula(rs.getString("cedula"));
                persona.setNombre(rs.getString("nombre"));

                lp.add(persona);
            }
            rs.close();
            return lp;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDetalleFactura.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<ClaseProductos> BuscarProducto(String texto) {
        List<ClaseProductos> listaVenta = new ArrayList<ClaseProductos>();

        String sql = "select nombre, precio, stock from productos where CAST(id_producto AS TEXT) LIKE '" + texto + "%' ";

        ResultSet rs = cpg.consulta(sql);
        byte[] bytea;
        try {
            while (rs.next()) {
                ClaseProductos producto = new ClaseProductos();

                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));

                listaVenta.add(producto);

            }
            rs.close();
            return listaVenta;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDetalleFactura.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
        public List<ClaseEmpleado> BuscarEmpleado(String texto) {
        List<ClaseEmpleado> listaVenta = new ArrayList<ClaseEmpleado>();

        String sql = "select id_empleado, nombre from empleados where CAST(cedula AS TEXT) LIKE '" + texto + "%' ";

        ResultSet rs = cpg.consulta(sql);
        byte[] bytea;
        try {
            while (rs.next()) {
                ClaseEmpleado empleado = new ClaseEmpleado();

                empleado.setId_empleado(rs.getInt("id_empleado"));
                empleado.setNombre(rs.getString("nombre"));

                listaVenta.add(empleado);

            }
            rs.close();
            return listaVenta;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDetalleFactura.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
