package Dominio.Fachada;

import Dominio.Juego.Figura;
import Dominio.Juego.Juego;
import Dominio.Juego.Numero;
import Dominio.Juego.SistemaJuego;
import Dominio.Usuarios.Administrador;
import Dominio.Usuarios.Jugador;
import Dominio.Usuarios.SistemaUsuario;
import Dominio.Usuarios.Usuario;
import Excepciones.ExcepcionJuego;
import Excepciones.ExcepcionUsuario;
import java.util.List;

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

    public void cargarCartones(Juego juego, Jugador jugador) {
        sJuego.cargarCartones(juego, jugador);
    }

    public void juegoListoParaEmpezar(Juego juego) {
        sJuego.juegoListoParaEmpezar(juego);
    }

    public Numero sortearNumero(Juego juego) {
        return sJuego.sortearNumero(juego);
    }

    public boolean marcarNumero(Juego juego, Jugador jugador, Numero numeroSorteado) {
        return sJuego.marcarNumero(juego, jugador,numeroSorteado);
    }

    public boolean verificarGanador(Juego juego, Jugador jugador) {
        return sJuego.verificarGanador(juego, jugador);
    }

    public List<Jugador> getDemasJugadores(Juego juego,Jugador jugador) {
        return sJuego.getDemasJugadores(juego,jugador);
    }

    public Numero getNumeroActual(Juego juego) {
        return sJuego.getNumeroActual(juego);
    }
    
    public double getMontoPozoJuego(Juego juego) {
        return sJuego.getMontoPozoJuego(juego);
    }

    public String getHistoricoNumeros(Juego juego) {
        return sJuego.getHistoricoNumeros(juego);
    }

    public void seguirJugando(Juego juego, Jugador jugador) {
        sJuego.seguirJugando(juego, jugador);
    }

    public List<Juego> getJuegos() {
        return sJuego.getJuegos();
    }

    public Jugador getGanador(Juego juego) {
        return sJuego.getGanador(juego);
    }

    public void abandonar(Juego juego, Jugador jugador) {
        sJuego.abandonar(juego, jugador);
    }

    public double getMontoADebitar(Jugador jugador, double extra) {
        return sJuego.getMontoADebitar(jugador, extra);
    }

    public void eliminarJuego(Juego juego) {
        sJuego.eliminarJuego(juego);
    }

    public String getNombreFiguraGanadora(Jugador ganador) {
        return sJuego.getNombreFiguraGanadora(ganador);
    }
}
