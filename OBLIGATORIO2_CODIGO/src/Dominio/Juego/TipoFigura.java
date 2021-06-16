package Dominio.Juego;

public abstract class TipoFigura {
    private String nombre;
    private double valor;

    public TipoFigura(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public abstract boolean completo(Numero[][] matrizCarton, int filas, int columnas);

    @Override
    public String toString() {
        return nombre;
    }
    
    public double getValor() {
        return valor;
    }
    
    
}
