package ar.edu.uade.tpbd2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mongodb.BasicDBObject;

import ar.edu.uade.tpbd2.persistence.model.Carrito;
import ar.edu.uade.tpbd2.persistence.model.Producto;
import ar.edu.uade.tpbd2.repositories.CarritoRepository;

@Service
public class CarritoService {

	@Autowired
	public MongoTemplate mongoTemplate;
	
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

    public ResponseEntity<Carrito> agregarProducto(final String carritoId, final Producto producto) throws Exception {
        Carrito carrito = this.carritoRepository.findById(carritoId).orElse(null);

        if (carrito != null) {
        	carrito.actualizarEstado();
            carrito.addNewProduct(producto);

            this.carritoRepository.save(carrito);
        }else {
            throw new Exception("No se encontro el carrito de este id: " + carritoId);
        }

        return ResponseEntity.status(HttpStatus.OK).body(carrito);
    }
    
    // TODO:
    // implement
    public ResponseEntity<String> eliminarProducto(final String carritoId, final String productoId) throws Exception {
    }
}
