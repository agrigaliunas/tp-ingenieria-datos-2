package ar.edu.uade.tpbd2.dao;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MongoDB {

    @Autowired
    public MongoClient mongoClient;

    public MongoCollection<Document> getCollection(final String collection) {
        return this.mongoClient.getDatabase("BD2").getCollection(collection);
    }
}
