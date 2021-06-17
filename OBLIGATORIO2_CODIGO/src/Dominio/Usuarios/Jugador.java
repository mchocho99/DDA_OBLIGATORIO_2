package Dominio.Usuarios;

import Dominio.Juego.Carton;
import Dominio.Juego.Figura;
import Dominio.Juego.Numero;
import Excepciones.ExcepcionJuego;
import java.util.ArrayList;
import java.util.List;

public class Jugador extends Usuario {
    
    private double saldo;
    private List<Carton> cartones;
    private int cantCartonesSolicitados;
    private boolean listo;

    public Jugador(double saldo, String cedula, String password, String nombre) {
        super(cedula, password, nombre);
        this.saldo = saldo;
        this.cartones = new ArrayList<>();
        this.listo = false;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
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

    public boolean getListo() {
        return listo;
    }

    public void setListo(boolean listo) {
        this.listo = listo;
    }

    public void saldoSuficiente(double valorCartones) throws ExcepcionJuego{
        if (valorCartones > this.getSaldo()) {
            throw new ExcepcionJuego("Saldo insuficiente");
        }
    }
    
    public int getCantNumeros(int cantNumerosPorCarton) {
        return cantNumerosPorCarton*cantCartonesSolicitados;
    }

    public boolean marcarNumero(Numero numeroSorteado) {
        boolean marco = false;
        for (Carton carton : cartones) {
            marco = carton.marcarNumero(numeroSorteado);
            if (marco) {
                numeroSorteado.setJugador(this);
                carton.getNumero(numeroSorteado).setJugador(this);
                return true;
            }
        }
        return false;
    }

    public boolean verificarGanador(int filas, int columnas) {
        for (Carton carton : cartones) {
            return carton.verificarGanador(filas,columnas);
        }
        return false;
    }

    @Override
    public String toString() {
        return super.getNombre();
    }

    public String getNombreFigura() {
        for (Carton carton : cartones) {
            if (carton.getNombreFigura() != null) {
                return carton.getNombreFigura();
            }
        }
        return null;
    }

    public double getMontoADebitar(double valorCarton, double extra) {
        double montoADebitar = this.cantCartonesSolicitados * valorCarton;
        return montoADebitar + (montoADebitar * extra);
    }

    public void pagar(double montoADebitar) {
        this.saldo -= montoADebitar;
    }

    public void cobrar(double montoACobrar) {
        this.saldo += montoACobrar;
    }

    public Figura getFigura(Jugador ganador) {
        for (Carton carton : cartones) {
            if (carton.getFigura() != null) {
                return carton.getFigura();
            }
        }
        return null;
    }

    public double getExtraFigura() {
        for (Carton carton : cartones) {
            if (carton.getFigura() != null) {
                return carton.getExtraFigura();
            }
        }
        return 0.0;
    }

    public String getNombreFiguraGanadora() {
        for (Carton carton : cartones) {
            if (carton.getFigura() != null) {
                return carton.getNombreFiguraGanadora();
            }
        }
        return null;
    }

    public void eliminarCartones() {
        this.cartones.clear();
    }
    
    
}
