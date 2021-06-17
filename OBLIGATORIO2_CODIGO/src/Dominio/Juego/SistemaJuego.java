package Dominio.Juego;

import Dominio.Fachada.Fachada;
import Dominio.Usuarios.Jugador;
import Excepciones.ExcepcionJuego;
import Utilidades.Configuracion;
import Utilidades.Evento;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SistemaJuego {
    private List<Juego> juegos = new ArrayList();
    private Configuracion config = Configuracion.getInstancia();
    private int idJuego = 1;
   

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
        Fachada.getInstancia().avisarEvento(Evento.ACTUALIZAR_LISTA_JUEGOS);
        return juego;
    }

    public void cargarCartones(Juego juego, Jugador jugador) {
        juego.cargarCartones(config.getFilasCarton(), config.getColumnasCarton(), config.getValorCarton(), jugador);
    }

    public void juegoListoParaEmpezar(Juego juego) {
        if (juego.listoParaEmpezar()) {
            Fachada.getInstancia().avisarEvento(Evento.ACTUALIZAR_LISTA_JUEGOS);
        }
    }

    public Numero sortearNumero(Juego juego) {
        return juego.sortearNumero();
    }

    public boolean marcarNumero(Juego juego, Jugador jugador, Numero numeroSorteado) {
        boolean marco = juego.marcarNumero(jugador, numeroSorteado);
        if(marco) {
            Fachada.getInstancia().avisarEvento(Evento.MARCO);
        }
        return marco;
    }

    public boolean verificarGanador(Juego juego, Jugador jugador) {
        boolean hayGanador = juego.verificarGanador(config.getValorCarton(), jugador, config.getFilasCarton(), config.getColumnasCarton());
        if(hayGanador) {
            Fachada.getInstancia().avisarEvento(Evento.GANADOR);
        }
        return hayGanador;
    }

    public List<Jugador> getDemasJugadores(Juego juego,Jugador jugador) {
        return juego.getDemasJugadores(jugador);
    }

    public Numero getNumeroActual(Juego juego) {
        return juego.getNumeroActual();
    }

    public double getMontoPozoJuego(Juego juego) {
        return juego.getMontoPozoJuego(config.getValorCarton());
    }

    public String getHistoricoNumeros(Juego juego) {
        return juego.getHistoricoNumeros();
    }

    public void seguirJugando(Juego juego, Jugador jugador) {
        boolean sorteo = juego.seguirJugando(jugador);
        if(sorteo) {
            Fachada.getInstancia().avisarEvento(Evento.SORTEO);
        }
    }

    public Jugador getGanador(Juego juego) {
        return juego.getGanador();
    }

    public String getNombreFigura(Jugador ganador) {
        return ganador.getNombreFigura();
    }
    
    public void abandonar(Juego juego, Jugador jugador) {
        if (juego != null) {
            if(juego.tieneJugadores()) {
                boolean gano = juego.abandonar(config.getValorCarton(), jugador);
                if(gano) {
                    Fachada.getInstancia().avisarEvento(Evento.GANADOR);
                }
            }
        }
    }

    public double getMontoADebitar(Jugador jugador, double extra) {
        return jugador.getMontoADebitar(config.getValorCarton(), extra);
    }

    public void eliminarJuego(Juego juego) {     
        juego.eliminarCartones();
        Fachada.getInstancia().avisarEvento(Evento.ACTUALIZAR_LISTA_JUEGOS);
    }

    public String getNombreFiguraGanadora(Jugador ganador) {
        return ganador.getNombreFiguraGanadora();
    }
}
