package IU.gridLayout;

import IU.gridLayout.Casilla;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class PanelCasilla extends JPanel {
    GridLayout gridLayout = new GridLayout();
    
    public PanelCasilla(int filas, int columnas) {
        this.setLayout(gridLayout);
        gridLayout.setRows(filas);
        gridLayout.setColumns(columnas);
    }

    void cargar(Object[][] datos, MarcadorCasilla mc) {
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[i].length; j++) {
                Casilla c = new Casilla(datos[i][j], mc);
                add(c);
            }
        }
    }

    void marcar() {
        Component[] lista = getComponents();
        for (Component c : lista) {
            ((Casilla)c).marcar();
        }
    }
}
