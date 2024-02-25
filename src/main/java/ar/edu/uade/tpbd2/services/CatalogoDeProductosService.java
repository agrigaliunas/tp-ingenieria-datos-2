package ar.edu.uade.tpbd2.services;

import ar.edu.uade.tpbd2.persistence.model.Actividad;
import ar.edu.uade.tpbd2.persistence.model.CatalogoDeProducto;
import ar.edu.uade.tpbd2.repositories.CatalogoDeProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CatalogoDeProductosService {

    @Autowired
    private CatalogoDeProductosRepository catalogoDeProductosRepository;

    public ResponseEntity<CatalogoDeProducto> obtenerCatalogoDeProductoPorID(final String productID) {
        try {
            CatalogoDeProducto catalogoDeProducto = this.catalogoDeProductosRepository.findByProductoID(productID).orElse(null);
            if (catalogoDeProducto != null) {
                return ResponseEntity.status(HttpStatus.OK).body(catalogoDeProducto);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(catalogoDeProducto);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new CatalogoDeProducto(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<CatalogoDeProducto> crearCatalogoProductoProducto(final CatalogoDeProducto request) {
        try {
            CatalogoDeProducto nuevoProducto = this.catalogoDeProductosRepository.insert(request);
            return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new CatalogoDeProducto(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<CatalogoDeProducto> actualizarCatalogoDeProducto(final String productoID, final CatalogoDeProducto catalogoDeProductoActual) {
        try {
            if (!catalogoDeProductoActual.getActividades().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(catalogoDeProductoActual);
            }

            CatalogoDeProducto catalogoDeProductoAnterior = this.catalogoDeProductosRepository.findByProductoID(productoID).orElse(null);
            if (catalogoDeProductoAnterior == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(catalogoDeProductoAnterior);
            }

            catalogoDeProductoActual.setActividades(new ArrayList<Actividad>());
            catalogoDeProductoActual.setActividades(catalogoDeProductoActual.compararCon(catalogoDeProductoAnterior));
            catalogoDeProductoActual.unirActividades(catalogoDeProductoAnterior.getActividades());
            CatalogoDeProducto nuevoProducto = this.catalogoDeProductosRepository.insert(catalogoDeProductoActual);

            return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new CatalogoDeProducto(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> deleteCatalogoDeProducto(final String productoID) {
        try {
            this.catalogoDeProductosRepository.deleteById(productoID);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
