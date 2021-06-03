package Controlador;

import Dominio.Usuarios.Administrador;

public interface VistaLoginAdministrador {
    public void mostrarProximaInterfaz(Administrador administrador);
    public void mostrarError(String mensaje);
    public void cerrar();
    public void mostrarTitulo(String titulo);
}
