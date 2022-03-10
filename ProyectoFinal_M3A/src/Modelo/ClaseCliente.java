/**  @author Bryan Orellana */

package Modelo;

public class ClaseCliente extends ClasePersona{
    
    private String telefono;
    private String email;

    public ClaseCliente() {
    }

    public ClaseCliente(String telefono, String email, String cedula, String nombre, String apellido, String direccion) {
        super(cedula, nombre, apellido, direccion);
        this.telefono = telefono;
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
