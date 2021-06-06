package Controlador;

import Dominio.Fachada.Fachada;
import Dominio.Usuarios.Administrador;
import Dominio.Usuarios.Usuario;
import Excepciones.ExcepcionUsuario;

public class ControladorLoginAdministrador {
    private VistaLoginUsuario vista;
    private Fachada fachada = Fachada.getInstancia();
    
    public ControladorLoginAdministrador(VistaLoginUsuario vista) {
        this.vista = vista;
        vista.mostrarTitulo("Login administrador");
    }

    public void login(String cedula, String password) {
        try {
            Usuario usuario = fachada.login(cedula, password);
            vista.mostrarProximaInterfaz(usuario);
        } catch (ExcepcionUsuario ex) {
            vista.mostrarError(ex.getMessage());
        }
    }
}
