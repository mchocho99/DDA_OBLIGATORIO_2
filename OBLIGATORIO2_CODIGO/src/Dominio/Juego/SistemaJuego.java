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
            throw new ExcepcionJuego("No puede participar con más de " + cantCartones + " cartones");
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
    
}
