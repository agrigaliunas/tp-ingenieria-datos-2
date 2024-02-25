package ar.edu.uade.tpbd2.repositories;

import ar.edu.uade.tpbd2.persistence.model.CatalogoDeProducto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface CatalogoDeProductosRepository extends MongoRepository<CatalogoDeProducto, String> {

    // ?0 corresponde al primer parametro de findByNickname
    @Query("{ 'productoID' : ?0 }")
    Optional<CatalogoDeProducto> findByProductoID(final String productoID);

    

}


