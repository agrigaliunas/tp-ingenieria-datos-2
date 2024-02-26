package ar.edu.uade.tpbd2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.uade.tpbd2.persistence.model.mongo.Pedido;
import ar.edu.uade.tpbd2.repositories.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;


    public Pedido crearPedido(final Pedido pedido) {

        return this.pedidoRepository.insert(pedido);

    }

}
