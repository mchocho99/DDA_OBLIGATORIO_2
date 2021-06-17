package gridLayout;

import Controlador.ControladorMonitoreo;
import Dominio.Juego.Numero;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import static javax.swing.SwingConstants.CENTER;

public class BotonCasilla extends JButton implements ActionListener {
    private Object dato;
    private MarcadorBotonCasilla marcador;

    public BotonCasilla(Object dato, MarcadorBotonCasilla marcador) {
        setFont(new Font("Tahoma", 1, 18));
        this.dato = dato;
        this.marcador = marcador;
        setText(marcador.getTexto(dato));
        this.setBackground(Color.WHITE);
        this.setHorizontalAlignment(CENTER);
        addActionListener(this);
    }
    
    public void marcar() {
        if (marcador.marcar(dato)) {
            setBackground(Color.GREEN);
            setForeground(Color.WHITE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(marcador instanceof ControladorMonitoreo) {
            if(((Numero)dato).getMarcado()) {
                marcador.click(dato);
            }else {
                marcador.click(null);
            }
        }
    }
}
