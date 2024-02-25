package ar.edu.uade.tpbd2.services;

import ar.edu.uade.tpbd2.persistence.model.Carrito;
import ar.edu.uade.tpbd2.persistence.model.CatalogoDeProducto;
import ar.edu.uade.tpbd2.repositories.CatalogoDeProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CatalogoDeProductosService {

    @Autowired
    private CatalogoDeProductosRepository catalogoDeProductosRepository;

    public ResponseEntity<CatalogoDeProducto> obtenerProductoPorID(final String productID) {
        CatalogoDeProducto catalogoDeProducto = this.catalogoDeProductosRepository.findByProductoID(productID).orElse(null);

        if (catalogoDeProducto != null) {
            return ResponseEntity.status(HttpStatus.OK).body(catalogoDeProducto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(catalogoDeProducto);
        }
    }


    public CatalogoDeProducto crearProducto(final CatalogoDeProducto request) {
        return this.catalogoDeProductosRepository.insert(request);
    }
}
