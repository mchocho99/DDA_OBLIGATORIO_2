package Controlador;

import Dominio.Fachada.Fachada;
import Dominio.Usuarios.Jugador;
import Excepciones.ExcepcionJuego;
import Excepciones.ExcepcionUsuario;

public class ControladorLoginJugador {
    private Fachada fachada = Fachada.getInstancia();
    private VistaLoginJugador vista;

    public ControladorLoginJugador(VistaLoginJugador vista) {
        this.vista = vista;
    }

    public void login(String cedula, String password, String cantCartones) {
        int cantCartonesInt = parsearInt(cantCartones);
        
        if (cantCartonesInt <= 0 ) {
            vista.mostrarError("Indique con cuantos cartones desea jugar");
        }
       
        try {
            fachada.cantCartonesMayorMaxCartones(cantCartonesInt);
            Jugador jugador = fachada.loginJugador(cedula, password, cantCartonesInt);
            fachada.jugadorPerteneceABingo(jugador);
            fachada.saldoJugadorNoSuficiente(jugador, cantCartonesInt);
            vista.mostrarProximaInterfaz(jugador);
            
        } catch (ExcepcionUsuario | ExcepcionJuego e) {
            vista.mostrarError(e.getMessage());
        }
    }

    private int parsearInt(String cantCartones) {
        try {
            return Integer.parseInt(cantCartones);
        } catch (Exception e) {
            vista.mostrarError("Debes ingresar un número");
        }
        return -1;
    }
    
    
}
