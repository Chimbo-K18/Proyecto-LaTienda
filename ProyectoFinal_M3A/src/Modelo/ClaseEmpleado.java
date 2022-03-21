/**  @author Bryan Orellana */

package Modelo;

import java.awt.Image;
import java.io.FileInputStream;

public class ClaseEmpleado {
   
    private String cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String usuario;
    private String contraseña;
    private Double salario;
    private Image foto;
    private FileInputStream imagen;
    private int largo;

    public ClaseEmpleado() {
    }

    public ClaseEmpleado(String cedula, String nombre, String apellido, String direccion, String usuario, String contraseña, Double salario, Image foto, FileInputStream imagen, int largo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.salario = salario;
        this.foto = foto;
        this.imagen = imagen;
        this.largo = largo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
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
