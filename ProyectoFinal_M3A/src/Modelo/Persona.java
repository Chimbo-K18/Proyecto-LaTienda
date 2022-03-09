
/**  @author Bryan Orellana */

package Modelo;

import java.awt.Image;
import java.io.FileInputStream;


public class Persona {
    private String idPersona;
    private String nombres;
    private String apellidos;
    private String edad;
    private String direccion;
    private String genero;
    private Image foto; //Foto
    private FileInputStream imagen; //Guardar la foto
    private int largo;

    public Persona(String idPersona, String nombres, String apellidos, String edad, String direccion, String genero) {
        this.idPersona = idPersona;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.direccion = direccion;
        this.genero = genero;
    }

    public Persona() {
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
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

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }
}


