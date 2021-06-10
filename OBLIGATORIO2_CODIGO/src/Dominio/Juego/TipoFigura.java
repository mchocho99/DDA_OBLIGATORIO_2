package Dominio.Juego;

public abstract class TipoFigura {
    private String nombre;

    public TipoFigura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public abstract boolean completo(Numero[][] matrizCarton, int filas, int columnas);
}
