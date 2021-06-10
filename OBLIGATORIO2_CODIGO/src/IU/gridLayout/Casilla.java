package IU.gridLayout;

import Dominio.Juego.Numero;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Casilla extends JButton {

    private Object dato;
    private MarcadorCasilla marcador;

    public Casilla(Object dato, MarcadorCasilla marcador) {
        setFont(new Font("Tahoma", 1, 18));
        this.dato = dato;
        this.marcador = marcador;
        setText(Integer.toString(((Numero)dato).getNumero()));
    }
    
    public void marcar() {
        if (marcador.marcar(dato)) {
            setBackground(Color.GREEN);
            setForeground(Color.BLACK);
        }
    }    
}
