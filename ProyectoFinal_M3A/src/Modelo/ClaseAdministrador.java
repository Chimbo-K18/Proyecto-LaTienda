package Modelo;

import java.awt.Image;
import java.io.FileInputStream;


public class ClaseAdministrador {
    private String cedulaGerente;
    private String nombreGerente;
    private String apellidoGerente;
    private String direccionGerente;
    private String usuarioGerente;
    private String contraseñaGerente;
    private Double salarioGerente;
    private Image foto;
    private FileInputStream imagen;
    private int largo;

    public ClaseAdministrador(String cedulaGerente, String nombreGerente, String apellidoGerente, String direccionGerente, String usuarioGerente, String contraseñaGerente, Double salarioGerente, Image foto, FileInputStream imagen, int largo) {
        this.cedulaGerente = cedulaGerente;
        this.nombreGerente = nombreGerente;
        this.apellidoGerente = apellidoGerente;
        this.direccionGerente = direccionGerente;
        this.usuarioGerente = usuarioGerente;
        this.contraseñaGerente = contraseñaGerente;
        this.salarioGerente = salarioGerente;
        this.foto = foto;
        this.imagen = imagen;
        this.largo = largo;
    }

    public ClaseAdministrador() {
    }

    
    public String getCedulaGerente() {
        return cedulaGerente;
    }

    public void setCedulaGerente(String cedulaGerente) {
        this.cedulaGerente = cedulaGerente;
    }

    public String getNombreGerente() {
        return nombreGerente;
    }

    public void setNombreGerente(String nombreGerente) {
        this.nombreGerente = nombreGerente;
    }

    public String getApellidoGerente() {
        return apellidoGerente;
    }

    public void setApellidoGerente(String apellidoGerente) {
        this.apellidoGerente = apellidoGerente;
    }

    public String getDireccionGerente() {
        return direccionGerente;
    }

    public void setDireccionGerente(String direccionGerente) {
        this.direccionGerente = direccionGerente;
    }

    public String getUsuarioGerente() {
        return usuarioGerente;
    }

    public void setUsuarioGerente(String usuarioGerente) {
        this.usuarioGerente = usuarioGerente;
    }

    public String getContraseñaGerente() {
        return contraseñaGerente;
    }

    public void setContraseñaGerente(String contraseñaGerente) {
        this.contraseñaGerente = contraseñaGerente;
    }

    public Double getSalarioGerente() {
        return salarioGerente;
    }

    public void setSalarioGerente(Double salarioGerente) {
        this.salarioGerente = salarioGerente;
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
