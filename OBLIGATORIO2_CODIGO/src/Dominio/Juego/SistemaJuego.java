package Dominio.Juego;

import Dominio.Usuarios.Jugador;
import Excepciones.ExcepcionJuego;
import Utilidades.Configuracion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SistemaJuego {
    private List<Juego> juegos = new ArrayList();
    private Configuracion config = Configuracion.getInstancia();
    private int idJuego = 1000;
   

    public List<Juego> getJuegos() {
        return juegos;
    }

    public int cantMaxCartones() {
        return config.getMaxCartones();
    }

    public void cantCartonesMayorMaxCartones(int cantCartones) throws ExcepcionJuego{
        if (cantCartones > config.getMaxCartones()) {
            throw new ExcepcionJuego("No puede participar con más de " + config.getMaxCartones() + " cartones");
        }
    }

    public void jugadorPerteneceABingo(Jugador jugador) throws ExcepcionJuego{
        for (Juego juego : juegos) {
            juego.jugadorPerteneceABingo(jugador);
        }
    }

    public void saldoJugadorNoSuficiente(Jugador jugador, int cantCartones) throws ExcepcionJuego{
        double valorCartones = cantCartones * (config.getValorCarton() * 3);
        jugador.saldoSuficiente(valorCartones);
    }

    public Juego agregarJugadorAJuego(Jugador jugador){
        //salir a buscar el primer juego que este en espera que entre.
        //Si no hay uno en espera, se crea un Juego nuevo y se pone en espera.
        Juego juegoABuscar = null;
        int largo = this.juegos.size();
        int contador = 0;
        boolean pertenece = false;
        while(contador < largo && !pertenece){
            Juego juegoActual = this.juegos.get(contador);
            if (juegoActual.estaEnEspera()) {
                juegoActual.setJugador(jugador);
                juegoABuscar = juegoActual; 
                pertenece = true;
            }
            contador++;
        }
        if (juegoABuscar == null) {
            juegoABuscar = agregarNuevoJuego(jugador);
        }
        return juegoABuscar;
    }

    public int getCantFilasCarton() {
        return this.config.getFilasCarton();
    }

    public int getCantColumnasCarton() {
        return this.config.getColumnasCarton();
    }
    
    public Juego agregarNuevoJuego(Jugador jugador){
        Juego juego = new Juego(this.idJuego, Arrays.asList(config.getFigurasHabilitadas()), config.getCantJugadores());
        juego.setJugador(jugador);
        juego.setEstado(EstadosJuego.EN_ESPERA);
        this.idJuego++;
        this.juegos.add(juego);
        return juego;
    }

    public void cargarCartones(Juego juego, Jugador jugador) {
        juego.cargarCartones(config.getFilasCarton(), config.getColumnasCarton(), config.getValorCarton(), jugador);
    }

    public void juegoListoParaEmpezar(Juego juego) {
        juego.listoParaEmpezar();
    }
    
}
