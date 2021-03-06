/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

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
 * @author Equipo
 */
public class ModeloProductos extends ClaseProductos {

    ConectionBDD cpg = new ConectionBDD();

    public ModeloProductos() {
    }

    public ModeloProductos(int id, String nombre, Double precio, int cantidad, String descripcion) {
        super(id, nombre, precio, cantidad, descripcion);
    }

    public List<ClaseProductos> listarProductos() {
        List<ClaseProductos> lista = new ArrayList<ClaseProductos>();
        try {
            String sql = "Select * from productos;";

            ResultSet rs = cpg.consulta(sql);
            byte[] bytea;
            while (rs.next()) {
                ClaseProductos pro = new ClaseProductos();
                pro.setId(rs.getInt("id_producto"));
                pro.setNombre(rs.getString("nombre"));
                pro.setPrecio(rs.getDouble("precio"));
                pro.setStock(rs.getInt("stock"));
                pro.setDescripcion(rs.getString("descripcion"));
                //Proceso de conversion del formato de la base (Base64) a el formato Image
                //bytea> Bytes Array
                bytea = rs.getBytes("foto");
                if (bytea != null) {
                    //Decodificando del formato de la base.(Base64)

                    //bytea=Base64.decode(bytea,0,bytea.length);
                    try {
                        pro.setFoto(obtenerImagen(bytea));
                    } catch (IOException ex) {
                        Logger.getLogger(ModeloProductos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                lista.add(pro);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProductos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private Image obtenerImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator it = ImageIO.getImageReadersByFormatName("png");
        ImageReader reader = (ImageReader) it.next();
        Object source = bis;
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        param.setSourceSubsampling(1, 1, 0, 0);
        return reader.read(0, param);

    }



    public boolean crearProductoByte() {
        try {
            String sql;
            sql = "INSERT INTO productos (id_producto,nombre,precio,stock,descripcion, foto)";
            sql += "VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = cpg.getCon().prepareStatement(sql);
            ps.setInt(1, getId());
            ps.setString(2, getNombre());
            ps.setDouble(3, getPrecio());
            ps.setInt(4, getStock());
            ps.setString(5, getDescripcion());
            ps.setBinaryStream(6, getImagen(), getLargo());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProductos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean eliminar(int identificador) { //eliminar
        String sql = "delete from productos where \"id_producto\"= '" + identificador + "'";
        return cpg.accion(sql);
    }

    public boolean modificar(String identificador) { //modificar identificador es la llave primaria UPDATE= MODIFICAR
        String sql = "UPDATE public.productos SET nombre='" + getNombre() + "', precio='" + getPrecio() + "', stock='" + getStock() + "', descripcion='" + getDescripcion() + "'WHERE id_producto = '" + identificador + "';";
        return cpg.accion(sql);
    }
    
    public List<ClaseProductos> productitos(String Buscar) {
        try {
            List<ClaseProductos> listaproductos = new ArrayList<ClaseProductos>();
            String sql = "SELECT id_producto, nombre, precio, stock,descripcion, foto  FROM public.productos where  lower(nombre) like lower('%" + Buscar + "%') ;";
            ResultSet rs = cpg.consulta(sql);
            byte[] bytea;
            while (rs.next()) {
                ClaseProductos producto = new ClaseProductos();
                producto.setId(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));      
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setDescripcion(rs.getString("descripcion"));
                
                bytea = rs.getBytes("foto");
                if (bytea != null) {
                    //Decodificando del formato de la base.(Base64)

                    //bytea=Base64.decode(bytea,0,bytea.length);
                    try {
                        producto.setFoto(obtenerImagen(bytea));
                    } catch (IOException ex) {
                        Logger.getLogger(ModeloProductos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                listaproductos.add(producto);

            }
            rs.close();
            return listaproductos;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int contar(){
         try {
             String sql = "select count(id_producto) as numero from productos;";
             ResultSet rs=cpg.consulta(sql);
             while(rs.next()){
                 return rs.getInt("numero")+1;
                 
             }
             return 0;
         } catch (SQLException ex) {
             Logger.getLogger(ModeloProductos.class.getName()).log(Level.SEVERE, null, ex);
         }
         return 0; 
     }
    
    public boolean ValidarNum(String num){
        if(num.matches("[0-9]{1,5}") == true){ 
            return true; 
        } else { 
            return false; 
        } 
    }
    public boolean validaletras(String letra){
        if(letra.matches("[a-zA-Z\\s]{1,50}") == true){ 
            return true; 
        }else{
            return false;
        }
    }
}
