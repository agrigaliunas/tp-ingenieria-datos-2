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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_compra")
    private Integer id;

    @Column(name = "Fecha_fact")
    @CreationTimestamp
    private Date fechaFacturacion;


    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<DetalleCompra> detalleCompras;

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

    public List<DetalleCompra> getDetalleCompras() {
        return this.detalleCompras;
    }

    public void setDetalleCompras(final List<DetalleCompra> detalleCompras) {
        this.detalleCompras = detalleCompras;
    }

}
