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
        Linea linea = new Linea("Línea", 0.0);
        Diagonal diagonal = new Diagonal("Diagonal", 0.5);
        Perimetro perimetro = new Perimetro("Perímetro", 1.0);
        CartonLleno cartonLleno = new CartonLleno("Cartón Lleno", 2.0);
        TipoFigura[] figurasHabilitadas = new TipoFigura[4];
        figurasHabilitadas[0] = linea;
        figurasHabilitadas[1] = diagonal;
        figurasHabilitadas[2] = perimetro;
        figurasHabilitadas[3] = cartonLleno;
        
        /*CONFIGURACION*/
        Configuracion config = Configuracion.getInstancia();
        config.setearConfig(3, 3, 3, 3, 300, figurasHabilitadas);
        Fachada fachada = Fachada.getInstancia();
        
        /*USUARIOS*/
        Administrador admin1 = new Administrador("admin1@gmail.com", "12345678", "admin123", "Admin1");
        Administrador admin2 = new Administrador("admin2@gmail.com", "12345675", "admin123", "Admin2");

        Jugador jugador1 = new Jugador(30000, "12345679", "jugador123", "jugador1");
        Jugador jugador2 = new Jugador(40000, "12345670", "jugador123", "jugador2");
        Jugador jugador3 = new Jugador(50000, "12345671", "jugador123", "jugador3");
        Jugador jugador4 = new Jugador(60000, "12345672", "jugador123", "jugador4");
        Jugador jugador5 = new Jugador(900, "12345673", "jugador123", "jugador5");
        
        fachada.agregarUsuario(admin1);   
        fachada.agregarUsuario(admin2); 
        fachada.agregarUsuario(jugador1);
        fachada.agregarUsuario(jugador2);
        
        fachada.agregarUsuario(jugador3);
        fachada.agregarUsuario(jugador4);
        fachada.agregarUsuario(jugador5);
        
//        Carton carton = new Carton(3, 4, 100, null);
//        carton.getMatrizCarton()[0][0].setMarcado(true);
//        carton.getMatrizCarton()[0][1].setMarcado(true);
//        carton.getMatrizCarton()[0][2].setMarcado(true);
//        carton.getMatrizCarton()[0][3].setMarcado(true);
//        carton.getMatrizCarton()[1][0].setMarcado(true);
//        carton.getMatrizCarton()[1][3].setMarcado(true);
//        carton.getMatrizCarton()[2][0].setMarcado(true);
//        carton.getMatrizCarton()[2][1].setMarcado(true);
//        carton.getMatrizCarton()[2][2].setMarcado(true);
//        carton.getMatrizCarton()[2][3].setMarcado(true);
//        perimetro.completo(carton.getMatrizCarton(), 3, 4);
    }
}
