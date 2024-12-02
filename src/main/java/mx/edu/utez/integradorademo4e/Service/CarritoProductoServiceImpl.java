package mx.edu.utez.integradorademo4e.Service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

public class CarritoProductoServiceImpl implements ICarritoService {
    private static final Logger log = Logger.getLogger(CarritoProductoServiceImpl.class);

    @Autowired
    private ICarritoProductoDao carritoProductoDao;

    @Override
    @Transactional(readOnly = true)
}
