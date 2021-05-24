package Dominio.Juego;

public class Diagonal extends Figura {

    public Diagonal(String nombre) {
        super(nombre);
    }
    
    @Override
    public boolean completo(CasillaCarton[][] matrizCarton, int filas, int columnas) {
        int largo = matrizCarton.length;
        for (int i = 0; i < largo; i++){
            for (int j = 0; j < largo; j++){
                if (i == j || i + j + 1 == largo){
                    if(!matrizCarton[i][j].getMarcado()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
}
