package Modelo;

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
                + "', precio= '" + getCosto_unitario()+ "', total= '" + getTotal() 
                + "' WHERE id = '" + getIdDetalle()+ "'";
        return cpg.accion(sql);

    }

    public boolean eliminarDetalleFactura() {
        String sql = "DELETE FROM  detallefactura "
                + "WHERE id = '" + getIdDetalle()+ "'";
        return cpg.accion(sql);
    }

    public byte[] imagenDeSql(int numero) {
        try {
            String sql = "SELECT  foto "
                    + "FROM public.producto  "
                    + "WHERE id = '" + numero + "';";
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
    
    public boolean creardetallefactura() {
        try {
            String sql = "INSERT INTO public.detallefactura (detalle, factura, producto, cantidad, precio, total)"
                    + "VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = cpg.getCon().prepareStatement(sql);
            ps.setInt(1, getIdFactura());
            ps.setInt(2, getIdFactura());
            ps.setInt(3, getIdProducto());
            ps.setInt(4, getCantidad());
            ps.setDouble(5, getCosto_unitario());
            ps.setDouble(6, getTotal());
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ModeloDetalleFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean restame(){
        try {
            String sql="UPDATE public.producto "
                    + "SET cantidad= ? "
                    + "WHERE id=? ;";
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
            String sql = "SELECT cantidad "
                    + "FROM producto }"
                    + "WHERE id='"+numero+"';";
            ResultSet rs = cpg.consulta(sql);
            while (rs.next()) {
                return rs.getInt("cantidad");

            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
