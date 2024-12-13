package mx.edu.utez.integradorademo4e.service;

import mx.edu.utez.integradorademo4e.entity.CarritoProducto;
import mx.edu.utez.integradorademo4e.entity.dao.ICarritoProductoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoProductoServiceImpl implements ICarritoProductoService {
    @Autowired
    ICarritoProductoDao dao;
    @Override
    @Transactional
    public CarritoProducto addCarritoProducto(CarritoProducto carritoProducto) {
        dao.save(carritoProducto);
        return carritoProducto;
        }
    @Override
    @Transactional
    public CarritoProducto eliminarCarritoProducto(Long id) {
        Optional<CarritoProducto> carritoProducto = dao.findById(id);
        if (carritoProducto.isPresent()) {
            dao.deleteById(id);
            return carritoProducto.get();
        }
        return null;
    }
    @Override
    public List<CarritoProducto> obtenerCarritoPorCliente(Long clienteId) {
        return dao.findByClienteId(clienteId);
    }
    @Override
    public void limpiarCarrito(Long clienteId) {
        List<CarritoProducto> productosCarrito = dao.findByClienteId(clienteId);
        productosCarrito.forEach(producto -> dao.deleteById(producto.getId()));
    }
}