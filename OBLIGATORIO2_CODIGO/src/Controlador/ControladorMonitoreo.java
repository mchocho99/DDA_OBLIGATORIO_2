package Controlador;

import Dominio.Fachada.Fachada;
import IU.IUMonitoreo;
import Utilidades.Observable;
import Utilidades.Observador;

public class ControladorMonitoreo implements Observador {
    
    private VistaMonitoreo vista;
    private Fachada fachada = Fachada.getInstancia();

    public ControladorMonitoreo(VistaMonitoreo vista) {
        this.vista = vista;
        vista.mostrarJuegos(fachada.getJuegos());
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
