package Dominio.Juego;

import Dominio.Usuarios.Jugador;
import Excepciones.ExcepcionJuego;
import Utilidades.Observable;
import java.util.ArrayList;
import java.util.List;

public class Juego extends Observable{
    private List<Jugador> todosLosJugadores;
    private List<Jugador> activos;
    private int cantCartonesEnJuego;
    private int cantNumerosEnJuego;
    private int numero;
    private List<Numero> numerosQueSalieron;
    private List<Numero> numerosDelJuego;
    private EstadosJuego estado;
    private List<TipoFigura> figurasHabilitadas;
    
    public Juego(int numero, List<TipoFigura> figurasHabilitadas) {
        this.todosLosJugadores = new ArrayList<>();
        this.activos = new ArrayList<>();
        this.numerosQueSalieron = new ArrayList<>();
        this.numero = numero;
        this.numerosDelJuego = new ArrayList<>();
        this.estado = EstadosJuego.EN_ESPERA;
        this.figurasHabilitadas = figurasHabilitadas;
    }

    public List<Jugador> getTodosLosJugadores() {
        return todosLosJugadores;
    }

    public void setJugador(Jugador jugador) {
        if(!this.todosLosJugadores.contains(jugador)) {
            this.todosLosJugadores.add(jugador);
            setNumerosDelJuego(jugador);
        }
    }

    public List<Jugador> getActivos() {
        return activos;
    }

    public void setJugadorActivo(Jugador jugador) {
        if(!this.activos.contains(jugador)) {
            this.activos.add(jugador);
            setNumerosDelJuego(jugador);
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

    public int getNumero() {
        return numero;
    }

    public List<Numero> getNumerosQueSalieron() {
        return numerosQueSalieron;
    }

    public void setNumerosQueSalieron(Numero numero) {
        if (!numerosQueSalieron.contains(numero)) {
            numerosQueSalieron.add(numero);
        }
    }

    public List<Numero> getNumerosDelJuego() {
        return numerosDelJuego;
    }

    public void setNumerosDelJuego(Jugador jugador) {
        //recorrer los cartones del jugador y agregar a la lista de numeros del juego
    }

    public EstadosJuego getEstado() {
        return estado;
    }

    public void setEstado(EstadosJuego estado) {
        this.estado = estado;
    }

    void jugadorPerteneceABingo(Jugador jugador) throws ExcepcionJuego{
        if (activos.contains(jugador)) {
            throw new ExcepcionJuego("El jugador " + jugador.getCedula() + " ya está participando del bingo");
        }
    }
    
}
