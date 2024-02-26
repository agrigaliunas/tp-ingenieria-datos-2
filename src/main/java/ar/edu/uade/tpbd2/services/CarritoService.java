package ar.edu.uade.tpbd2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ar.edu.uade.tpbd2.persistence.model.mongo.Carrito;
import ar.edu.uade.tpbd2.persistence.model.mongo.Producto;
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


    public ResponseEntity<Carrito> crearCarrito(final Carrito request) {
        Carrito carrito = this.carritoRepository.insert(request);
        return ResponseEntity.status(HttpStatus.OK).body(carrito);
    }

    public ResponseEntity<Carrito> agregarProducto(final String nickname, final Producto producto) {
        Carrito carrito = this.carritoRepository.findByNickname(nickname).orElse(null);

        if (carrito != null) {
        	carrito.actualizarEstado();
            carrito.addNewProduct(producto);

            this.carritoRepository.save(carrito);
            return ResponseEntity.status(HttpStatus.OK).body(carrito);

        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Carrito());
        }

    }

    public ResponseEntity<Carrito> actualizarProducto(final String nickname, final Producto producto) {
        Carrito carrito = this.carritoRepository.findByNickname(nickname).orElse(null);

        if (carrito != null) {
            carrito.actualizarEstado();
            carrito.getProductosActual().forEach(p -> {
                if (p.getProductoId() == producto.getProductoId()) {
                    p.setCantidad(producto.getCantidad());
                    p.setNombre(producto.getNombre());
                    p.setDescripcion(producto.getDescripcion());
                    p.setPrecioUnitario(producto.getPrecioUnitario());
                    this.carritoRepository.save(carrito);
                }
            });
            return ResponseEntity.status(HttpStatus.OK).body(carrito);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Carrito());
        }
    }

    public ResponseEntity<Carrito> eliminarProducto(final String nickname, final String productoId) {
        Carrito carrito = this.carritoRepository.findByNickname(nickname).orElse(null);

        if (carrito != null) {

            carrito.actualizarEstado();

            boolean productoExists = productoExistsInCarrito(carrito, productoId);

            if (productoExists) {
                carrito.getProductosActual().removeIf(p -> p.getProductoId()== Integer.valueOf(productoId));
                this.carritoRepository.save(carrito);
                return ResponseEntity.status(HttpStatus.OK).body(carrito);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Carrito());
    }

    public ResponseEntity<String> eliminarCarrito(final String nickname) {
        Carrito carrito = this.carritoRepository.findByNickname(nickname).orElse(null);

        if (carrito != null) {
            this.carritoRepository.delete(carrito);
            return ResponseEntity.status(HttpStatus.OK).body("Carrito borrado con exito");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carrito no encontrado");

    }

    public boolean productoExistsInCarrito(final Carrito carrito, final String productoId) {
        return carrito.getProductosActual().stream().anyMatch(p -> p.getProductoId() == Integer.valueOf(productoId));
    }
}
