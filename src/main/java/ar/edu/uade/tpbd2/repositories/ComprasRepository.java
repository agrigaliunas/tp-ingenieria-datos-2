package ar.edu.uade.tpbd2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.uade.tpbd2.persistence.model.sql.Compra;

public interface ComprasRepository extends JpaRepository<Compra, Long>{

    @Query("SELECT c FROM Compra c LEFT JOIN FETCH c.detalleCompras")
    List<Compra> findAllWithDetallesCompras();

}
