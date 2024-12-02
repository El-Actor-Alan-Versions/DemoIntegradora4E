package mx.edu.utez.integradorademo4e.service;

import mx.edu.utez.integradorademo4e.entity.Cliente;
import mx.edu.utez.integradorademo4e.entity.dao.IClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServicempl {
    @Autowired
    private IClienteDao iclienteDao;

    public Cliente agregarCliente(Cliente cliente) {
        try {
            return iclienteDao.save(cliente);
        } catch (Exception e) {
            return null;
        }
    }

}
