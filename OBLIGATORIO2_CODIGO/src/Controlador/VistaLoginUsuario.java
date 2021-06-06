package Controlador;

import Dominio.Usuarios.Usuario;

public interface VistaLoginUsuario {
    public void mostrarProximaInterfaz(Usuario usuario);
    public void mostrarError(String mensaje);
    public void cerrar();
    public void mostrarTitulo(String titulo);
}
