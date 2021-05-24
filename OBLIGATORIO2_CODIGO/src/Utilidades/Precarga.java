package Utilidades;

import Dominio.Administrador;
import Dominio.Juego.CartonLleno;
import Dominio.Juego.Diagonal;
import Dominio.Juego.Figura;
import Dominio.Juego.Linea;
import Dominio.Juego.Perimetro;
import Dominio.Usuarios.Jugador;

public class Precarga {
    
    /*FIGURAS*/
    Linea linea = new Linea("Línea");
    Diagonal diagonal = new Diagonal("Diagonal");
    Perimetro perimetro = new Perimetro("Perímetro");
    CartonLleno cartonLleno = new CartonLleno("Cartón Lleno");
    
    
    
    /*CONFIGURACION*/
    Configuracion config = new Configuracion(3, 3, 3, 3, 100, null); //falta la lista de figuras.
    
    /*USUARIOS*/
    Administrador admin1 = new Administrador("admin1@gmail.com", "12345678", "admin123", "Admin1");
    
    Jugador jugador1 = new Jugador(30000, "12345679", "jugador123", "Jugador1", config.getMaxCartones());
    Jugador jugador2 = new Jugador(40000, "12345670", "jugador1234", "Jugador2", config.getMaxCartones());
    Jugador jugador3 = new Jugador(50000, "12345671", "jugador1235", "Jugador3", config.getMaxCartones());
    Jugador jugador4 = new Jugador(60000, "12345672", "jugador1236", "Jugador4", config.getMaxCartones());
    Jugador jugador5 = new Jugador(1000, "12345673", "jugador1237", "Jugador5", config.getMaxCartones());
}
