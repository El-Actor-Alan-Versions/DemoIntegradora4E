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

import java.util.ArrayList;
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
            // carrito del cliente
            List<CarritoProducto> productosCarrito = carritoService.obtenerCarritoPorCliente(clienteId);

            if (productosCarrito.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El carrito está vacío.");
            }

            // Calcular el total y generar los detalles de la compra
            double totalPagar = 0.0;
            List<String> detalles = new ArrayList<>();
            detalles.add("Detalle de compra:");

            for (CarritoProducto item : productosCarrito) {
                double subtotal = item.getCantidad() * item.getProducto().getPrecio();
                totalPagar += subtotal;
                detalles.add(String.format("- %s (Cantidad: %d, Precio: %.2f) -> Subtotal: %.2f",
                        item.getProducto().getNombre(),
                        item.getCantidad(),
                        item.getProducto().getPrecio(),
                        subtotal));
            }

            // Agregamos el total al final de los detalles
            detalles.add(String.format("Total a pagar: %.2f", totalPagar));

            // Limpiamos el carrito tras la compra
            carritoService.limpiarCarrito(clienteId);

            // Atendemos osea quitamos al cliente en la caja
            cajaService.atenderCliente();

            // Unir los detalles con saltos de línea
            String mensajeCompra = String.join("\n", detalles);

            return ResponseEntity.ok(mensajeCompra);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la compra.");
        }
    }

}

