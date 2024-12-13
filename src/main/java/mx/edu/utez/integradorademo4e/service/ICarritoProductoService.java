package mx.edu.utez.integradorademo4e.service;

import mx.edu.utez.integradorademo4e.entity.CarritoProducto;

import java.util.Optional;

public interface ICarritoProductoService {
    public CarritoProducto addCarritoProducto(CarritoProducto carritoProducto);
    public CarritoProducto eliminarCarritoProducto(Long id);
}

