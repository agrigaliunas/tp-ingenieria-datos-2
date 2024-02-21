package ar.edu.uade.tpbd2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  /*
   * Use the standard Mongo driver API to create a com.mongodb.client.MongoClient instance.
   */
   public @Bean com.mongodb.client.MongoClient mongoClient() {
       return com.mongodb.client.MongoClients.create("mongodb+srv://tp-ingenieria-datos-2:ingenieriadatos2@cluster-0.toirr2f.mongodb.net/?retryWrites=true&w=majority\"");
   }
}