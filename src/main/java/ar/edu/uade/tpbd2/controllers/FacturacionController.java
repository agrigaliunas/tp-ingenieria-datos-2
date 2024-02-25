package ar.edu.uade.tpbd2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.uade.tpbd2.persistence.Venta;
import ar.edu.uade.tpbd2.services.FacturacionService;

@RestController
@RequestMapping("facturacion")
public class FacturacionController {

    @Autowired
    private FacturacionService facturacionService;
    
    @GetMapping("")
    public List<Venta> getAll() {
        return this.facturacionService.getAllVentas();
    }

    
    
}
