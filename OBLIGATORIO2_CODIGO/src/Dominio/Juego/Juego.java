package Dominio.Juego;

import Dominio.Usuarios.Jugador;
import Excepciones.ExcepcionJuego;
import Utilidades.Evento;
import Utilidades.Observable;
import java.util.ArrayList;
import java.util.List;

public class Juego extends Observable{
    private List<Jugador> todosLosJugadores;
    private List<Jugador> activos;
    private int cantCartonesEnJuego;
    private int cantNumerosEnJuego;
    private int numero;
    private List<Numero> numerosQueSalieron;
    private List<Numero> numerosDelJuego;
    private List<Integer> numerosParaCarton;
    private EstadosJuego estado;
    private List<TipoFigura> figurasHabilitadas;
    private int cantMaxJugadores;
    private Jugador ganador;
    
    public Juego(int numero, List<TipoFigura> figurasHabilitadas, int cantMaxJugadores) {
        this.todosLosJugadores = new ArrayList<>();
        this.activos = new ArrayList<>();
        this.numerosQueSalieron = new ArrayList<>();
        this.numero = numero;
        this.numerosDelJuego = new ArrayList<>();
        this.numerosParaCarton = new ArrayList<>();
        this.estado = EstadosJuego.EN_ESPERA;
        this.figurasHabilitadas = figurasHabilitadas;
        this.cantMaxJugadores = cantMaxJugadores;
        this.ganador = null;
    }

    public List<Jugador> getTodosLosJugadores() {
        return todosLosJugadores;
    }

    public void setJugador(Jugador jugador) {
        if(!this.todosLosJugadores.contains(jugador)) {
            this.todosLosJugadores.add(jugador);
        }
    }

    public List<Jugador> getActivos() {
        return activos;
    }

    public void setJugadorActivo(Jugador jugador) {
        if(!this.activos.contains(jugador)) {
            this.activos.add(jugador);
        }
    }
    
    public int getCantCartonesEnJuego() {
        return cantCartonesEnJuego;
    }

    public void setCantCartonesEnJuego(int cantCartonesEnJuego) {
        this.cantCartonesEnJuego = cantCartonesEnJuego;
    }

    public int getCantNumerosEnJuego() {
        return cantNumerosEnJuego;
    }

    public void setCantNumerosEnJuego(int cantNumerosEnJuego) {
        this.cantNumerosEnJuego = cantNumerosEnJuego;
    }

    public int getNumero() {
        return numero;
    }

    public List<Numero> getNumerosQueSalieron() {
        return numerosQueSalieron;
    }

    public void setNumerosQueSalieron(Numero numero) {
        if (!numerosQueSalieron.contains(numero)) {
            numerosQueSalieron.add(numero);
        }
    }

    public List<Numero> getNumerosDelJuego() {
        return numerosDelJuego;
    }

    public void setNumerosDelJuego(int cantNumerosPorCarton) {
        if(this.numerosDelJuego.isEmpty()) {
            int cantNumeros = 0;
            for (Jugador jugador : todosLosJugadores) {
                cantNumeros += jugador.getCantNumeros(cantNumerosPorCarton);
            }

            for (int i = 1; i <= cantNumeros; i++) {
                this.numerosDelJuego.add(new Numero(i, false));
            }
        }
    }

    public EstadosJuego getEstado() {
        return estado;
    }

    public void setEstado(EstadosJuego estado) {
        this.estado = estado;
    }

    public List<TipoFigura> getFigurasHabilitadas() {
        return figurasHabilitadas;
    }
   

    void jugadorPerteneceABingo(Jugador jugador) throws ExcepcionJuego{
        if (todosLosJugadores.contains(jugador)) {
            throw new ExcepcionJuego("El jugador " + jugador.getCedula() + " ya está participando del bingo");
        }
    }

    public boolean estaEnEspera() {
        return this.getEstado() == EstadosJuego.EN_ESPERA;
    }
    
     public Jugador getGanador() {
        return ganador;
    }
    
