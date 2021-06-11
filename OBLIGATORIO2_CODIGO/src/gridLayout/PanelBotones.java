package gridLayout;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class PanelBotones extends JPanel {
    GridLayout gridLayout = new GridLayout();
    
    public PanelBotones(int filas, int columnas) {
        this.setLayout(gridLayout);
        gridLayout.setRows(filas);
        gridLayout.setColumns(columnas);
    }

    void cargar(Object[] datos, MarcadorBoton mb) {
        for (Object dato : datos) {
            Boton b = new Boton(dato, mb);
            add(b);
        }
    }

    void marcar() {
        Component[] lista = getComponents();
        for (Component c : lista) {
            ((Boton)c).marcar();
        }
    }
}
