package Modelo;

/**
 *
 * @author Santiago
 */
public class Cliente extends Persona{
    
    private String idCliente;

    public Cliente() {
    }

    public Cliente(String idCliente, String cedula, String nombre, String apellido, String edad, String genero, String direccion, String telefono, String email) {
        super(cedula, nombre, apellido, edad, genero, direccion, telefono, email);
        this.idCliente = idCliente;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    
    
}
