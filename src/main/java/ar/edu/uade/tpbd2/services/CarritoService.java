package ar.edu.uade.tpbd2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.uade.tpbd2.persistence.model.Producto;
import ar.edu.uade.tpbd2.repositories.CarritoRepository;

@Service
public class CarritoService{


    @Autowired
    private CarritoRepository repository;

    public void agregarProducto(final Producto producto) {

    }

}
