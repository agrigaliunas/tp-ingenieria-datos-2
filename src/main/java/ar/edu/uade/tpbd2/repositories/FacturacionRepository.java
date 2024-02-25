package ar.edu.uade.tpbd2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.uade.tpbd2.persistence.Venta;

@Repository
public interface FacturacionRepository extends JpaRepository<Venta, Long> {

    @Query(value = "SELECT * FROM dbo.facturacion", nativeQuery = true)
    List<Venta> findAllVentas();
}