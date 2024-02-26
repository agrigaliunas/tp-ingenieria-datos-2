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

import ar.edu.uade.tpbd2.persistence.model.mongo.CatalogoDeProducto;
import ar.edu.uade.tpbd2.services.CatalogoDeProductosService;

@RestController
@RequestMapping("catalogo_producto")
public class CatalogoDeProductoController {

    @Autowired
    public CatalogoDeProductosService catalogoDeProductosService;

    @GetMapping("/{productoID}")
    public ResponseEntity<CatalogoDeProducto> obtenerPorId(@PathVariable("productoID") final String productoID) {
        return this.catalogoDeProductosService.obtenerCatalogoDeProductoPorID(productoID);
    }

    /*
     * TODO:
     * pasar a sql si se crea o actualiza producto
     */

    @PostMapping("")
    public ResponseEntity<CatalogoDeProducto> crearProducto(@RequestBody final CatalogoDeProducto request) {
        return this.catalogoDeProductosService.crearCatalogoProductoProducto(request);
    }

    @PutMapping("/{productoID}")
    public ResponseEntity<CatalogoDeProducto> actualizarProducto(@PathVariable("productoID") final String productoID, @RequestBody final CatalogoDeProducto request) {
        return this.catalogoDeProductosService.actualizarCatalogoDeProducto(productoID, request);
    }

    @DeleteMapping("/{productoID}")
    public ResponseEntity<Void> actualizarProducto(@PathVariable("productoID") final String productoID) {
        return this.catalogoDeProductosService.borrarCatalogoDeProducto(productoID);
    }
}
