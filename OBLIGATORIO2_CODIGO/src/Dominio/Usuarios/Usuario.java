package Dominio.Usuarios;

public abstract class Usuario {
    private String cedula;
    private String password;
    private String nombre;

    public Usuario(String cedula, String password, String nombre) {
        this.cedula = cedula;
        this.password = password;
        this.nombre = nombre;
    }
    
    public String getCedula() {
        return cedula;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }
}
