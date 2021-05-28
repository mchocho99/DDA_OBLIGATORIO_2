package Dominio.Juego;

public abstract class Figura {
    private String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public abstract boolean completo(Numero[][] matrizCarton, int filas, int columnas);
}
