package ar.edu.uade.tpbd2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.uade.tpbd2.persistence.model.mongo.Carrito;
import ar.edu.uade.tpbd2.persistence.model.mongo.Pedido;
import ar.edu.uade.tpbd2.persistence.model.mongo.Producto;
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
    public ResponseEntity<Carrito> crearCarritoEntero(@RequestBody final Carrito request) {
        return this.carritoService.crearCarrito(request);
    }

    @PostMapping("/agregar/{nickname}")
    public ResponseEntity<Carrito> agregarProducto(@PathVariable("nickname") final String nickname, @RequestBody final Producto producto) {
        return this.carritoService.agregarProducto(nickname, producto);
    }

    @PutMapping("/actualizar/{nickname}")
    public ResponseEntity<Carrito> actualizarProducto(@PathVariable("nickname") final String nickname, @RequestBody final Producto producto) {
        return this.carritoService.actualizarProducto(nickname, producto);
    }

    @PutMapping("/borrar/{nickname}/{productoId}")
    public ResponseEntity<Carrito> eliminarProducto(@PathVariable("nickname") final String nickname, @PathVariable("productoId") final String productoId) {
        return this.carritoService.eliminarProducto(nickname, productoId);
    }

    @DeleteMapping("borrar/{nickname}")
    public ResponseEntity<String> eliminarCarrito(@PathVariable("nickname") final String nickname) {
        return this.carritoService.eliminarCarrito(nickname);
    }

    /*
     * Cuando se apreta en confirmar carrito del lado frontend,
     * se envia una request de Pedido con los detalles del carrito y el usuario almacenado en la sesion.
     *
     */

    // IDEA: cuando se confirma, actualizar sql de actividad usuario y en base a eso calcular actividad.
    @PostMapping("/confirmarCarrito")
    public ResponseEntity<Pedido> confirmarCarrito(@RequestBody final Pedido request) {
        return this.carritoService.confirmarCarritoYCrearPedido(request);
    }

}
