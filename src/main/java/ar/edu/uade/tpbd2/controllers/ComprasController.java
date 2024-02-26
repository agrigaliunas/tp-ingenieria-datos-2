package ar.edu.uade.tpbd2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.uade.tpbd2.persistence.model.sql.Compra;
import ar.edu.uade.tpbd2.services.ComprasService;

@RestController
@RequestMapping("compras")
public class ComprasController {

    @Autowired
    private ComprasService comprasService;

    @GetMapping("")
    public ResponseEntity<List<Compra>> getAll() {
        try {
            List<Compra> compras = this.comprasService.getAllCompras();
            return ResponseEntity.status(HttpStatus.OK).body(compras);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/agregar")
    public ResponseEntity<Compra> addCompra(@RequestBody final Compra request) {
        try {

            Compra compraGuardada = this.comprasService.createCompra(request);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/borrar/{compraId}")
    public ResponseEntity<String> borrarCompra(@PathVariable("compraId") final String compraId) {
        return this.comprasService.borrarCompra(compraId);
    }

}
