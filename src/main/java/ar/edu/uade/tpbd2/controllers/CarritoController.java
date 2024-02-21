package ar.edu.uade.tpbd2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.uade.tpbd2.services.CarritoService;

@RestController
@RequestMapping("carrito")
public class CarritoController {

    @Autowired
    public CarritoService carritoService;


    @GetMapping("/{id}")
    public ResponseEntity<String> obtener(@PathVariable("id") final String nickname) {
        return this.carritoService.obtenerCarrito(nickname);
    }


}
