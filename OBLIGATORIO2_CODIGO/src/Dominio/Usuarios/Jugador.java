package Dominio.Usuarios;

import Dominio.Juego.Carton;
import Excepciones.ExcepcionJuego;
import java.util.ArrayList;
import java.util.List;

public class Jugador extends Usuario {
    
    private double saldo;
    private List<Carton> cartones;
    private int cantCartonesSolicitados;

    public Jugador(double saldo, String cedula, String password, String nombre) {
        super(cedula, password, nombre);
        this.saldo = saldo;
        this.cartones = new ArrayList<>();
    }
    
    public double getSaldo() {
        return saldo;
    }

    public List<Carton> getCartones() {
        return cartones;
    }

    public void setCarton(Carton carton) {
        this.cartones.add(carton);
    }

    public int getCantCartonesSolicitados() {
        return cantCartonesSolicitados;
    }

    public void setCantCartonesSolicitados(int cantCartonesSolicitados) {
        this.cantCartonesSolicitados = cantCartonesSolicitados;
    }

    public void saldoSuficiente(double valorCartones) throws ExcepcionJuego{
        if (valorCartones > this.getSaldo()) {
            throw new ExcepcionJuego("Saldo insuficiente");
        }
    }
    
    public int getCantNumeros(int cantNumerosPorCarton) {
        return cantNumerosPorCarton*cantCartonesSolicitados;
    }
    
}
