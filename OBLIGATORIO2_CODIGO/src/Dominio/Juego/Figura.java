package Dominio.Juego;

public class Figura {
    private TipoFigura tipo;

    public Figura(TipoFigura tipo) {
        this.tipo = tipo;
    }
    
    public TipoFigura getTipoFigura() {
        return tipo;
    }
    
    public String getNombreFigura() {
        return tipo.getNombre();
    }

    public double getExtra() {
        return tipo.getValor();
    }
    
}
