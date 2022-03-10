package Modelo;

import java.awt.Image;
import java.io.FileInputStream;

/**
 *
 * @author Santiago
 */
public class Empleado extends Persona{
   
    private String idEmpleado;
    private String jornada;
    private String horario;
    private String experiencia;
    private String usuario;
    private String contraseña;
    private Image foto;
    private FileInputStream imagen;
    private int largo;

    public Empleado() {
    }

    public Empleado(String idEmpleado, String cedula, String nombre, String apellido, String edad, String genero, String direccion, String telefono, String email, String jornada, String horario, String experiencia, String usuario, String contraseña, Image foto) {
        super(cedula, nombre, apellido, edad, genero, direccion, telefono, email);
        this.idEmpleado = idEmpleado;
        this.jornada = jornada;
        this.horario = horario;
        this.experiencia = experiencia;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.foto = foto;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
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
