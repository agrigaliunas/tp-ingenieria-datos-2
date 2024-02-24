package ar.edu.uade.tpbd2.controllers;

import ar.edu.uade.tpbd2.persistence.model.Carrito;
import ar.edu.uade.tpbd2.persistence.model.CatalogoDeProductos;
import ar.edu.uade.tpbd2.services.CatalogoDeProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("catalogo_producto")
public class CatalogoDeProductoController {

    @Autowired
    public CatalogoDeProductosService catalogoDeProductosService;

    @GetMapping("/{producto_id}")
    public ResponseEntity<Carrito> obtenerPorNickname(@PathVariable("producto_id") final Integer productoID) {
        return this.catalogoDeProductosService.obtenerProductoPorID(productoID);
    }

    @PostMapping("/")
    public CatalogoDeProductos crearProducto(@RequestBody final CatalogoDeProductos request) {
        return this.catalogoDeProductosService.crearProducto(request);
    }
}
