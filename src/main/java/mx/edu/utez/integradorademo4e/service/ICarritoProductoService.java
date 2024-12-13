package mx.edu.utez.integradorademo4e.service;

import mx.edu.utez.integradorademo4e.entity.CarritoProducto;

import java.util.List;
import java.util.Optional;

public interface ICarritoProductoService {
    public CarritoProducto addCarritoProducto(CarritoProducto carritoProducto);
    public CarritoProducto eliminarCarritoProducto(Long id);
    public List<CarritoProducto> obtenerCarritoPorCliente(Long clienteId);
    public void limpiarCarrito(Long clienteId);
}

