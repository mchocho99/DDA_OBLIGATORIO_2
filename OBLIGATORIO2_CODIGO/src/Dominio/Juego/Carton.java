package Dominio.Juego;

import java.util.List;

public class Carton {
    private Numero[][] matrizCarton;
    private int cantNumeros;
    private double valor;
    private Figura figura;
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
        this.figura = null;
        
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
        Figura aux = null;
        Double valor = -1.0;
        for (TipoFigura figura : figurasHabilitadas) {
            boolean gano = figura.completo(matrizCarton, filas, columnas);
            if (gano && figura.getValor() > valor) {
                aux = new Figura(figura);
                valor = figura.getValor();
            }
        }
        if (aux != null) {
            this.setFigura(aux);
            return true;
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

    public String getNombreFigura() {
        if(this.figura == null) {
            return null;
        }
        return this.figura.getNombreFigura();
    }

    public void setFigura(Figura figura) {
        this.figura = figura;
    }

    public Figura getFigura() {
        return this.figura;
    }

    public double getExtraFigura() {
        return this.figura.getExtra();
    }

    public String getNombreFiguraGanadora() {
        return this.figura.getNombreFigura();
    }
    
    
}
