/**  @author Bryan Orellana */

package Modelo;

import java.awt.Image;
import java.io.FileInputStream;

public class ClaseEmpleado extends ClasePersona{
   
    private String usuario;
    private String contraseña;
    private String salario;
    private Image foto;
    private FileInputStream imagen;
    private int largo;

    public ClaseEmpleado() {
    }

    public ClaseEmpleado(String usuario, String contraseña, String salario, Image foto, FileInputStream imagen, int largo, String cedula, String nombre, String apellido, String direccion) {
        super(cedula, nombre, apellido, direccion);
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.salario = salario;
        this.foto = foto;
        this.imagen = imagen;
        this.largo = largo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public FileInputStream getImagen() {
        return imagen;
    }

    public void setImagen(FileInputStream imagen) {
        this.imagen = imagen;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

}
