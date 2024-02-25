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
        System.out.println(productoID);
        return this.catalogoDeProductosService.obtenerProductoPorID(productoID);
    }

    @PostMapping("")
    public CatalogoDeProducto crearProducto(@RequestBody final CatalogoDeProducto request) {
        System.out.println(request);
        return this.catalogoDeProductosService.crearProducto(request);
    }
}
