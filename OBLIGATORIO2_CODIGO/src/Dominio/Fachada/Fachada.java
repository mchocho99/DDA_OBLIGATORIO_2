package Dominio.Fachada;

import Dominio.Juego.SistemaJuego;

public class Fachada {
    private static Fachada instancia;
    
    public static Fachada getInstancia(){
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }
    
    private SistemaJuego sjuego = new SistemaJuego();
}
