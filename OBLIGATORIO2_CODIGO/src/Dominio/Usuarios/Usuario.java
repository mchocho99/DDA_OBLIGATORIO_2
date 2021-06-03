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

    public boolean esElUsuario(String cedula) {
        return this.cedula.equals(cedula);
    }

    public boolean passwordCoincide(String password) {
        return this.password.equals(password);
    }

    @Override
    public boolean equals(Object obj) {
        return ((Usuario)obj).getCedula().equals(this.getCedula());
    }
    
    
}
