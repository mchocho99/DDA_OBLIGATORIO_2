package Dominio.Juego;

public class CartonLleno extends TipoFigura {

    public CartonLleno(String nombre, double valor) {
        super(nombre, valor);
    }
 
    @Override
    public boolean completo(Numero[][] matrizCarton, int filas, int columnas) {
        for(int i=0; i<filas; i++) {
            for(int j=0; j<columnas; j++) {
                if(!matrizCarton[i][j].getMarcado()) {
                    return false;
                }
            }
        }
        return true;
    }
    
}
