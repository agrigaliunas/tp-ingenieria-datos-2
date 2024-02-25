package ar.edu.uade.tpbd2.persistence;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Facturacion")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_facturacion")
    private Long id;

    @Column(name = "Fecha_fact")
    private Date fechaFacturacion;

    @Column(name = "ID_cliente")
    private int idCliente;



}
