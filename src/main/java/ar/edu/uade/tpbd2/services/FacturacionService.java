package ar.edu.uade.tpbd2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.uade.tpbd2.persistence.model.sql.Venta;
import ar.edu.uade.tpbd2.repositories.FacturacionRepository;

@Service
public class FacturacionService {

    @Autowired
    private FacturacionRepository facturacionRepository;

    public List<Venta> getAllVentas() {
        return this.facturacionRepository.findAllWithDetalleFactAndCliente();
    }

    public Venta createVenta(final Venta venta) {
        return this.facturacionRepository.save(venta);
    }
}
