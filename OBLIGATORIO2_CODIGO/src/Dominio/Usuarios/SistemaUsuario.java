package Dominio.Usuarios;

import java.util.ArrayList;
import java.util.List;
import Excepciones.ExcepcionUsuario;

public class SistemaUsuario {
    private List<Usuario> usuarios = new ArrayList();
    private List<Jugador> jugadores = new ArrayList();

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public Administrador loginAdministrador(String cedula, String password) throws ExcepcionUsuario{
        Usuario usuario = this.getUsuario(cedula);
        if(usuario == null) {
            throw new ExcepcionUsuario("Acceso denegado");
        }
        
        if(!usuario.passwordCoincide(password)) {
            throw new ExcepcionUsuario("Acceso denegado");
        }
        
        return (Administrador)usuario;
        
    }

    private Usuario getUsuario(String cedula) {
        int i = 0;
        while(i<usuarios.size()) {
            if(usuarios.get(i).esElUsuario(cedula)) {
                return usuarios.get(i);
            }
            i++;
        }
        return null;
    }

    public void agregarUsuario(Usuario usuario) {
        if(!usuarios.contains(usuario)) usuarios.add(usuario);
    }
    
}
