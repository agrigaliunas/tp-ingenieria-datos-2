package ar.edu.uade.tpbd2.controllers;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@RestController
@RequestMapping("api/v1/cart")
public class CarritoController {


    @PostMapping("/create")
    public ResponseEntity<String> create() {

        String uri = "mongodb+srv://tp-ingenieria-datos-2:ingenieriadatos2@cluster-0.toirr2f.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("BD2");
            MongoCollection<Document> collection = database.getCollection("carrito");
            Document doc = collection.find(eq("carrito-id", 12345)).first();
            if (doc != null) {
                return ResponseEntity.ok(doc.toJson());
            } else {
                return ResponseEntity.ok("fail");
            }
        }

    }


}
