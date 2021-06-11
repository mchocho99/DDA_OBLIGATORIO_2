package IU;

import Controlador.ControladorJuego;
import Controlador.VistaJuego;
import Dominio.Usuarios.Jugador;
import gridLayout.ListaPaneles;
import javax.swing.JOptionPane;

public class IUJuego extends javax.swing.JDialog implements VistaJuego {

    private ControladorJuego controlador;
    
    public IUJuego(java.awt.Frame parent, boolean modal, Jugador jugador) {
        super(parent, modal);
        initComponents();
        this.controlador = new ControladorJuego(this, jugador);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lst_Jugadores = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        lst_FigurasHabilitadas = new javax.swing.JList();
        btn_SeguirJugando = new javax.swing.JButton();
        btn_Abandonar = new javax.swing.JButton();
        panel_ContenedorCartones = new javax.swing.JScrollPane();
        txt_SecuenciaNumSorteados = new javax.swing.JTextField();
        txt_EstadoJuego = new javax.swing.JTextField();
        txt_SaldoJugador = new javax.swing.JTextField();
        txt_NumeroSorteado = new javax.swing.JTextField();
        txt_MontoPozo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(lst_Jugadores);

        jScrollPane2.setViewportView(lst_FigurasHabilitadas);

        btn_SeguirJugando.setText("Seguir jugando");

        btn_Abandonar.setText("Abandonar");

        txt_SecuenciaNumSorteados.setEditable(false);
        txt_SecuenciaNumSorteados.setBackground(new java.awt.Color(204, 204, 204));
        txt_SecuenciaNumSorteados.setForeground(new java.awt.Color(204, 204, 204));

        txt_EstadoJuego.setEditable(false);
        txt_EstadoJuego.setBackground(new java.awt.Color(204, 204, 204));

        txt_SaldoJugador.setEditable(false);
        txt_SaldoJugador.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        txt_SaldoJugador.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_NumeroSorteado.setEditable(false);

        txt_MontoPozo.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_SaldoJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_NumeroSorteado, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_MontoPozo, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE))
                    .addComponent(txt_EstadoJuego, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_SecuenciaNumSorteados, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panel_ContenedorCartones)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btn_SeguirJugando, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(btn_Abandonar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_SaldoJugador, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(txt_NumeroSorteado)
                    .addComponent(txt_MontoPozo))
                .addGap(18, 18, 18)
                .addComponent(txt_EstadoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_SeguirJugando, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Abandonar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel_ContenedorCartones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_SecuenciaNumSorteados, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Abandonar;
    private javax.swing.JButton btn_SeguirJugando;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lst_FigurasHabilitadas;
    private javax.swing.JList lst_Jugadores;
    private javax.swing.JScrollPane panel_ContenedorCartones;
    private javax.swing.JTextField txt_EstadoJuego;
    private javax.swing.JTextField txt_MontoPozo;
    private javax.swing.JTextField txt_NumeroSorteado;
    private javax.swing.JTextField txt_SaldoJugador;
    private javax.swing.JTextField txt_SecuenciaNumSorteados;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarTitulo(String titulo) {
        this.setTitle(titulo);
    }

    @Override
    public void mostrarSaldoJugador(double saldo) {
        this.txt_SaldoJugador.setText(Double.toString(saldo));
    }

    @Override
    public void mostrarCartonesJugador(ListaPaneles paneles) {
        panel_ContenedorCartones.setViewportView(paneles);
    }

    @Override
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}
