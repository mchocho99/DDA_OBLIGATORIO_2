package Utilidades;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    List<Observador> observadores = new ArrayList<Observador>();
    
    public void agregar(Observador observador) {
        if(!observadores.contains(observador)) {
            observadores.add(observador);
        }
    }
    
    public void quitar(Observador observador) {
        observadores.remove(observador);
    }
    
    public void avisarEvento(Object evento) {
        List<Observador> tmp = new ArrayList<>(observadores);
        for (Observador observador : tmp) {
            observador.actualizar(evento, this);
        }
    }
}
