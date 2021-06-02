package Dominio.Usuarios;

import java.util.ArrayList;
import java.util.List;

public class SistemaUsuario {
    private List<Usuario> usuarios = new ArrayList();
    private List<Jugador> jugadores = new ArrayList();

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }
    
}
