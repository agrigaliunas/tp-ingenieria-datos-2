package ar.edu.uade.tpbd2.persistence.model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Facturacion")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_facturacion")
    private Integer id;

    @Column(name = "Fecha_fact")
    @CreationTimestamp
    private Date fechaFacturacion;

    @Column(name = "ID_cliente")
    private String idCliente;

    @OneToMany(mappedBy = "facturacion", cascade = CascadeType.ALL)
    private List<DetalleFacturacion> detallesFacturacion;

    public List<DetalleFacturacion> getDetallesFacturacion() {
        return this.detallesFacturacion;
    }

    public void setDetallesFacturacion(final List<DetalleFacturacion> detallesFacturacion) {
        this.detallesFacturacion = detallesFacturacion;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getIdCliente() {
        return this.idCliente;
    }

    public Date getFechaFacturacion() {
        return this.fechaFacturacion;
    }

    public void setFechaFacturacion(final Date fechaFacturacion) {
        this.fechaFacturacion = fechaFacturacion;
    }

    public void setIdCliente(final String idCliente) {
        this.idCliente = idCliente;
    }

}
