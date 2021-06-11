package Controlador;

import Dominio.Fachada.Fachada;
import Dominio.Juego.Carton;
import Dominio.Juego.Juego;
import Dominio.Juego.Numero;
import Dominio.Usuarios.Jugador;
import Excepciones.ExcepcionJuego;
import gridLayout.ListaPaneles;
import gridLayout.MarcadorBoton;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorJuego implements MarcadorBoton{

    private VistaJuego vista;
    private Fachada fachada = Fachada.getInstancia();
    private Jugador jugador;
    private Juego juego;
    
    public ControladorJuego(VistaJuego vista, Jugador jugador){
       this.vista = vista;
       this.jugador = jugador;
       this.juego = fachada.agregarJugadorAJuego(jugador);
       //CREAR CARTONES EN BASE A LOS NUMEROS EN JUEGO
       vista.mostrarTitulo(jugador.getNombre());
       vista.mostrarSaldoJugador(jugador.getSaldo());
       generarConDatos(jugador);
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
        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < filas; j++) {
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
   

 }
