package mx.edu.utez.integradorademo4e.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table (name = "carrito")
public class CarritoProducto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    // Relación ManyToOne con Cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    // Relación ManyToOne con Producto
    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    // Cantidad del producto en el carrito
    @Column(nullable = false)
    private Integer cantidad;

    public CarritoProducto() {}

    public CarritoProducto(Cliente cliente, Producto producto, Integer cantidad) {}

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}



