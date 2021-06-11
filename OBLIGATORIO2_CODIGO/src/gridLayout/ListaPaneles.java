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

    public void agregarPanel(Object[] datos, MarcadorBoton mb) {
        StringBuilder sb = new StringBuilder();
        sb.append("CARTON");
        agregar(datos, mb, sb.toString());
    }

    private void agregar(Object[] datos, MarcadorBoton mb, String titulo) {
        gridLayout.setRows(gridLayout.getRows() + 1);
        PanelBotones pb = new PanelBotones(filas, columnas);
        pb.cargar(datos, mb);
        add(new PanelConTitulo(titulo, pb));
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
            PanelBotones pb = (PanelBotones)pt.getComponent(1);
            Component[] listaBotones = pb.getComponents();
            for (Component cB : listaBotones) {
                ((Boton)c).marcar();
            }
        }
    }
}
