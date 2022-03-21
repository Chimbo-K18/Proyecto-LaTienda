/**  @author Bryan Orellana */

package Modelo;

import java.awt.Image;
import java.io.FileInputStream;

public class ClaseEmpleado {
   
    private int id_empleado;
    private String cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String genero;
    private int edad;
    private int id_usuario;
    private Double salario;
    private Image foto;
    private FileInputStream imagen;
    private int largo;

    public ClaseEmpleado() {
    }

    public ClaseEmpleado(int id_empleado, String cedula, String nombre, String apellido, String direccion, String genero, int edad, int id_usuario, Double salario, Image foto, FileInputStream imagen, int largo) {
        this.id_empleado = id_empleado;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.genero = genero;
        this.edad = edad;
        this.id_usuario = id_usuario;
        this.salario = salario;
        this.foto = foto;
        this.imagen = imagen;
        this.largo = largo;
    }
    

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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
