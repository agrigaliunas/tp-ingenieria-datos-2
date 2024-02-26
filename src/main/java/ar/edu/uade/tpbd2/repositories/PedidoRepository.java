package ar.edu.uade.tpbd2.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import ar.edu.uade.tpbd2.persistence.model.mongo.Pedido;

public interface PedidoRepository extends MongoRepository<Pedido, String> {

}
