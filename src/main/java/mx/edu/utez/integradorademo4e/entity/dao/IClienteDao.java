package mx.edu.utez.integradorademo4e.entity.dao;

import mx.edu.utez.integradorademo4e.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteDao extends JpaRepository<Cliente,Long> {
}
