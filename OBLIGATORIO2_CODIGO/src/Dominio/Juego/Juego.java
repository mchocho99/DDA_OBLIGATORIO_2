package Dominio.Juego;

import Dominio.Usuarios.Jugador;
import java.util.ArrayList;
import java.util.List;

public class Juego {
    private List<Jugador> jugadores;
    private int cantCartonesEnJuego;
    private int cantNumerosEnJuego;
    
    public Juego() {
        this.jugadores = new ArrayList<>();
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador jugador) {
        if(!this.jugadores.contains(jugador)) {
            this.jugadores.add(jugador);
        }
    }

    public int getCantCartonesEnJuego() {
        return cantCartonesEnJuego;
    }

    public void setCantCartonesEnJuego(int cantCartonesEnJuego) {
        this.cantCartonesEnJuego = cantCartonesEnJuego;
    }

    public int getCantNumerosEnJuego() {
        return cantNumerosEnJuego;
    }

    public void setCantNumerosEnJuego(int cantNumerosEnJuego) {
        this.cantNumerosEnJuego = cantNumerosEnJuego;
    }
    
    
}
