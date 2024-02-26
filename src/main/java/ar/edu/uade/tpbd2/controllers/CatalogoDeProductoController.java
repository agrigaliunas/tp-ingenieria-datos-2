package ar.edu.uade.tpbd2.controllers;

import ar.edu.uade.tpbd2.persistence.model.CatalogoDeProducto;
import ar.edu.uade.tpbd2.services.CatalogoDeProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("catalogo_producto")
public class CatalogoDeProductoController {

    @Autowired
    public CatalogoDeProductosService catalogoDeProductosService;

    @GetMapping("/{productoID}")
    public ResponseEntity<CatalogoDeProducto> obtenerPorNickname(@PathVariable("productoID") final String productoID) {
        return this.catalogoDeProductosService.obtenerCatalogoDeProductoPorID(productoID);
    }

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
