package mx.edu.utez.integradorademo4e.service;

import mx.edu.utez.integradorademo4e.entity.Cliente;

import java.util.List;

public interface IClienteService {
    public Cliente agregarCliente(Cliente cliente);
    public List<Cliente> obtenerClientes();
}
