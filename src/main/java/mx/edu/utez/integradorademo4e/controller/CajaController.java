package mx.edu.utez.integradorademo4e.controller;

import mx.edu.utez.integradorademo4e.entity.Cliente;
import mx.edu.utez.integradorademo4e.service.ICajaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CajaController {

    @Autowired
    private ICajaService service;

    @PostMapping("/agregar/{id}")
    @ResponseBody
    public Object agregarCliente(@PathVariable Long id) {
        try {
            Cliente cliente = service.agregarCliente(id);
            return cliente; // Retorna el cliente agregado
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage(); // Retorna un mensaje de error si el cliente no existe
        } catch (Exception e) {
            return "Error al agregar el cliente a la cola.";
        }
    }

    @GetMapping("/ver-fila")
    public List<Cliente> verFila() {
        return service.verFila();
    }

    @GetMapping("/atender-cliente")
    public Cliente atenderCliente() {
        return service.atenderCliente();
    }


}
