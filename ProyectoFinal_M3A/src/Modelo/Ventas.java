
package Modelo;

import java.util.Date;



public class Ventas {
    
    
   //Variables
   private int idFactura;
   private int idCliente;
   private int idVendedor;
   private Date Fecha;
   private double Total;
   
  
   
//Constructor
    public Ventas(int idFactura, int idCliente, int idVendedor, Date Fecha, double Total) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
        this.Fecha = Fecha;
        this.Total = Total;
    }

    
    public Ventas() {
    }

      //Getters y Setters
    
    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }
    
     
     
   
     
     
     
     
     
     
}
