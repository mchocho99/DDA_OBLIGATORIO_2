package Dominio.Juego;

public class Diagonal extends TipoFigura {

    public Diagonal(String nombre, double valor) {
        super(nombre, valor);
    }
    
    @Override
    public boolean completo(Numero[][] matrizCarton, int filas, int columnas) {
        if (filas != columnas) {
            return false;
        }
        int largo = matrizCarton.length;
        if (this.diagonal(matrizCarton, largo)) {
            return true;
        }
        if (this.diagonalInvertida(matrizCarton, largo)) {
            return true;
        }
        return false;
    }
    
    public boolean diagonal(Numero[][] matrizCarton, int largo){
        for (int i = 0; i < largo; i++){
            for (int j = 0; j < largo; j++){
                if (i == j){
                    if(!matrizCarton[i][j].getMarcado()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public boolean diagonalInvertida(Numero[][] matrizCarton, int largo){
        for (int i = 0; i < largo; i++){
            for (int j = 0; j < largo; j++){
                if (i + j + 1 == largo){
                    if(!matrizCarton[i][j].getMarcado()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
}
