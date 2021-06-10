package IU.gridLayout;

import IU.gridLayout.Casilla;
import IU.gridLayout.MarcadorCasilla;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class ListaPaneles extends JPanel {
    
    private int filas;
    private int columnas;
    GridLayout gridLayout = new GridLayout();

    public ListaPaneles(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.setLayout(gridLayout);
        gridLayout.setRows(filas);
        gridLayout.setColumns(columnas);
    }

    public void agregarPanel(Object[][] datos, MarcadorCasilla mc) {
        agregar(datos, mc);
    }

    private void agregar(Object[][] datos, MarcadorCasilla mc) {
        gridLayout.setRows(gridLayout.getRows() + 1);
        PanelCasilla pc = new PanelCasilla(filas, columnas);
        pc.cargar(datos, mc);
    }

    void marcar() {
        Component[] lista = getComponents();
        for (Component c : lista) {
            ((PanelCasilla)c).marcar();
        }
    }
}
