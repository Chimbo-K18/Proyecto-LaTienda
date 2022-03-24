package Modelo;

/**
 *
 * @author Santiago
 */
public class ClaseUsuario {
    
    private int id;
    private String usuario;
    private String contraseña;
    private String nombre;
    private String correo;
    private String ultima_sesion;
    private int id_tipo;
    private String nombre_tipo;

    public ClaseUsuario() {
    }

    public ClaseUsuario(int id, String usuario, String contraseña, String nombre, String correo, String ultima_sesion, int id_tipo) {
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.correo = correo;
        this.ultima_sesion = ultima_sesion;
        this.id_tipo = id_tipo;
    }

    //ESTE CONSTRUCTOR ESTA CON LA VARIABLE nombre_tipo
    
//    public ClaseUsuario(int id, String usuario, String contraseña, String nombre, String correo, String ultima_sesion, int id_tipo, String nombre_tipo) {
//        this.id = id;
//        this.usuario = usuario;
//        this.contraseña = contraseña;
//        this.nombre = nombre;
//        this.correo = correo;
//        this.ultima_sesion = ultima_sesion;
//        this.id_tipo = id_tipo;
//        this.nombre_tipo = nombre_tipo;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNombre() {
        return nombre;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUltima_sesion() {
        return ultima_sesion;
    }

    public void setUltima_sesion(String ultima_sesion) {
        this.ultima_sesion = ultima_sesion;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }


    
}
