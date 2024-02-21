package ar.edu.uade.tpbd2.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.edu.uade.tpbd2.persistence.model.Carrito;

@Repository
public interface CarritoRepository extends MongoRepository<Carrito, String>{

}
