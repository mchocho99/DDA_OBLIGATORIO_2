package Dominio.Juego;

import Dominio.Usuarios.Jugador;
import java.util.List;

public class Numero {
    private int numero;
    private boolean marcado;
    private Jugador jugador;

    public Numero() {
        this.numero = -1;
    }
    
    public Numero(int numero, boolean marcado) {
        this.numero = numero;
        this.marcado = marcado;
        this.jugador = null;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean getMarcado() {
        return marcado;
    }

    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }
   
    public boolean estaOcupado() {
        return this.numero != -1;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}
