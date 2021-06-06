package Controlador;

import Dominio.Fachada.Fachada;
import Dominio.Juego.Juego;
import Dominio.Usuarios.Jugador;
import IU.IUJuego;

public class ControladorJuego {

    private VistaJuego vista;
    private Fachada fachada = Fachada.getInstancia();
    private Jugador jugador;
    private Juego juego;
    
    public ControladorJuego(VistaJuego vista, Jugador jugador) {
       this.vista = vista;
       this.jugador = jugador;
       //this.juego = fachada.agregarJugadorAlJuego(jugador);
       vista.mostrarTitulo(jugador.getNombre());
    }
    
}
