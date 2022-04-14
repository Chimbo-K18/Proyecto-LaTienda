/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Clases.ClaseFactura;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ModeloFacturas extends ClaseFactura{

    ConectionBDD cpg = new ConectionBDD();
    
    public ModeloFacturas() {
    }
    
    public boolean crearFactura() {
        String sql;
        sql="INSERT INTO facturas (id_cliente, id_empleado, fecha, total)";
        sql+="VALUES ('" +getIdCliente()+ "' , '" +getIdEmpleado()+ "' ,'" +getFecha()+"' , '"+ getTotal()+"')";
        return cpg.accion(sql);

    }
    
    public List <ClaseFactura> consultarFacturas(){
        List<ClaseFactura>listaFac=new ArrayList<ClaseFactura>();
        try {
            
            String sql= "SELECT * from facturas";
            ResultSet rs= cpg.consulta(sql);

            while(rs.next()){
                ClaseFactura fac = new ClaseFactura();
                fac.setIdFactura(rs.getInt("id_factura"));
                fac.setIdCliente(rs.getString("id_cliente"));
                fac.setIdEmpleado(rs.getInt("id_empleado"));
                fac.setFecha(rs.getString("fecha"));
                fac.setTotal(rs.getDouble("total"));

                listaFac.add(fac);
            }
            rs.close();
            return listaFac;
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeloFacturas.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
