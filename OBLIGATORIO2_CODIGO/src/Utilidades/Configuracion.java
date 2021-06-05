package Utilidades;

import Dominio.Juego.Figura;

public class Configuracion {
    private static Configuracion instancia;
    
    public static Configuracion getInstancia(){
        if (instancia == null) {
            instancia = new Configuracion();
        }
        return instancia;
    }
    
    public static Configuracion getInstancia(int filasCarton, int columnasCarton, int maxCartones, int cantJugadores, double valorCarton, Figura[] figuras){
        if (instancia == null) {
            instancia = new Configuracion(filasCarton, columnasCarton,  maxCartones, cantJugadores,  valorCarton, figuras);
        }
        return instancia;
    }
   
    private int filasCarton;
    private int columnasCarton;
    private int maxCartones;
    private int cantJugadores;
    private double valorCarton;
    private Figura[] figuras;

    public Configuracion(){
        
    }
    
    public Configuracion(int filasCarton, int columnasCarton, int maxCartones, int cantJugadores, double valorCarton, Figura[] figuras) {
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

    public Figura[] getFiguras() {
        return figuras;
    }

    public void setFiguras(Figura[] figuras) {
        this.figuras = figuras;
    }
    
    
}
