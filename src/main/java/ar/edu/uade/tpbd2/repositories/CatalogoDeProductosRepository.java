package ar.edu.uade.tpbd2.repositories;

import ar.edu.uade.tpbd2.persistence.model.Carrito;
import ar.edu.uade.tpbd2.persistence.model.CatalogoDeProductos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface CatalogoDeProductosRepository extends MongoRepository<CatalogoDeProductos, String> {

    // ?0 corresponde al primer parametro de findByNickname
    @Query("{ 'producto_id' : ?0 }")
    Optional<Carrito> findByNickname(final Integer productoID);

}
