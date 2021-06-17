package Controlador;

import Dominio.Fachada.Fachada;
import Dominio.Juego.Juego;
import Dominio.Juego.Numero;
import Dominio.Usuarios.Jugador;
import IU.IUMonitoreo;
import Utilidades.Evento;
import Utilidades.Observable;
import Utilidades.Observador;
import gridLayout.Casilla;
import gridLayout.ListaCasilla;
import gridLayout.MarcadorCasilla;
import java.util.ArrayList;
import java.util.List;

public class ControladorMonitoreo implements Observador, MarcadorCasilla {
    
    private VistaMonitoreo vista;
    private Fachada fachada = Fachada.getInstancia();

    public ControladorMonitoreo(VistaMonitoreo vista) {
        this.vista = vista;
        vista.mostrarJuegos(fachada.getJuegos());
        fachada.agregar(this);
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento == Evento.ACTUALIZAR_LISTA_JUEGOS && (origen instanceof Fachada)) {
            vista.mostrarJuegos(fachada.getJuegos());
            //FALTA ACTUALIZAR LA CANTIDAD DE BOLILLAS SORTEADAS
        }
    }

    public void mostrarDatos(Juego juego) {      
        vista.mostrarDatosEstaticos(juego.getNumero(),juego.getNumerosQueSalieron().size());//ROMPE EXPERTO
        String ganador = juego.getNombreGanador();
        vista.mostrarDatosDinamicos(juego.getEstado() ,ganador);
        vista.mostrarJugadores(juego.getTodosLosJugadores());
        List<Numero> numeros = juego.getNumerosDelJuego();
        ListaCasilla lc = new ListaCasilla();
        lc.cargar(numeros.toArray(), this);
        vista.mostrarNumerosDelJuego(lc);
    }

    @Override
    public boolean marcar(Object dato) {
        return ((Numero)dato).getMarcado();
    }

    @Override
    public String getTexto(Object dato) {
        return ((Numero)dato).getNumero() + "";
    }
}
