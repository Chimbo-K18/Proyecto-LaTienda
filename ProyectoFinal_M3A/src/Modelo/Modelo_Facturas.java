/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author byron
 */
public class Modelo_Facturas extends Factura{

    ConctionBDD cpg = new ConctionBDD();
    
    public Modelo_Facturas() {
    }
    
    public boolean crearFactura() {
        String sql;
        sql="INSERT INTO facturas(id_factura,id_cliente,id_empleado,fecha)";
        sql+="VALUES ('" +getIdFactura()+ "' , '" +getIdCliente()+ "' , '" +getIdEmpleado()+ "' ,'" +getFecha()+"')";
        return cpg.accion(sql);

    }
    
    public List <Factura> consultarFacturas(){
        List<Factura>listaFac=new ArrayList<Factura>();
        try {
            
            String sql= "SELECT * from facturas";
            ResultSet rs= cpg.consulta(sql);

            while(rs.next()){
                Factura fac = new Factura();
                fac.setIdFactura(rs.getInt("id_factura"));
                fac.setIdCliente(rs.getInt("id_cliente"));
                fac.setIdEmpleado(rs.getInt("id_empleado"));
                fac.setFecha(rs.getDate("fecha"));

                listaFac.add(fac);
            }
            rs.close();
            return listaFac;
            
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Facturas.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
