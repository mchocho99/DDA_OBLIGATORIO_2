package gridLayout;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelConTitulo extends JPanel {
    
    public PanelConTitulo(String titulo, PanelCasillas pc) {
        setLayout(new BorderLayout());
        JLabel lb = new JLabel(titulo);
        lb.setFont(new Font("Tahoma", 1 , 18));
        lb.setHorizontalAlignment(JLabel.CENTER);
        add(lb, BorderLayout.NORTH);
        add(pc, BorderLayout.CENTER);
    }

    void marcar() {
        ((PanelCasillas)getComponent(1)).marcar();
    }
}
