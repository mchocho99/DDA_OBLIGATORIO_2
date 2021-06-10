package Controlador;

import Dominio.Fachada.Fachada;
import Dominio.Juego.Carton;
import Dominio.Juego.Juego;
import Dominio.Usuarios.Jugador;
import IU.gridLayout.ListaPaneles;
import IU.gridLayout.MarcadorCasilla;

public class ControladorJuego implements MarcadorCasilla {

    private VistaJuego vista;
    private Fachada fachada = Fachada.getInstancia();
    private Jugador jugador;
    private Juego juego;
    
    public ControladorJuego(VistaJuego vista, Jugador jugador) {
       this.vista = vista;
       this.jugador = jugador;
       //this.juego = fachada.agregarJugadorAlJuego(jugador);
       vista.mostrarTitulo(jugador.getNombre());
       vista.mostrarSaldoJugador(jugador.getSaldo());
       ListaPaneles paneles = this.generarPaneles();
       vista.mostrarCartonesJugador(paneles);
    }

    private ListaPaneles generarPaneles() {
        int cantFilas = fachada.getCantFilasCarton();
        int cantColumnas = fachada.getCantColumnasCarton();
        
        ListaPaneles listaPaneles = new ListaPaneles(cantFilas, cantColumnas);
        for (Carton carton : jugador.getCartones()) {
            listaPaneles.agregarPanel(carton.getMatrizCarton(), this);
        }
        return listaPaneles;
    }

    @Override
    public boolean marcar(Object dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTexto(Object dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 }
