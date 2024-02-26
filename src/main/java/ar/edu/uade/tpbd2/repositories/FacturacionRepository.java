package ar.edu.uade.tpbd2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.uade.tpbd2.persistence.model.sql.Venta;

@Repository
public interface FacturacionRepository extends JpaRepository<Venta, Long> {

    @Query("SELECT v FROM Venta v LEFT JOIN FETCH v.detallesFacturacion LEFT JOIN FETCH v.cliente")
    List<Venta> findAllWithDetalleFactAndCliente();

}
