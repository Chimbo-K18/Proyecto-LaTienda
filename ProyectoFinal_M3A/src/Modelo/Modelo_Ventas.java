
package Modelo;

import java.util.Date;

/**
 *
 * @author diana
 */
public class Modelo_Ventas extends Ventas{
//Constructor
    public Modelo_Ventas(int idFactura, int idCliente, int idVendedor, Date Fecha, double Total) {
        super(idFactura, idCliente, idVendedor, Fecha, Total);
    }

    public Modelo_Ventas() {
    }
    
    
    
    
    
    //Método para mostrar datos
    
    /*
       public List <Ventas> listarVentas()
    {
       Ventas ventas= new   Ventas();
        ArrayList <Ventas> listaVentas= new  ArrayList <Ventas> ();
 String nsql = "Select *from factura where id='"+id+"';";
   try{
   ResultSet  Resultados=   conexion.query(nsql); 
       while(Resultados.next()){  
             ventas.setIdFactura(Integer.parseInt(Resultados.getString("  id_factura")));   
             ventas.setIdCliente(Resultados.getString("IdCliente"));
            ventas.setidVendedor(Resultados.getString("idvendedor"));
            ventas.setFecha(Resultados.getDate("fecha"));
   ventas.setTotal(Double.parseDouble(Resultados.getString("total")));
   listaVentas.add(ventas);
       }
          Resultados.close();
          return   listaVentas
   }catch(SQLException e){
        return null;

   }

 } 
    
    
    
    
    
    
    
    
    
    
    */
    
    
    
}


