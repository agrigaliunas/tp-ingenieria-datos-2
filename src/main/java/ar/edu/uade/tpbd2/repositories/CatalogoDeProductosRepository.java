package ar.edu.uade.tpbd2.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import ar.edu.uade.tpbd2.persistence.model.mongo.CatalogoDeProducto;

public interface CatalogoDeProductosRepository extends MongoRepository<CatalogoDeProducto, String> {

    // ?0 corresponde al primer parametro
    @Query("{ 'productoID' : ?0 }")
    Optional<CatalogoDeProducto> findByProductoID(final String productoID);

    void deleteByProductoID(final String productoID);
}


