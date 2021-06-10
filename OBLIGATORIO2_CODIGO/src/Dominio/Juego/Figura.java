package Dominio.Juego;

public abstract class Figura {
    private TipoFigura tipo;

    public Figura(TipoFigura tipo) {
        this.tipo = tipo;
    }
    
    public TipoFigura getTipoFigura() {
        return tipo;
    }
}
