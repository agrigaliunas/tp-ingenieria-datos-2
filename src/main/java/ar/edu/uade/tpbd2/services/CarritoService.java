package ar.edu.uade.tpbd2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ar.edu.uade.tpbd2.persistence.model.Carrito;
import ar.edu.uade.tpbd2.repositories.CarritoRepository;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    public ResponseEntity<Carrito> obtenerCarritoPorNickname(final String nickname) {

        Carrito carrito = this.carritoRepository.findByNickname(nickname)
                .orElse(null);

        if (carrito != null) {
            return ResponseEntity.status(HttpStatus.OK).body(carrito);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(carrito);
        }
    }


    public Carrito crearCarrito(final Carrito request) {
        return this.carritoRepository.insert(request);
    }
}
