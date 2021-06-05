package Dominio.Fachada;

import Dominio.Juego.SistemaJuego;
import Dominio.Usuarios.Administrador;
import Dominio.Usuarios.Jugador;
import Dominio.Usuarios.SistemaUsuario;
import Dominio.Usuarios.Usuario;
import Excepciones.ExcepcionJuego;
import Excepciones.ExcepcionUsuario;

public class Fachada {
    private static Fachada instancia;
    
    public static Fachada getInstancia(){
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }
    
    private SistemaJuego sJuego = new SistemaJuego();
    private SistemaUsuario sUsuario = new SistemaUsuario();
    

    public Administrador loginAdministrador(String cedula, String password) throws ExcepcionUsuario {
        return sUsuario.loginAdministrador(cedula, password);
    }

    public void agregarUsuario(Usuario usuario) {
        sUsuario.agregarUsuario(usuario);
    }
    
    public void cantCartonesMayorMaxCartones(int cantCartones) throws ExcepcionJuego{
        sJuego.cantCartonesMayorMaxCartones(cantCartones);
    }

    public Jugador loginJugador(String cedula, String password, int cantCartones) throws ExcepcionUsuario{
        return sUsuario.loginJugador(cedula, password, cantCartones);
    }

    public void jugadorPerteneceABingo(Jugador jugador) throws ExcepcionJuego{
        sJuego.jugadorPerteneceABingo(jugador);
    }

    public void saldoJugadorNoSuficiente(Jugador jugador, int cantCartones) throws ExcepcionJuego{
        sJuego.saldoJugadorNoSuficiente(jugador, cantCartones);
    }
}
