package Dominio.Juego;

public class Perimetro extends TipoFigura {

    public Perimetro(String nombre) {
        super(nombre);
    }

    @Override
    public boolean completo(Numero[][] matrizCarton, int filas, int columnas) {
        for (int i = 0; i < columnas; i++) {
            //recorre la primera linea horizontal.
            if(!matrizCarton[0][i].getMarcado()) {
                return false;
            }
        }
        
        for (int i = 0; i < filas; i++) {
            //linea vertical izq.
            if(!matrizCarton[i][0].getMarcado()) {
                return false;
            }
        }
        
        for (int i = 0; i < filas; i++) {
            //linea vertical der.
            if(!matrizCarton[i][filas].getMarcado()) {
                return false;
            }
        }
        
        for (int i = 0; i < columnas; i++) {
            //ultima linea horizontal.
            if(!matrizCarton[columnas][i].getMarcado()) {
                return false;
            }
        }
        
        return true;
    }
}
