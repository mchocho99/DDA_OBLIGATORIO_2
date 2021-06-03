package Controlador;

import Dominio.Fachada.Fachada;
import Dominio.Usuarios.Administrador;
import Excepciones.ExcepcionUsuario;

public class ControladorLoginAdministrador {
    private VistaLoginAdministrador vista;
    private Fachada fachada = Fachada.getInstancia();
    
    public ControladorLoginAdministrador(VistaLoginAdministrador vista) {
        this.vista = vista;
        vista.mostrarTitulo("Login administrador");
    }

    public void login(String cedula, String password) {
        try {
            Administrador admin = fachada.loginAdministrador(cedula, password);
            vista.mostrarProximaInterfaz(admin);
            vista.cerrar();
        } catch (ExcepcionUsuario ex) {
            vista.mostrarError(ex.getMessage());
        }
    }
}
