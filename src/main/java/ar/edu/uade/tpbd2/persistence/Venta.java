package ar.edu.uade.tpbd2.persistence;

import java.util.Date;

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
    private Integer id;

    @Column(name = "Fecha_fact")
    private Date fechaFacturacion;

    @Column(name = "ID_cliente")
    private String idCliente;

    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Date getFechaFacturacion() {
        return this.fechaFacturacion;
    }

    public void setFechaFacturacion(final Date fechaFacturacion) {
        this.fechaFacturacion = fechaFacturacion;
    }

    public String getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(final String idCliente) {
        this.idCliente = idCliente;
    }

}
