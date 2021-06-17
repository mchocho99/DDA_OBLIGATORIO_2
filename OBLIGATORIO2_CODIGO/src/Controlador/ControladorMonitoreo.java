package Controlador;

import Dominio.Fachada.Fachada;
import Dominio.Juego.EstadosJuego;
import Dominio.Juego.Juego;
import Dominio.Juego.Numero;
import Utilidades.Evento;
import Utilidades.Observable;
import Utilidades.Observador;
import gridLayout.ListaBotonCasilla;
import gridLayout.MarcadorBotonCasilla;
import java.util.List;

public class ControladorMonitoreo implements Observador, MarcadorBotonCasilla {
    
    private VistaMonitoreo vista;
    private Fachada fachada = Fachada.getInstancia();
    private Juego juegoSeleccionado = null;

    public ControladorMonitoreo(VistaMonitoreo vista) {
        this.vista = vista;
        vista.mostrarJuegos(fachada.getJuegos());
        fachada.agregar(this);
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento == Evento.ACTUALIZAR_LISTA_JUEGOS && (origen instanceof Fachada)) {
            vista.mostrarJuegos(fachada.getJuegos());
        }
        if(evento == Evento.SORTEO && (origen instanceof Fachada)) {
            if(this.juegoSeleccionado != null) {
                vista.mostrarCantBolillasSorteadas(this.juegoSeleccionado.getCantBolillasSorteadas());
            }
        }
        if(evento == Evento.MARCO && (origen instanceof Fachada)) {
            if(this.juegoSeleccionado != null) {
                this.marcarEnBolillero();
            }
        }
        if(evento == Evento.GANADOR && (origen instanceof Fachada)) {
            if(this.juegoSeleccionado != null) {
                String ganador = this.juegoSeleccionado.getNombreGanador();
                vista.mostrarJuegos(fachada.getJuegos());
                vista.mostrarEstadoJuego(this.juegoSeleccionado.getEstado());
                vista.mostrarGanador(ganador);
            }
        }
    }

    public void mostrarDatos(Juego juego) {    
        String ganador = juego.getNombreGanador();
        int cantBolillas = juego.getNumerosQueSalieron().size();
        EstadosJuego estado = juego.getEstado();
        vista.mostrarJugadores(juego.getTodosLosJugadores());
        vista.mostrarNumeroJuego(juego.getNumero());
        vista.mostrarEstadoJuego(estado);
        vista.mostrarGanador(ganador);
        vista.mostrarCantBolillasSorteadas(cantBolillas);
        this.juegoSeleccionado = juego;
        this.marcarEnBolillero();
    }
    
    public void marcarEnBolillero() {
        List<Numero> numeros = juegoSeleccionado.getNumerosDelJuego();
        ListaBotonCasilla lc = new ListaBotonCasilla();
        lc.cargar(numeros.toArray(), this);
        vista.mostrarNumerosDelJuego(lc);
        lc.marcar();
    }

    @Override
    public boolean marcar(Object dato) {
        return ((Numero)dato).getMarcado();
    }

    @Override
    public String getTexto(Object dato) {
        return ((Numero)dato).getNumero() + "";
    }

    @Override
    public void click(Object dato) {
        if(dato == null) {
            vista.mostrarNombreQueMarco("Este numero no salió sorteado aun!");
        }else {
            vista.mostrarNombreQueMarco(((Numero)dato).getNombreJugador());
        }
    }
}
