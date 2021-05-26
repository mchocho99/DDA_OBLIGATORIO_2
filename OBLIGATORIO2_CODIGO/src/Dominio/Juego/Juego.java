package Dominio.Juego;

import Dominio.Usuarios.Jugador;
import java.util.ArrayList;
import java.util.List;

public class Juego {
    private List<Jugador> jugadores;
    private int cantCartonesEnJuego;
    private int cantNumerosEnJuego;
    private int numero;
    private List<Integer> numerosQueSalieron;
    private List<Integer> numerosDelJuego;
    //AGREGAR UN ENUM CON ESTADOS DEL JUEGO, EN ESPERA O COMENZADO
    
    public Juego(int numero) {
        this.jugadores = new ArrayList<>();
        this.numerosQueSalieron = new ArrayList<>();
        this.numero = numero;
        this.numerosDelJuego = new ArrayList<>();
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador jugador) {
        if(!this.jugadores.contains(jugador)) {
            this.jugadores.add(jugador);
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

    public List<Integer> getNumerosQueSalieron() {
        return numerosQueSalieron;
    }

    public void setNumerosQueSalieron(int numero) {
        if (!numerosQueSalieron.contains(numero)) {
            numerosQueSalieron.add(numero);
        }
    }

    public List<Integer> getNumerosDelJuego() {
        return numerosDelJuego;
    }

    public void setNumerosDelJuego(Jugador jugador) {
        //recorrer los cartones del jugador y agregar a la lista de numeros del juego
    }
    
    
}