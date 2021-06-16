package IU;

import Controlador.ControladorJuego;
import Controlador.VistaJuego;
import Dominio.Juego.TipoFigura;
import Dominio.Usuarios.Jugador;
import gridLayout.ListaPaneles;
import java.util.List;
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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jScrollPane1.setViewportView(lst_Jugadores);

        jScrollPane2.setViewportView(lst_FigurasHabilitadas);

        btn_SeguirJugando.setText("Seguir jugando");
        btn_SeguirJugando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SeguirJugandoActionPerformed(evt);
            }
        });

        btn_Abandonar.setText("Abandonar");
        btn_Abandonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AbandonarActionPerformed(evt);
            }
        });

        txt_SecuenciaNumSorteados.setEditable(false);
        txt_SecuenciaNumSorteados.setBackground(new java.awt.Color(204, 204, 204));
        txt_SecuenciaNumSorteados.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        txt_SecuenciaNumSorteados.setForeground(new java.awt.Color(0, 0, 0));

        txt_EstadoJuego.setEditable(false);
        txt_EstadoJuego.setBackground(new java.awt.Color(204, 204, 204));
        txt_EstadoJuego.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        txt_EstadoJuego.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_SaldoJugador.setEditable(false);
        txt_SaldoJugador.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        txt_SaldoJugador.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_NumeroSorteado.setEditable(false);
        txt_NumeroSorteado.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        txt_NumeroSorteado.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_MontoPozo.setEditable(false);
        txt_MontoPozo.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        txt_MontoPozo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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
                        .addComponent(txt_MontoPozo, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
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
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SeguirJugandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SeguirJugandoActionPerformed
        controlador.seguirJugando();
    }//GEN-LAST:event_btn_SeguirJugandoActionPerformed

    private void btn_AbandonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AbandonarActionPerformed
        controlador.abandonar();
        this.dispose();
    }//GEN-LAST:event_btn_AbandonarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        controlador.abandonar();
    }//GEN-LAST:event_formWindowClosed
    

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
    public void mostrarCartonesJugador(ListaPaneles paneles) {
        panel_ContenedorCartones.setViewportView(paneles);
    }

    @Override
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void mostrarEstadoJuego(String estado) {
        this.txt_EstadoJuego.setText(estado);
    }

    @Override
    public void mostrarDatos(List<TipoFigura> figuras, List<Jugador> jugadores,
            int numeroActual, double montoPozoJuego, double saldoJugador,
            String historicoNumeros) {
        this.lst_FigurasHabilitadas.setListData(figuras.toArray());
        this.lst_Jugadores.setListData(jugadores.toArray());
        this.txt_NumeroSorteado.setText(Integer.toString(numeroActual));
        this.txt_SaldoJugador.setText(Double.toString(saldoJugador));
        this.txt_MontoPozo.setText(Double.toString(montoPozoJuego));
        this.txt_SecuenciaNumSorteados.setText(historicoNumeros);
    }

    @Override
    public void cerrar() {
        this.dispose();
    }

    @Override
    public void desactivarBotonSeguirJugando() {
        this.btn_SeguirJugando.setEnabled(false);
    }
}
