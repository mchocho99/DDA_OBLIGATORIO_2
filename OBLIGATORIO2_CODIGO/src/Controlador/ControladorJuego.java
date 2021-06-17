package Controlador;

import Dominio.Fachada.Fachada;
import Dominio.Juego.Carton;
import Dominio.Juego.Juego;
import Dominio.Juego.Numero;
import Dominio.Usuarios.Jugador;
import Utilidades.Evento;
import Utilidades.Observable;
import Utilidades.Observador;
import gridLayout.ListaPaneles;
import gridLayout.MarcadorCasilla;
import java.util.List;

public class ControladorJuego implements MarcadorCasilla, Observador {

    private VistaJuego vista;
    private static Fachada fachada = Fachada.getInstancia();
    private Jugador jugador;
    private Jugador ganador = null;
    private double saldoActual;
    private Juego juego;
    private Numero numeroActual;
    
    public ControladorJuego(VistaJuego vista, Jugador jugador){
       this.vista = vista;
       this.jugador = jugador;
       this.saldoActual = jugador.getSaldo() - fachada.getMontoADebitar(jugador, 0.0);
       
       this.juego = fachada.agregarJugadorAJuego(jugador);
       this.juego.agregar(this);
       vista.mostrarEstadoJuego("Esperando inicio del juego...");
       fachada.juegoListoParaEmpezar(this.juego);
       vista.mostrarTitulo("JUGADOR: " + jugador.getNombre() + " JUEGO N°: " + juego.getNumero());
    }
    
    private void generarConDatos(Jugador jugador) {
        int filas = fachada.getCantFilasCarton();
        int columnas = fachada.getCantColumnasCarton();
        generar(filas, columnas, jugador.getCartones());
    }
    
    private void generar(int filas, int columnas, List<Carton> cartones) {       
        ListaPaneles listaPaneles = new ListaPaneles(filas, columnas);      
        for (Carton carton : cartones) {
            Object[] datos = getData(carton, filas ,columnas);
            listaPaneles.agregarPanel(datos, this);
        }
        vista.mostrarCartonesJugador(listaPaneles);
        listaPaneles.marcar();
    }
    
    public Object[] getData(Carton carton,int filas ,int columnas){
        Object[] datos = new Object[filas * columnas];
        int contador = 0;
        Numero[][] matrizCarton = carton.getMatrizCarton();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                datos[contador] = matrizCarton[i][j];
                contador++;
            }
        }
        return datos;
    }

    @Override
    public boolean marcar(Object dato) {
        return ((Numero)dato).getMarcado();
    }

    @Override
    public String getTexto(Object dato) {
        return ((Numero)dato).getNumero() + "";
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento == Evento.JUEGO_ACTIVO && (origen instanceof Juego)) {
            fachada.cargarCartones(juego, jugador);          
            generarConDatos(jugador);
            vista.mostrarEstadoJuego("Esperando sorteo...");
        }     
        if(evento == Evento.SORTEO && (origen instanceof Juego)) {
            if (this.ganador == null) {
                vista.mostrarEstadoJuego("NO ANOTÓ!");
                this.numeroActual = fachada.getNumeroActual(this.juego);
                boolean marco = fachada.marcarNumero(this.juego, this.jugador, this.numeroActual);
                boolean gano = false;
                if (marco) {
                    gano = fachada.verificarGanador(this.juego, this.jugador);
                    if (!gano) {
                        vista.mostrarEstadoJuego("ANOTÓ!");   
                    }
                }
                if (!gano) {
                    generarConDatos(jugador); 
                    mostrarDatos();
                }
            }else{
                generarConDatos(jugador); 
                mostrarDatos();
            }
        }
        if(evento == Evento.GANADOR && (origen instanceof Juego)) {
           vista.desactivarBotonSeguirJugando();
           this.ganador = fachada.getGanador(this.juego);
           String figuraGanadora = fachada.getNombreFiguraGanadora(this.ganador);
           vista.mostrarEstadoJuego("EL JUGADOR: " + this.ganador.getNombre() + " GANÓ");
           if(figuraGanadora!=null) {
               generarConDatos(jugador); 
               vista.mostrarEstadoJuego("EL JUGADOR: " + this.ganador.getNombre() + " GANÓ CON LA FIGURA: " + figuraGanadora);
           }
           this.saldoActual = jugador.getSaldo();
           this.mostrarDatos();
        }
        
        if(evento == Evento.ABANDONO && (origen instanceof Juego)) {
            if (this.juego.tieneJugadoresActivos()) {
                this.mostrarDatos();
            }
        }
    }
    
    private void mostrarDatos() {
        String historicoNumeros = fachada.getHistoricoNumeros(juego);
        vista.mostrarDatos(this.juego.getFigurasHabilitadas(),
                            fachada.getDemasJugadores(this.juego,this.jugador),
                            this.numeroActual.getNumero(),
                            fachada.getMontoPozoJuego(juego),
                            this.saldoActual,
                            historicoNumeros);
    }

    public void seguirJugando() {
        vista.mostrarEstadoJuego("Esperando...");
        fachada.seguirJugando(juego, jugador);
    }

    public void abandonar() {
        fachada.abandonar(juego, jugador);
        vista.cerrar();
    }
 }
