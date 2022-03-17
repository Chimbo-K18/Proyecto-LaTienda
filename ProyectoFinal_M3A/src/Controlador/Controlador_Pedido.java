package Controlador;
import Modelo.Modelo_Pedidos;
import Vista.VistaRegistroVentas;
import javax.swing.JOptionPane;

public class Controlador_Pedido {
      private VistaRegistroVentas vistaVentas;
     private Modelo_Pedidos modeloPedidos;

    public Controlador_Pedido(VistaRegistroVentas vistaVentas, Modelo_Pedidos modeloPedidos) {
        this.vistaVentas = vistaVentas;
        this.modeloPedidos = modeloPedidos;
    }

    
     
       public void iniciaControl() {
          vistaVentas.getBotonGuardar().addActionListener(l->CrearPedidos());
      
        
     }
     //Método para Insertar datos Pedidos
     public void CrearPedidos(){
     int idPedidos= GenerarSeriePedidos();
     String  nombrProducto=vistaVentas.getTextNombreProduc().getText();
     int cantidadProd=Integer.parseInt(vistaVentas.getTextCantidadPro().getText());
     String cedulaCliente=vistaVentas.getTextIdCliente().getText();
     
      Modelo_Pedidos datosPedidos = new  Modelo_Pedidos();
      datosPedidos.setIdPedidos(idPedidos);
      datosPedidos.setNombrProducto(nombrProducto);
      datosPedidos.setCantidadProd(cantidadProd);
      datosPedidos.setCedulaCliente(cedulaCliente);
      
      if( datosPedidos.InsertarPedido()){
           JOptionPane.showMessageDialog(  vistaVentas, "Datos guardados éxitosamente");
      }else{
         JOptionPane.showMessageDialog(null, "Error al guardar", "Error", JOptionPane.ERROR_MESSAGE); 
      }
      
      
     }
     
     
          //Método para generar IdPedidos
       public int  GenerarSeriePedidos(){
        Modelo_Pedidos pedidos = new  Modelo_Pedidos();
        String serie =pedidos.GenerarIdPedido(); 
        int incremento = Integer.parseInt(serie);
        incremento=incremento+1;
        return incremento;
    }
    
     
}
