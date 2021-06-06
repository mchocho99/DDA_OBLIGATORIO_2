package Controlador;

import Dominio.Fachada.Fachada;
import Dominio.Usuarios.Jugador;
import Dominio.Usuarios.Usuario;
import Excepciones.ExcepcionJuego;
import Excepciones.ExcepcionUsuario;

public class ControladorLoginJugador {
    private Fachada fachada = Fachada.getInstancia();
    private VistaLoginUsuario vista;

    public ControladorLoginJugador(VistaLoginUsuario vista) {
        this.vista = vista;
    }

    public void login(String cedula, String password, String cantCartones) {
        if(esNumerico(cantCartones)) {
            int cantCartonesInt = Integer.parseInt(cantCartones);
            if(cantCartonesInt > 0) {
                try {
                    fachada.cantCartonesMayorMaxCartones(cantCartonesInt);
                    Usuario usuario = fachada.login(cedula, password);
                    Jugador jugador = (Jugador)usuario;
                    fachada.jugadorPerteneceABingo(jugador);
                    fachada.saldoJugadorNoSuficiente(jugador, cantCartonesInt);
                    vista.mostrarProximaInterfaz(jugador);

                } catch (ExcepcionUsuario | ExcepcionJuego e) {
                    vista.mostrarError(e.getMessage());
                }
            }else {
                vista.mostrarError("Indique con cuantos cartones desea jugar");
            }
        }else {
            vista.mostrarError("Debes ingresar un número");
        }  
    }

    private boolean esNumerico(String cantCartones) {
        try {
            Integer.parseInt(cantCartones);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    
}
