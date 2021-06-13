package gridLayout;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Boton extends JTextField {

    private Object dato;
    private MarcadorBoton marcador;

    public Boton(Object dato, MarcadorBoton marcador) {
        setFont(new Font("Tahoma", 1, 18));
        this.dato = dato;
        this.marcador = marcador;
        setText(marcador.getTexto(dato));
        this.setEditable(false);
        this.setBackground(Color.WHITE);
        this.setHorizontalAlignment(CENTER);
    }
    
    public void marcar() {
        if (marcador.marcar(dato)) {
            setBackground(Color.GREEN);
            setForeground(Color.WHITE);
        }
    }

    
}