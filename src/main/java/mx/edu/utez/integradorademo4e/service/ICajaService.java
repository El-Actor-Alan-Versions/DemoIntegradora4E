package mx.edu.utez.integradorademo4e.service;

import mx.edu.utez.integradorademo4e.entity.Cliente;

import java.util.List;

public interface ICajaService {
    public Cliente agregarCliente (Long id);
    public List<Cliente> verFila ();
    public Cliente atenderCliente ();
}
