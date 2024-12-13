package mx.edu.utez.integradorademo4e.service;

import mx.edu.utez.integradorademo4e.entity.CarritoProducto;
import mx.edu.utez.integradorademo4e.entity.Cliente;
import mx.edu.utez.integradorademo4e.entity.dao.ICarritoProductoDao;
import mx.edu.utez.integradorademo4e.entity.dao.IClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceU {
    @Autowired
    IClienteDao clienteRepository;

    public List<CarritoProducto> obtenerCarrito(Long id){
        Cliente cliente=clienteRepository.findById(id).orElseThrow(()->new RuntimeException("No hay cliente con ese Id"));
                return cliente.getCarrito();
    }


}
