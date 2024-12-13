package mx.edu.utez.integradorademo4e.service;

import mx.edu.utez.integradorademo4e.entity.CarritoProducto;
import mx.edu.utez.integradorademo4e.entity.Cliente;

import java.util.List;

public interface IClienteService {
    public Cliente agregarCliente(Cliente cliente);
    public List<Cliente> obtenerClientes();
    public List<CarritoProducto> obtenerCarrito(Long id);
}
