package gridLayout;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class PanelCasillas extends JPanel {
    GridLayout gridLayout = new GridLayout();
    
    public PanelCasillas(int filas, int columnas) {
        this.setLayout(gridLayout);
        gridLayout.setRows(filas);
        gridLayout.setColumns(columnas);
    }

    void cargar(Object[] datos, MarcadorCasilla mc) {
        for (Object dato : datos) {
            Casilla c = new Casilla(dato, mc);
            add(c);
        }
    }

    void marcar() {
        Component[] lista = getComponents();
        for (Component c : lista) {
            ((Casilla)c).marcar();
        }
    }
}
