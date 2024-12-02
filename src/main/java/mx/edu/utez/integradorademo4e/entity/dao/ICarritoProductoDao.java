package mx.edu.utez.integradorademo4e.entity.dao;

import mx.edu.utez.integradorademo4e.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarritoProductoDao extends JpaRepository<Producto, Long> {
}
