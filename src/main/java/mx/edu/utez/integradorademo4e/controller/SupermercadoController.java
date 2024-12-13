package mx.edu.utez.integradorademo4e.controller;

import mx.edu.utez.integradorademo4e.entity.CarritoProducto;
import mx.edu.utez.integradorademo4e.service.ICajaService;
import mx.edu.utez.integradorademo4e.service.ICarritoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/supermercado")
public class SupermercadoController {

    @Autowired
    private ICarritoProductoService carritoService;

    @Autowired
    private ICajaService cajaService;

    @PostMapping("/comprar/{clienteId}")
    public ResponseEntity<String> procesarCompra(@PathVariable Long clienteId) {
        try {
            // esta lista es por cliente
            List<CarritoProducto> productosCarrito = carritoService.obtenerCarritoPorCliente(clienteId);

            if (productosCarrito.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El carrito está vacío.");
            }

            // si hay carritos, como se esta comprando, se limpia
            carritoService.limpiarCarrito(clienteId);

            // quitamos al cliente pensando que es el primero de la cola en la caja
            cajaService.atenderCliente();

            return ResponseEntity.ok("Compra procesada con éxito.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la compra.");
        }
    }
}

