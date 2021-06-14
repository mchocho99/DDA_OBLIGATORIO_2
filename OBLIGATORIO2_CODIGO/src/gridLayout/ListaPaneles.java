package gridLayout;

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

    public void agregarPanel(Object[] datos, MarcadorCasilla mc) {
        StringBuilder sb = new StringBuilder();
        sb.append("CARTÓN");
        agregar(datos, mc, sb.toString());
    }

    private void agregar(Object[] datos, MarcadorCasilla mc, String titulo) {
        gridLayout.setRows(gridLayout.getRows() + 1);
        PanelCasillas pc = new PanelCasillas(filas, columnas);
        pc.cargar(datos, mc);
        add(new PanelConTitulo(titulo, pc));
    }

    public void marcar() {
        Component[] lista = getComponents();
        for (Component c : lista) {
            ((PanelConTitulo)c).marcar();
        }
    }
    
    void marcarNoHacer() {
        Component[] lista = getComponents();
        for (Component c : lista) {
            PanelConTitulo pt = ((PanelConTitulo)c);
            PanelCasillas pc = (PanelCasillas)pt.getComponent(1);
            Component[] listaCasillas = pc.getComponents();
            for (Component cB : listaCasillas) {
                ((Casilla)c).marcar();
            }
        }
    }
}
