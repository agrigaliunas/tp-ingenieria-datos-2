package ar.edu.uade.tpbd2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.uade.tpbd2.persistence.model.Venta;

@Repository
public interface FacturacionRepository extends JpaRepository<Venta, Long> {

}
