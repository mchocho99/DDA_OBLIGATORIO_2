package Controlador;

import Dominio.Usuarios.Jugador;

public interface VistaLoginJugador {
    public void mostrarProximaInterfaz(Jugador jugador);
    public void mostrarError(String mensaje);
    public void cerrar();
    public void mostrarTitulo(String titulo);
}
