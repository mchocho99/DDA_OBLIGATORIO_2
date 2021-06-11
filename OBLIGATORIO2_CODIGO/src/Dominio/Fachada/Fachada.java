package Dominio.Fachada;

import Dominio.Juego.Juego;
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
    
    
    public Usuario login(String cedula, String password) throws ExcepcionUsuario {
        return sUsuario.login(cedula, password);
    }

    public void agregarUsuario(Usuario usuario) {
        sUsuario.agregarUsuario(usuario);
    }
    
    public void cantCartonesMayorMaxCartones(int cantCartones) throws ExcepcionJuego{
        sJuego.cantCartonesMayorMaxCartones(cantCartones);
    }

    public void jugadorPerteneceABingo(Jugador jugador) throws ExcepcionJuego{
        sJuego.jugadorPerteneceABingo(jugador);
    }

    public void saldoJugadorNoSuficiente(Jugador jugador, int cantCartones) throws ExcepcionJuego{
        sJuego.saldoJugadorNoSuficiente(jugador, cantCartones);
    }

    public Juego agregarJugadorAJuego(Jugador jugador){
        return sJuego.agregarJugadorAJuego(jugador);
    }

    public int getCantFilasCarton() {
        return sJuego.getCantFilasCarton();
    }

    public int getCantColumnasCarton() {
        return sJuego.getCantColumnasCarton();
    }
}
