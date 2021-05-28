package Dominio.Juego;

import java.util.ArrayList;
import java.util.List;

public class Carton {
    private Numero[][] matrizCarton;
    private int cantNumeros;
    private double valor;
    private List<Figura> figuras;

    public Carton(int filasCarton, int columnasCarton, double valor, List<Figura> figuras) {
        this.cantNumeros = filasCarton*columnasCarton;
        
        this.matrizCarton = new Numero[filasCarton][columnasCarton];
        for (int i = 0; i < matrizCarton.length; i++) {
            for (int j = 0; j < matrizCarton[i].length; j++) {
                matrizCarton[i][j] = new Numero(-1, false);
            }
        }
        
        this.valor = valor;
        this.figuras = figuras;
    }

    public Numero[][] getMatrizCarton() {
        return matrizCarton;
    }

    public void setMatrizCarton(int numero) {
        for (int i = 0; i < matrizCarton.length; i++) {
            for (int j = 0; j < matrizCarton[i].length; j++) {
                if(!matrizCarton[i][j].estaOcupado()) {
                    matrizCarton[i][j] = new Numero(numero, false);
                }
            }
        }
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
}
