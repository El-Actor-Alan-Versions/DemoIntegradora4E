package mx.edu.utez.integradorademo4e.controller;

import mx.edu.utez.integradorademo4e.service.ICarritoProductoService;
import mx.edu.utez.integradorademo4e.entity.CarritoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrito")
public class CarritoProductoController {

    @Autowired
    private ICarritoProductoService service;

    @PostMapping("/agregar")// /carrito/agregar
    public CarritoProducto agregar(@RequestBody CarritoProducto carritoProducto) {
        service.addCarritoProducto(carritoProducto);
        return carritoProducto;
    }

}