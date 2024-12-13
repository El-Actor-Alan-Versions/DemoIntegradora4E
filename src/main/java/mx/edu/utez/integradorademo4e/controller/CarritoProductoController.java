package mx.edu.utez.integradorademo4e.controller;

import mx.edu.utez.integradorademo4e.service.ICarritoProductoService;
import mx.edu.utez.integradorademo4e.entity.CarritoProducto;
import mx.edu.utez.integradorademo4e.utils.CustomStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/carrito")
public class CarritoProductoController {

    @Autowired
    private ICarritoProductoService service;

    private final Map<Long,CustomStack<CarritoProducto>> historialEliminados= new HashMap<>();


    @PostMapping("/agregar")// /carrito/agregar
    public CarritoProducto agregar(@RequestBody CarritoProducto carritoProducto) {
        service.addCarritoProducto(carritoProducto);
        return carritoProducto;
    }

    @PostMapping("/eliminar")
    public ResponseEntity<String> eliminar(@RequestBody CarritoProducto carritoProducto) {
        CarritoProducto productoEliminado = service.eliminarCarritoProducto(carritoProducto.getId());
        if (productoEliminado != null) {
            historialEliminados.computeIfAbsent(carritoProducto.getCliente().getId(), k -> new CustomStack<>(100)).push(productoEliminado);
            return ResponseEntity.ok("Producto eliminado del carrito.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo eliminar el producto.");
    }

    @PostMapping("/deshacer/{clienteId}")
    public ResponseEntity<String> deshacerEliminacion(@PathVariable Long clienteId) {
        CustomStack<CarritoProducto> historial = historialEliminados.get(clienteId);
        if (historial != null && !historial.isEmpty()) {
            CarritoProducto productoRestaurado = historial.pop();
            service.addCarritoProducto(productoRestaurado);
            return ResponseEntity.ok("Producto restaurado al carrito.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No hay eliminaciones para deshacer.");
    }


}