package mx.edu.utez.integradorademo4e.Service;

import mx.edu.utez.integradorademo4e.entity.Producto;
import mx.edu.utez.integradorademo4e.entity.dao.IProductoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    IProductoDao dao;

    @Override
    public Producto crearProducto(Producto producto) {

        try{
            if(producto != null){
                dao.save(producto);
            }
            return producto;
        }catch (Exception e){
            e.printStackTrace();
        }
        return producto;
    }
}
