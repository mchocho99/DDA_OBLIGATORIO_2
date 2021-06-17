package Dominio.Juego;

public class Linea extends TipoFigura {

    public Linea(String nombre, double valor) {
        super(nombre, valor);
    }
    
    @Override
    public boolean completo(Numero[][] matrizCarton, int filas, int columnas) {
        boolean[] filaMarcada = new boolean[filas];
        /*for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                //recorriendo las lineas horizontales.
                if(matrizCarton[i][j].getMarcado()) {
                    filaMarcada[j] = true;
                }else {
                    filaMarcada[j] = false;
                }
            }
            if(this.lineaMarcada(filaMarcada)) {
                return true;
            }
        } */
        
        //Recorrer el i y que el j no sume hasta que i llegue al final.
        int fila = 0;
        int columna = 0;
        boolean[] columnaMarcada = new boolean[columnas];
        while (fila!=filas && columna!=columnas) {            
            if(matrizCarton[fila][columna].getMarcado()) {
                columnaMarcada[fila] = true;
            }else {
                columnaMarcada[fila] = false;
            }
            if(fila==filas -1) {
                columna++;
                fila = 0;
                if(this.lineaMarcada(columnaMarcada)) {
                    return true;
                }
            }else {
                fila++;
            } 
        }
        return false;
    }

    private boolean lineaMarcada(boolean[] lineaMarcada) {
        for (int i = 0; i < lineaMarcada.length; i++) {
            if(!lineaMarcada[i]) {
                return false;
            }
        }
        return true;
    }
    
}
