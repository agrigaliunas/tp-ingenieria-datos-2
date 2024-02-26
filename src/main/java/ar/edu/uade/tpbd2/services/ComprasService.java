package ar.edu.uade.tpbd2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ar.edu.uade.tpbd2.persistence.model.sql.Compra;
import ar.edu.uade.tpbd2.repositories.ComprasRepository;

@Service
public class ComprasService {

    @Autowired
    private ComprasRepository comprasRepository;

    public Compra createCompra(final Compra request) {
        return this.comprasRepository.save(request);
    }

    public ResponseEntity<String> borrarCompra(final String compraId) {
        Compra compraFetch = this.comprasRepository.findById(Long.valueOf(compraId))
                .orElse(null);

        if (compraFetch != null) {
            this.comprasRepository.delete(compraFetch);
            return ResponseEntity.status(HttpStatus.OK).body("Compra borrada con exito");

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compra no encontrada");
    }

    public List<Compra> getAllCompras() {
        return this.comprasRepository.findAllWithDetallesCompras();
    }

}
