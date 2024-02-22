package ar.edu.uade.tpbd2.services;

import ar.edu.uade.tpbd2.dao.MongoDB;
import org.bson.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ar.edu.uade.tpbd2.persistence.model.Producto;

import static com.mongodb.client.model.Filters.eq;

@Service
public class CarritoService {

    public ResponseEntity<String> obtenerCarrito(final String UsuarioID) {

        MongoDB mongoDB = MongoDB.getInstance();

        Document doc = mongoDB.getCarritoCollection().find(eq("nickname", UsuarioID)).first();
        if (doc != null) {
            return ResponseEntity.status(HttpStatus.OK).body(doc.toJson());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró carrito");
        }
    }

    public void agregarProducto(final Producto producto) {

    }

}