    public void cargarCartones(int filasCarton, int columnasCarton, double valorCarton, Jugador jugador) {
        //SEPARAR METODO.
        setNumerosDelJuego(filasCarton*columnasCarton);
        int cantCartonesJugador = jugador.getCantCartonesSolicitados();
        for (int i = 0; i < cantCartonesJugador; i++) {
            Carton carton = new Carton(filasCarton, columnasCarton, valorCarton, this.figurasHabilitadas);
            int cantNumeros = filasCarton*columnasCarton;
            for (int j = 0; j < cantNumeros; j++) {
                int range = this.numerosDelJuego.size();
                int numero = (int)(Math.random() * range + 1);
                if(!this.numerosParaCarton.contains(numero)) {
                    this.numerosParaCarton.add(numero);
                    carton.setMatrizCarton(numero);      
                }else {
                    j--;
                }
            }
            jugador.setCarton(carton);
        }
    }

    public void listoParaEmpezar() {
        if(this.todosLosJugadores.size() == this.cantMaxJugadores) {
            this.setEstado(EstadosJuego.ACTIVO);      
            for (Jugador jug : todosLosJugadores) {
                this.setJugadorActivo(jug);
            }
            this.avisarEvento(Evento.JUEGO_ACTIVO);
            Numero numero = this.sortearNumero();
            this.avisarEvento(Evento.SORTEO);
        }
    }

    public Numero sortearNumero() {
        int range = this.numerosDelJuego.size();
        Numero num = new Numero();
        boolean salio = false;
        while(!salio){
            int numero = (int)(Math.random() * range + 1);
            num = new Numero(numero,false);
            if (!this.getNumerosQueSalieron().contains(num)) {
                this.getNumerosQueSalieron().add(num);
                salio = true;
            }
        }
        return num;
    }

    boolean marcarNumero(Jugador jugador, Numero numeroSorteado) {
        return jugador.marcarNumero(numeroSorteado);
    }

    boolean verificarGanador(Jugador jugador, int filas, int columnas) {
        boolean gano = jugador.verificarGanador(filas,columnas);
        if (gano) {     
            this.ganador = jugador;        
            this.avisarEvento(Evento.GANADOR);           
            return true;
        }
        return false;
    }

    List<Jugador> getDemasJugadores(Jugador jugador) {
        List<Jugador> aux = new ArrayList<>();
        for (Jugador jugadorActivo : todosLosJugadores) {
            if (jugador.getNombre() != jugadorActivo.getNombre()) {
                aux.add(jugadorActivo);
            }
        }
        return aux;
    }

    public Numero getNumeroActual() {
        int largo = this.numerosQueSalieron.size();
        return this.numerosQueSalieron.get(largo-1);
    }

    public double getMontoPozoJuego(double valorCarton) {
        double monto = 0;
        for (Jugador jugador : this.todosLosJugadores) {
            monto+=jugador.getCantCartonesSolicitados()*valorCarton;
        }
        return monto;
    }

    public String getHistoricoNumeros() {
        String historicoNumeros = "";
        for (int i = this.numerosQueSalieron.size()-1; i >= 0; i--) {
            if(i == 0) {
                historicoNumeros += this.numerosQueSalieron.get(i).getNumero();
            } else {
                historicoNumeros += this.numerosQueSalieron.get(i).getNumero() + "-";
            }
        }
        return historicoNumeros;
    }

    public void seguirJugando(Jugador jugador) {
        jugador.setListo(true);
        int listos = 0;
        int largoActivos = this.activos.size();
        for (Jugador unJ : this.activos) {
            if(unJ.getListo()) {
                listos++;
            }
        }
        if(listos == largoActivos) {
            Numero numeroSorteado = this.sortearNumero();
            this.volverJugadoresANoListo();
            this.avisarEvento(Evento.SORTEO);
        }
    }

    private void volverJugadoresANoListo() {
        for (Jugador jugador : this.activos) {
            jugador.setListo(false);
        }
    }

    @Override
    public String toString() {
        return  numero + " - " + estado;
    }

   
    
    
    
}
