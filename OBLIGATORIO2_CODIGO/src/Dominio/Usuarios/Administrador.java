package Dominio.Usuarios;

import Dominio.Usuarios.Usuario;

public class Administrador extends Usuario {
    private String email;

    public Administrador(String email, String cedula, String password, String nombre) {
        super(cedula, password, nombre);
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }
}
