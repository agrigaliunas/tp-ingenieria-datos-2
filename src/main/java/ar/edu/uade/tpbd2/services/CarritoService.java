package ar.edu.uade.tpbd2.services;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mongodb.client.MongoCollection;

import ar.edu.uade.tpbd2.dao.MongoDB;

@Service
public class CarritoService {

    private static final String COLLECTION_CARRITO = "carrito";

    @Autowired
    private MongoDB mongoDB;

    public ResponseEntity<String> obtenerCarrito(final String UsuarioID) {

        MongoCollection<Document> collection = this.mongoDB.getCollection(COLLECTION_CARRITO);

        Document doc = collection.find(eq("nickname", UsuarioID)).first();
        if (doc != null) {
            return ResponseEntity.status(HttpStatus.OK).body(doc.toJson());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró carrito");
        }
    }

}
