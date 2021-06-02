package Dominio.Juego;

import Utilidades.Configuracion;
import java.util.ArrayList;
import java.util.List;

public class SistemaJuego {
    private List<Juego> juegos = new ArrayList();
    private Configuracion config = Configuracion.getInstancia();

    public List<Juego> getJuegos() {
        return juegos;
    }
    
}
