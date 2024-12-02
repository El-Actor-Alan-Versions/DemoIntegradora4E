package mx.edu.utez.integradorademo4e.controller;

import mx.edu.utez.integradorademo4e.entity.Producto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductoController {



    @PostMapping("/agregarProducto")
    public boolean agregarProducto(@RequestBody Producto producto) {
        boolean respuesta = false;
        return respuesta;
    }

}
