package ar.edu.uade.tpbd2.persistence.model.sql;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "nickname")
    private Cliente cliente;

    @OneToMany(mappedBy = "facturacion", cascade = CascadeType.ALL)
    @JsonManagedReference
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

    public Cliente getNickname() {
        return this.cliente;
    }

    public Date getFechaFacturacion() {
        return this.fechaFacturacion;
    }

    public void setFechaFacturacion(final Date fechaFacturacion) {
        this.fechaFacturacion = fechaFacturacion;
    }

    public void setNickname(final Cliente cliente) {
        this.cliente = cliente;
    }

}
