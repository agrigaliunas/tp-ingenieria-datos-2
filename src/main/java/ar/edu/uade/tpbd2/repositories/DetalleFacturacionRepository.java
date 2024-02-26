package ar.edu.uade.tpbd2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.uade.tpbd2.persistence.model.DetalleFacturacion;

public interface DetalleFacturacionRepository extends JpaRepository<DetalleFacturacion, Long>{

}
