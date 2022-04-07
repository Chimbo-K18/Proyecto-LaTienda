
package Clases;




public class Clase_Pedido {
    
    
   //Variables
   private int idPedidos;
   private String  nombrProducto;
   private int cantidadProd;
   private String cedulaCliente;

   
  
   
//Constructor
   
    
    public Clase_Pedido(int idPedidos, String nombrProducto, int cantidadProd, String cedulaCliente) {
        this.idPedidos = idPedidos;
        this.nombrProducto = nombrProducto;
        this.cantidadProd = cantidadProd;
        this.cedulaCliente = cedulaCliente;
    }

    public Clase_Pedido() {
    }

      //Getters y Setters

    public int getIdPedidos() {
        return idPedidos;
    }

    public void setIdPedidos(int idPedidos) {
        this.idPedidos = idPedidos;
    }

    public String getNombrProducto() {
        return nombrProducto;
    }

    public void setNombrProducto(String nombrProducto) {
        this.nombrProducto = nombrProducto;
    }

    public int getCantidadProd() {
        return cantidadProd;
    }

    public void setCantidadProd(int cantidadProd) {
        this.cantidadProd = cantidadProd;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }
    
   
     
     
   
     
     
     
     
     
     
}
