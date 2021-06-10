package Dominio.Juego;

public class Linea extends TipoFigura {

    public Linea(String nombre) {
        super(nombre);
    }
    
    @Override
    public boolean completo(Numero[][] matrizCarton, int filas, int columnas) {
        boolean[] filaMarcada = new boolean[columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                //recorriendo las lineas horizontales.
                if(matrizCarton[i][j].getMarcado()) {
                    filaMarcada[j] = true;
                }else {
                    filaMarcada[j] = false;
                }
            }
            if(this.filaMarcada(filaMarcada)) {
                return true;
            }
        } 
        
        //Recorrer el i y que el j no sume hasta que i llegue al final.
        int fila = 0;
        int columna = 0;
        boolean[] columnaMarcada = new boolean[filas];
        while (fila!=filas && columna!=columnas) {            
            if(matrizCarton[columna][fila].getMarcado()) {
                columnaMarcada[columna] = true;
            }else {
                columnaMarcada[columna] = false;
            }
            if(columna==columnas) {
                fila++;
                columna = 0;
                if(this.columnaMarcada(columnaMarcada)) {
                    return true;
                }
            }else {
                columna++;
            } 
        }
        return false;
    }

    private boolean filaMarcada(boolean[] filaMarcada) {
        for (int i = 0; i < filaMarcada.length; i++) {
            if(!filaMarcada[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean columnaMarcada(boolean[] columnaMarcada) {
        for (int i = 0; i < columnaMarcada.length; i++) {
            if(!columnaMarcada[i]) {
                return false;
            }
        }
        return true;
    }
    
}
