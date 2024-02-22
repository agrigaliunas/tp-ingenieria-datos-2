package ar.edu.uade.tpbd2.controllers;

import static com.mongodb.client.model.Filters.eq;

import ar.edu.uade.tpbd2.dao.MongoDB;
import ar.edu.uade.tpbd2.services.CarritoService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@RestController
@RequestMapping("carrito")
public class CarritoController {

    @Autowired
    public CarritoService carritoService;


    @GetMapping("/{id}")
    public ResponseEntity<String> obtener(@PathVariable("id") String nickname) {
        return carritoService.obtenerCarrito(nickname);
    }


}
