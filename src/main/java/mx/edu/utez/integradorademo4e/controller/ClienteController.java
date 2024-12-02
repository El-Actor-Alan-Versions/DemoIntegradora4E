package mx.edu.utez.integradorademo4e.controller;

import mx.edu.utez.integradorademo4e.Service.ClienteServicempl;
import mx.edu.utez.integradorademo4e.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteServicempl clienteService;

    @PostMapping("/agregarCliente")
    public ResponseEntity<Cliente> agregarCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.agregarCliente(cliente);

        if (nuevoCliente != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}

