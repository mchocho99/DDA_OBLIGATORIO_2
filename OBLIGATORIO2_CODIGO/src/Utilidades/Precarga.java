package Utilidades;

import Dominio.Fachada.Fachada;
import Dominio.Juego.Carton;
import Dominio.Usuarios.Administrador;
import Dominio.Juego.CartonLleno;
import Dominio.Juego.Diagonal;
import Dominio.Juego.Figura;
import Dominio.Juego.Linea;
import Dominio.Juego.Numero;
import Dominio.Juego.Perimetro;
import Dominio.Juego.TipoFigura;
import Dominio.Usuarios.Jugador;

public class Precarga {
    public static void cargar() {
        
        
        /*FIGURAS*/
        Linea linea = new Linea("Línea");
        Diagonal diagonal = new Diagonal("Diagonal");
        Perimetro perimetro = new Perimetro("Perímetro");
        CartonLleno cartonLleno = new CartonLleno("Cartón Lleno");
        TipoFigura[] figurasHabilitadas = new TipoFigura[4];
        figurasHabilitadas[0] = new Linea("Linea");
        figurasHabilitadas[1] = new Diagonal("Diagonal");
        figurasHabilitadas[2] = new Perimetro("Perimetro");
        figurasHabilitadas[3] = new CartonLleno("Carton Lleno");
        
        /*CONFIGURACION*/
        Configuracion config = Configuracion.getInstancia();
        config.setearConfig(3, 3, 3, 2, 10, figurasHabilitadas);
        Fachada fachada = Fachada.getInstancia();
        
        /*USUARIOS*/
        Administrador admin1 = new Administrador("admin1@gmail.com", "12345678", "admin123", "Admin1");

        Jugador jugador1 = new Jugador(30000, "12345679", "jugador123", "jugador1");
        Jugador jugador2 = new Jugador(40000, "12345670", "jugador123", "jugador2");
        Jugador jugador3 = new Jugador(50000, "12345671", "jugador123", "jugador3");
        Jugador jugador4 = new Jugador(60000, "12345672", "jugador123", "jugador4");
        Jugador jugador5 = new Jugador(1000, "12345673", "jugador123", "jugador5");
        
        fachada.agregarUsuario(admin1);   
        fachada.agregarUsuario(jugador1);
        fachada.agregarUsuario(jugador2);
    }
}
