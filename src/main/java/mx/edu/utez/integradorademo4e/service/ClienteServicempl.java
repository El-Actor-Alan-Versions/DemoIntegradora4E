package mx.edu.utez.integradorademo4e.service;

import mx.edu.utez.integradorademo4e.entity.Cliente;
import mx.edu.utez.integradorademo4e.entity.CarritoProducto;
import mx.edu.utez.integradorademo4e.entity.dao.IClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicempl implements IClienteService {
    @Autowired
    private IClienteDao iclienteDao;

    public Cliente agregarCliente(Cliente cliente) {
        try {
            return iclienteDao.save(cliente);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Cliente> obtenerClientes() {
        List<Cliente> clientes = iclienteDao.findAll();

        return clientes;
    }
    public List<CarritoProducto> obtenerCarrito(Long id){
        Cliente cliente=iclienteDao.findById(id).orElseThrow(()->new RuntimeException("No hay cliente con ese Id"));
        return cliente.getCarrito();
    }

}
