package mx.edu.utez.integradorademo4e.controller;

import mx.edu.utez.integradorademo4e.service.ICarritoProductoService;
import mx.edu.utez.integradorademo4e.entity.CarritoProducto;
import mx.edu.utez.integradorademo4e.service.IClienteService;
import mx.edu.utez.integradorademo4e.utils.CustomStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/carrito")
public class CarritoProductoController {

    @Autowired
    private ICarritoProductoService service;
    @Autowired
    private IClienteService service2;

    private final Map<Long, CustomStack<CarritoProducto>> historialEliminados= new HashMap<>();




    @PostMapping("/agregar")// /carrito/agregar
    public CarritoProducto agregar(@RequestBody CarritoProducto carritoProducto) {
        service.addCarritoProducto(carritoProducto);
        return carritoProducto;
    }

}