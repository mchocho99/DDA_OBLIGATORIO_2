package gridLayout;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class Boton extends JButton{

    private Object dato;
    private MarcadorBoton marcador;

    public Boton(Object dato, MarcadorBoton marcador) {
        setFont(new Font("Tahoma", 1, 18));
        this.dato = dato;
        this.marcador = marcador;
        setText(marcador.getTexto(dato));
    }
    
    public void marcar() {
        if (marcador.marcar(dato)) {
            setBackground(Color.GREEN);
            setForeground(Color.WHITE);
        }
    }

    
}
