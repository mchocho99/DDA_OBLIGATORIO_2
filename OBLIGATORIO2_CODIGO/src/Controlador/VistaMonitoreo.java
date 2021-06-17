package Controlador;

import Dominio.Juego.EstadosJuego;
import Dominio.Juego.Juego;
import Dominio.Usuarios.Jugador;
import gridLayout.Casilla;
import gridLayout.ListaCasilla;
import java.util.List;

public interface VistaMonitoreo {
    public void mostrarJuegos(List<Juego> juegos);
    public void mostrarDatosEstaticos(int numeroJuego, int cantidadBolillas);
    public void mostrarDatosDinamicos(EstadosJuego estado, String ganador);
    public void mostrarJugadores(List<Jugador> jugadores);
    public void mostrarNumerosDelJuego(ListaCasilla casillas);
}
