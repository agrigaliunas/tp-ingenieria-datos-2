package ar.edu.uade.tpbd2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.uade.tpbd2.persistence.model.Carrito;
import ar.edu.uade.tpbd2.persistence.model.Producto;
import ar.edu.uade.tpbd2.services.CarritoService;

@RestController
@RequestMapping("carrito")
public class CarritoController {

    @Autowired
    public CarritoService carritoService;


    @GetMapping("/{nickname}")
    public ResponseEntity<Carrito> obtenerPorNickname(@PathVariable("nickname") final String nickname) {
        return this.carritoService.obtenerCarritoPorNickname(nickname);
    }

    @PostMapping("/crearCarrito")
    public Carrito crearCarritoEntero(@RequestBody final Carrito request) {
        return this.carritoService.crearCarrito(request);
    }


    @PostMapping("/agregar/{carritoId}")
    public ResponseEntity<Carrito> agregarProducto(@PathVariable final String carritoId, @RequestBody final Producto producto) {
        try {
            return this.carritoService.agregarProducto(carritoId, producto);
        } catch (Exception e) {
            // TODO:
            /*
             * cambiar body del response internal server error
             *
             */
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Carrito());
        }
    }

    // TODO:
    /*
     * POST
     * Agregar producto
     *
     * PUT
     * Actualizar cantidad producto
     *
     * DELETE
     * Eliminar producto
     *
     * DELETE
     * Vaciar carrito
     */


}
