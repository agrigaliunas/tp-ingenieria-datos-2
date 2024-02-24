package ar.edu.uade.tpbd2.services;

import ar.edu.uade.tpbd2.persistence.model.Carrito;
import ar.edu.uade.tpbd2.persistence.model.CatalogoDeProductos;
import ar.edu.uade.tpbd2.repositories.CatalogoDeProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CatalogoDeProductosService {

    @Autowired
    private CatalogoDeProductosRepository catalogoDeProductosRepository;

    public ResponseEntity<Carrito> obtenerProductoPorID(final Integer productID) {

        Carrito carrito = this.catalogoDeProductosRepository.findByNickname(productID).orElse(null);

        if (carrito != null) {
            return ResponseEntity.status(HttpStatus.OK).body(carrito);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(carrito);
        }
    }


    public CatalogoDeProductos crearProducto(final CatalogoDeProductos request) {
        return this.catalogoDeProductosRepository.insert(request);
    }
}
