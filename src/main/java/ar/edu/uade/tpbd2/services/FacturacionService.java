package ar.edu.uade.tpbd2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ar.edu.uade.tpbd2.persistence.model.sql.Venta;
import ar.edu.uade.tpbd2.repositories.FacturacionRepository;

@Service
public class FacturacionService {

    @Autowired
    private FacturacionRepository facturacionRepository;

    public List<Venta> getAllVentas() {
        return this.facturacionRepository.findAllWithDetalleFact();
    }

    public List<Venta> getVentasByNickname(final String nickname) {
        return this.facturacionRepository.findAllByNickname(nickname);
    }

    public Venta createVenta(final Venta venta) {
        return this.facturacionRepository.save(venta);
    }

    public ResponseEntity<String> borrarVenta(final String ventaId) {

        Venta ventaFetch = this.facturacionRepository.findById(Long.valueOf(ventaId))
                .orElse(null);

        if (ventaFetch != null) {
            this.facturacionRepository.delete(ventaFetch);
            return ResponseEntity.status(HttpStatus.OK).body("Venta borrada con exito");

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Venta no encontrada");

    }
}
