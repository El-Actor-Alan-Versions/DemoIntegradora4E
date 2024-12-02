package mx.edu.utez.integradorademo4e.controller;

import mx.edu.utez.integradorademo4e.service.IProductoService;
import mx.edu.utez.integradorademo4e.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private IProductoService service;

    @PostMapping("/agregarProducto")
    public Producto agregarProducto(@RequestBody Producto producto) {
        service.crearProducto(producto);
        return producto;
    }

}
