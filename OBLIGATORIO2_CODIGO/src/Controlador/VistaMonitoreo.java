package Controlador;

import Dominio.Juego.EstadosJuego;
import Dominio.Juego.Juego;
import Dominio.Usuarios.Jugador;
import gridLayout.Casilla;
import gridLayout.ListaBotonCasilla;
import java.util.List;

public interface VistaMonitoreo {
    public void mostrarJuegos(List<Juego> juegos);
    public void mostrarNumeroJuego(int numeroJuego);
    public void mostrarGanador(String ganador);
    public void mostrarEstadoJuego(EstadosJuego estado);
    public void mostrarCantBolillasSorteadas(int cantidadBolillas);
    public void mostrarJugadores(List<Jugador> jugadores);
    public void mostrarNumerosDelJuego(ListaBotonCasilla casillas);
    public void mostrarNombreQueMarco(String nombreJugador);
}
