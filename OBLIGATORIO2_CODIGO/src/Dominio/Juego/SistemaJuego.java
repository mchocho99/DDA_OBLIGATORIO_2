package Dominio.Juego;

import Dominio.Usuarios.Jugador;
import Excepciones.ExcepcionJuego;
import Utilidades.Configuracion;
import java.util.ArrayList;
import java.util.List;

public class SistemaJuego {
    private List<Juego> juegos = new ArrayList();
    private Configuracion config = Configuracion.getInstancia();

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

    public Juego agregarJugadorAlJuego(Jugador jugador) throws ExcepcionJuego {
        //buscar si el jugador pertenece a un Juego.
        //Si el jugador no pertenece al juego, salir a buscar el primer juego que este en espera que entre.
        //Si no hay uno en espera, se crea un Juego nuevo y se pone en espera.
        return null;
    }

    public int getCantFilasCarton() {
        return this.config.getFilasCarton();
    }

    public int getCantColumnasCarton() {
        return this.config.getColumnasCarton();
    }
    
}
