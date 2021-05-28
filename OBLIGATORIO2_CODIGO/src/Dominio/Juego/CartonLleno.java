package Dominio.Juego;

public class CartonLleno extends Figura{

    public CartonLleno(String nombre) {
        super(nombre);
    }
 
    @Override
    public boolean completo(Numero[][] matrizCarton, int filas, int columnas) {
        for(int i=0; i<columnas; i++) {
            for(int j=0; i<filas; i++) {
                if(!matrizCarton[i][j].getMarcado()) {
                    return false;
                }
            }
        }
        return true;
    }
    
}
