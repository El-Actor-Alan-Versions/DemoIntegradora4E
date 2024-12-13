package mx.edu.utez.integradorademo4e.service;

import mx.edu.utez.integradorademo4e.entity.Cliente;
import mx.edu.utez.integradorademo4e.entity.dao.IClienteDao;
import mx.edu.utez.integradorademo4e.service.ICajaService;
import mx.edu.utez.integradorademo4e.utils.CustomQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CajaService implements ICajaService {

    private final CustomQueue<Cliente> queue = new CustomQueue<>(100);
    private final CustomQueue<Cliente> tempqueue = new CustomQueue<>(100);


    @Autowired
    private IClienteDao clienteDao;

    @Override
    public Cliente agregarCliente(Long id) {
        Optional<Cliente> cliente = clienteDao.findById(id);
        if (cliente.isPresent()) {
            Cliente clienteQueue = cliente.get(); // Usa el cliente original directamente
            if (queue.isFull()) {
                throw new IllegalStateException("La cola está llena. No se puede agregar más clientes.");
            }
            queue.offer(clienteQueue);
            return clienteQueue;
        } else {
            throw new IllegalArgumentException("El cliente con ID " + id + " no existe.");
        }
    }

    @Override
    public List<Cliente> verFila() {
        List<Cliente> listaClientes = new ArrayList<>();
        CustomQueue<Cliente> tempQueue = new CustomQueue<>(100); // Usamos una cola temporal para no vaciar la original

        // Iteramos sobre la cola original para copiar los elementos a la lista
        while (!queue.isEmpty()) {
            Cliente cliente = queue.poll();
            listaClientes.add(cliente);
            tempQueue.offer(cliente);  // Mantenemos los elementos en la cola temporal
        }

        // Después de agregar todos los clientes, restauramos la cola original
        while (!tempQueue.isEmpty()) {
            queue.offer(tempQueue.poll());
        }

        return listaClientes;
    }

    @Override
    public Cliente atenderCliente() {

        Cliente cliente = queue.poll();;

        return cliente;
    }

}
