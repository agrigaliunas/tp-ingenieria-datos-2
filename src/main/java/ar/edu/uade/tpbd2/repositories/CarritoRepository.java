package ar.edu.uade.tpbd2.repositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.uade.tpbd2.persistence.model.Carrito;
import ar.edu.uade.tpbd2.persistence.model.Producto;

@Repository
public interface CarritoRepository extends MongoRepository<Carrito, String>{
	
    // ?0 corresponde al primer parametro de findByNickname
    @Query("{ 'nickname' : ?0 }")
    Optional<Carrito> findByNickname(final String nickname);
    
    Optional<Carrito> findByIdAndProductosActual_ProductoId(String carritoId, String productoId);
}
