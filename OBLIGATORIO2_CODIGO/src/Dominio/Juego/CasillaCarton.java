package Dominio.Juego;

public class CasillaCarton {
    private int numero;
    private boolean marcado;
   
    public CasillaCarton(int numero, boolean marcado) {
        this.numero = numero;
        this.marcado = marcado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean getMarcado() {
        return marcado;
    }

    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }
    
    
    public boolean estaOcupado() {
        return this.numero == -1;
    }
}
