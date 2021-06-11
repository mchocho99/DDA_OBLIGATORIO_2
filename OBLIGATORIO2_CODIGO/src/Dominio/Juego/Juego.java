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
    private int cantMaxJugadores;
    
    public Juego(int numero, List<TipoFigura> figurasHabilitadas, int cantMaxJugadores) {
        this.todosLosJugadores = new ArrayList<>();
        this.activos = new ArrayList<>();
        this.numerosQueSalieron = new ArrayList<>();
        this.numero = numero;
        this.numerosDelJuego = new ArrayList<>();
        this.estado = EstadosJuego.EN_ESPERA;
        this.figurasHabilitadas = figurasHabilitadas;
        this.cantMaxJugadores = cantMaxJugadores;
    }

    public List<Jugador> getTodosLosJugadores() {
        return todosLosJugadores;
    }

    public void setJugador(Jugador jugador) {
        if(!this.todosLosJugadores.contains(jugador)) {
            this.todosLosJugadores.add(jugador);
        }
        if(this.todosLosJugadores.size() == this.cantMaxJugadores) {
            //CAMBIA ESTADO SE EJECUTA UN EVENTO
            this.setEstado(EstadosJuego.ACTIVO);      
            setNumerosDelJuego();
            for (Jugador jug : todosLosJugadores) {
                this.setJugadorActivo(jug);
            }
        }
        
    }

    public List<Jugador> getActivos() {
        return activos;
    }

    public void setJugadorActivo(Jugador jugador) {
        if(!this.activos.contains(jugador)) {
            this.activos.add(jugador);
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

    public void setNumerosDelJuego() {
       //EN BASE A LOS CARTONES DE TODOS LOS JUGADORES SETEA LOS NUMEROS A JUGAR
    }

    public EstadosJuego getEstado() {
        return estado;
    }

    public void setEstado(EstadosJuego estado) {
        this.estado = estado;
    }

    void jugadorPerteneceABingo(Jugador jugador) throws ExcepcionJuego{
        if (todosLosJugadores.contains(jugador)) {
            throw new ExcepcionJuego("El jugador " + jugador.getCedula() + " ya está participando del bingo");
        }
    }

    public boolean estaEnEspera() {
        return this.getEstado() == EstadosJuego.EN_ESPERA;
    }
    
}
