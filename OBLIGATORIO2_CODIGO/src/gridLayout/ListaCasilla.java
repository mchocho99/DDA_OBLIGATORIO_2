package gridLayout;

import java.awt.GridLayout;
import javax.swing.JPanel;

public class ListaCasilla extends JPanel{
    GridLayout gridLayout = new GridLayout();

    public ListaCasilla() {
        this.setLayout(gridLayout);
    } 
    
    public void cargar(Object[] datos, MarcadorCasilla mc) {
        for (Object dato : datos) {
            Casilla c = new Casilla(dato, mc);
            add(c);
        }
    }
}
