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

import ar.edu.uade.tpbd2.persistence.model.sql.Venta;
import ar.edu.uade.tpbd2.services.FacturacionService;

@RestController
@RequestMapping("facturacion")
public class FacturacionController {

    @Autowired
    private FacturacionService facturacionService;

    @GetMapping("")
    public ResponseEntity<List<Venta>> getAll() {
        try {
            List<Venta> ventas = this.facturacionService.getAllVentas();
            return ResponseEntity.status(HttpStatus.OK).body(ventas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/agregar")
    public ResponseEntity<Venta> addVenta(@RequestBody final Venta request) {
        try {
            Venta ventaGuardada = this.facturacionService.createVenta(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(ventaGuardada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/borrar/{ventaId}")
    public ResponseEntity<String> borrarVenta(@PathVariable("ventaId") final String ventaId) {
        return this.facturacionService.borrarVenta(ventaId);
    }

    @GetMapping("/{nickname}")
    public ResponseEntity<List<Venta>> getByNickname(@PathVariable("nickname") final String nickname) {
        try {
            List<Venta> ventas = this.facturacionService.getVentasByNickname(nickname);
            return ResponseEntity.status(HttpStatus.OK).body(ventas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
