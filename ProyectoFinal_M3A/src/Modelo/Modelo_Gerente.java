package Modelo;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
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

public class Modelo_Gerente extends ClaseGerente{
   //Conexion
    ConectionBDD conexion = new ConectionBDD();
    //Constructor
    public Modelo_Gerente(String cedulaGerente, String nombreGerente, String apellidoGerente, String direccionGerente, String usuarioGerente, String contraseñaGerente, Double salarioGerente, Image foto, FileInputStream imagen, int largo) {
        super(cedulaGerente, nombreGerente, apellidoGerente, direccionGerente, usuarioGerente, contraseñaGerente, salarioGerente, foto, imagen, largo);
    }
    
    public Modelo_Gerente() {
    }
       
    
    //Mostrar Datos Gerente
      public List <ClaseGerente> listaGerente(){
        List<ClaseGerente>listaGerente=new ArrayList<ClaseGerente>();
        try {
            
            String sql= "SELECT * from empleados";
            ResultSet Resultados= conexion.consulta(sql);
            byte[] bytea;
            while( Resultados.next()){
               ClaseGerente gerente = new ClaseGerente ();
               gerente.setCedulaGerente( Resultados.getString("cedula"));
               gerente.setNombreGerente( Resultados.getString("nombre"));
              gerente.setApellidoGerente( Resultados.getString("apellido"));
              gerente.setDireccionGerente( Resultados.getString("direccion"));
              gerente.setUsuarioGerente( Resultados.getString("usuario"));
              gerente.setContraseñaGerente( Resultados.getString("contraseña"));
                gerente.setSalarioGerente( Resultados.getDouble("salario"));
               //bytea> Bytes Array
                bytea= Resultados.getBytes("foto");
                if (bytea!=null){
                //Decodificando del formato de la base.(Base64)
                
                 //bytea=Base64.decode(bytea,0,bytea.length);
                    try {
                        gerente.setFoto(obtenerImagen(bytea));
                    } catch (IOException ex) {
                        Logger.getLogger(ModeloEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                listaGerente.add(gerente);
            }
            Resultados.close();
            return   listaGerente;
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeloEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
        
    private Image obtenerImagen(byte[] bytes) throws IOException{
        ByteArrayInputStream bis=new ByteArrayInputStream(bytes);
        Iterator it= ImageIO.getImageReadersByFormatName("jpeg");
        ImageReader reader=(ImageReader)it.next();
        Object source=bis;
        ImageInputStream iis=ImageIO.createImageInputStream(source);
        reader.setInput(iis,true);
        ImageReadParam param= reader.getDefaultReadParam();
        param.setSourceSubsampling(1, 1, 0, 0);
        return reader.read(0,param);
    }
    
}
