package Controlador;

import Dominio.Juego.TipoFigura;
import Dominio.Usuarios.Jugador;
import gridLayout.ListaPaneles;
import java.util.List;


public interface VistaJuego {
    public void mostrarTitulo(String titulo);
    public void mostrarSaldoJugador(double saldo);
    public void mostrarCartonesJugador(ListaPaneles paneles);
    public void mostrarError(String mensaje);
    public void mostrarEstadoJuego(String estado);
    public void mostrarDatos(List<TipoFigura> figuras, List<Jugador> jugadores, int numeroActual);
}
