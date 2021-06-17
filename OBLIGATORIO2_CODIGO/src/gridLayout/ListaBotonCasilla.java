package gridLayout;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class ListaBotonCasilla extends JPanel{
    GridLayout gridLayout = new GridLayout();

    public ListaBotonCasilla() {
        this.setLayout(gridLayout);
        gridLayout.setRows(4);
    } 
    
    public void cargar(Object[] datos, MarcadorBotonCasilla mc) {
        for (Object dato : datos) {
            BotonCasilla c = new BotonCasilla(dato, mc);
            add(c);
        }
    }
    
    public void marcar() {
        Component[] lista = getComponents();
        for (Component c : lista) {
            ((BotonCasilla)c).marcar();
        }
    }
}
