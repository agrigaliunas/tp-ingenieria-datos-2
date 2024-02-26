package ar.edu.uade.tpbd2.services;

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
            System.out.println(catalogoDeProductoAnterior);
            if (catalogoDeProductoAnterior == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(catalogoDeProductoAnterior);
            }

            catalogoDeProductoAnterior.ActualizarCatalogoDeProducto(catalogoDeProductoActual);
            CatalogoDeProducto nuevoProducto = this.catalogoDeProductosRepository.save(catalogoDeProductoAnterior);
            return new ResponseEntity<>(nuevoProducto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new CatalogoDeProducto(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> borrarCatalogoDeProducto(final String productoID) {
        try {
            System.out.println("delete - ProductoID:" + productoID);
            this.catalogoDeProductosRepository.deleteByProductoID(productoID);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            System.out.println("error delete - ProductoID:" + productoID);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
