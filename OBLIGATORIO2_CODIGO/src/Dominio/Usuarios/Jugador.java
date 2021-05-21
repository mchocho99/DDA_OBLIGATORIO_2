package Dominio.Usuarios;

import Dominio.Juego.Carton;
import java.util.List;

public class Jugador extends Usuario {
    
    private double saldo;
    private List<Carton> cartones;
    private int cantCartones;

    public Jugador(double saldo, String cedula, String password, String nombre, int cantCartones) {
        super(cedula, password, nombre);
        this.saldo = saldo;
        this.cantCartones = cantCartones;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public List<Carton> getCartones() {
        return cartones;
    }

    public void setCartones(List<Carton> cartones) {
        this.cartones = cartones;
    }

    public int getCantCartones() {
        return cantCartones;
    }
    
}
