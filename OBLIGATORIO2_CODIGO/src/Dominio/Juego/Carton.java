package Dominio.Juego;

import java.util.ArrayList;
import java.util.List;

public class Carton {
    private Numero[][] matrizCarton;
    private int cantNumeros;
    private double valor;
    private List<Figura> figuras;
    private List<TipoFigura> figurasHabilitadas;

    public Carton(int filasCarton, int columnasCarton, double valor, List<TipoFigura> figurasHabilitadas) {
        this.cantNumeros = filasCarton*columnasCarton;
        
        this.matrizCarton = new Numero[filasCarton][columnasCarton];
        for (int i = 0; i < matrizCarton.length; i++) {
            for (int j = 0; j < matrizCarton[i].length; j++) {
                matrizCarton[i][j] = new Numero(-1, false);
            }
        }
        
        this.valor = valor;
        this.figuras = new ArrayList<>();
        
        this.figurasHabilitadas = figurasHabilitadas; 
    }

    public Numero[][] getMatrizCarton() {
        return matrizCarton;
    }

    public boolean setMatrizCarton(int numero) {
        for (int i = 0; i < matrizCarton.length; i++) {
            for (int j = 0; j < matrizCarton[i].length; j++) {
                Numero numeroaux = matrizCarton[i][j];
                if(numeroaux.getNumero() == -1) {
                    matrizCarton[i][j] = new Numero(numero, false);
                    return true;
                }
            }
        }
        return false;
    }

    public int getCantNumeros() {
        return cantNumeros;
    }

    public void setCantNumeros(int cantNumeros) {
        this.cantNumeros = cantNumeros;
    }

    public double getValor() {
        return valor;
    }

    public boolean marcarNumero(Numero numeroSorteado) {
        for (int i = 0; i < matrizCarton.length; i++) {
            for (int j = 0; j < matrizCarton[i].length; j++) {
                Numero numeroaux = matrizCarton[i][j];
                if(numeroaux.getNumero() == numeroSorteado.getNumero()) {
                    numeroSorteado.setMarcado(true);
                    numeroaux.setMarcado(true);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verificarGanador(int filas, int columnas) {
        for (TipoFigura figura : figurasHabilitadas) {
            return figura.completo(matrizCarton, filas, columnas);
        }
        return false;
    }

    public Numero getNumero(Numero numeroSorteado) {
        for (int i = 0; i < matrizCarton.length; i++) {
            for (int j = 0; j < matrizCarton[i].length; j++) {
                Numero numeroaux = matrizCarton[i][j];
                if(numeroaux.getNumero() == numeroSorteado.getNumero()) {
                    return numeroaux;
                }
            }
        }
        return null;
    }
}
