package Dominio.Fachada;

import Dominio.Juego.SistemaJuego;
import Dominio.Usuarios.Administrador;
import Dominio.Usuarios.SistemaUsuario;
import Dominio.Usuarios.Usuario;
import Excepciones.ExcepcionUsuario;

public class Fachada {
    private static Fachada instancia;
    
    public static Fachada getInstancia(){
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }
    
    private SistemaJuego sjuego = new SistemaJuego();
    private SistemaUsuario sUsuario = new SistemaUsuario();
    

    public Administrador loginAdministrador(String cedula, String password) throws ExcepcionUsuario {
        return sUsuario.loginAdministrador(cedula, password);
    }

    public void agregarUsuario(Usuario usuario) {
        sUsuario.agregarUsuario(usuario);
    }
}
