package Utilidades;

import Dominio.Juego.Figura;
import Dominio.Juego.TipoFigura;

public class Configuracion {
    private static Configuracion instancia;
    
    public static Configuracion getInstancia(){
        if (instancia == null) {
            instancia = new Configuracion();
        }
        return instancia;
    }
 
    private int filasCarton;
    private int columnasCarton;
    private int maxCartones;
    private int cantJugadores;
    private double valorCarton;
    private TipoFigura[] figurasHabilitadas;

    public Configuracion(){
        
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

    public TipoFigura[] getFigurasHabilitadas() {
        return figurasHabilitadas;
    }

    public void setFigurasHabilitadas(TipoFigura[] figurasHabilitadas) {
        this.figurasHabilitadas = figurasHabilitadas;
    }

    public void setearConfig(int filasCarton, int columnasCarton, int maxCartones, int cantJugadores, double valorCarton, TipoFigura[] figurasHabilitadas) {
        this.setFilasCarton(filasCarton);
        this.setColumnasCarton(columnasCarton);
        this.setMaxCartones(maxCartones);
        this.setCantJugadores(cantJugadores);
        this.setValorCarton(valorCarton);
        this.setFigurasHabilitadas(figurasHabilitadas);
    }
    
    
}
