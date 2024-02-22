package ar.edu.uade.tpbd2.dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.mongodb.client.model.Filters.eq;

public class MongoDB {
    private static MongoDB instance;

    private final MongoCollection<Document> carritoCollection;

    private MongoDB() {
        String uri = "mongodb+srv://tp-ingenieria-datos-2:ingenieriadatos2@cluster-0.toirr2f.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("BD2");
            MongoCollection<Document> collection = database.getCollection("carrito");
            carritoCollection = collection;
        }
    }

    public static synchronized MongoDB getInstance() {
        if (instance == null) {
            instance = new MongoDB();
        }
        return instance;
    }

    public MongoCollection<Document> getCarritoCollection() {
        return carritoCollection;
    }
}
