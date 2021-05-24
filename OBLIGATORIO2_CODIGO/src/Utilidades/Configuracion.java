package Utilidades;

import Dominio.Juego.Figura;
import java.util.List;

public class Configuracion {
    private int filasCarton;
    private int columnasCarton;
    private int maxCartones;
    private int cantJugadores;
    private double valorCarton;
    private List<Figura> figuras;

    public Configuracion(int filasCarton, int columnasCarton, int maxCartones, int cantJugadores, double valorCarton, List<Figura> figuras) {
        this.filasCarton = filasCarton;
        this.columnasCarton = columnasCarton;
        this.maxCartones = maxCartones;
        this.cantJugadores = cantJugadores;
        this.valorCarton = valorCarton;
        this.figuras = figuras;
    }
    
    public int getFilasCarton() {
        return filasCarton;
    }

    public void setFilasCarton(int filasCarton) {
        this.filasCarton = filasCarton;
    }

    public int getColumnasCarton() {
        return columnasCarton;
    }

    public void setColumnasCarton(int columnasCarton) {
        this.columnasCarton = columnasCarton;
    }

    public int getMaxCartones() {
        return maxCartones;
    }

    public void setMaxCartones(int maxCartones) {
        this.maxCartones = maxCartones;
    }

    public int getCantJugadores() {
        return cantJugadores;
    }

    public void setCantJugadores(int cantJugadores) {
        this.cantJugadores = cantJugadores;
    }

    public double getValorCarton() {
        return valorCarton;
    }

    public void setValorCarton(double valorCarton) {
        this.valorCarton = valorCarton;
    }

    public List<Figura> getFiguras() {
        return figuras;
    }

    public void setFiguras(List<Figura> figuras) {
        this.figuras = figuras;
    }
    
    
}
