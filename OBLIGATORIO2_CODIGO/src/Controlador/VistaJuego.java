package Controlador;

import IU.gridLayout.ListaPaneles;

public interface VistaJuego {
    public void mostrarTitulo(String titulo);
    public void mostrarSaldoJugador(double saldo);
    public void mostrarCartonesJugador(ListaPaneles paneles);
}
