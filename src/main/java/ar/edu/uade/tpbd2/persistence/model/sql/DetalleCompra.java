package ar.edu.uade.tpbd2.persistence.model.sql;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Det_compras")
public class DetalleCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_det_compra")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_compra", nullable = false)
    @JsonBackReference
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "productoID")
    private CatalogoProducto producto;

    private int cantidad;

    @Column(name = "Precio_unit")
    private float precioUnitario;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Compra getCompra() {
        return this.compra;
    }

    public void setCompra(final Compra compra) {
        this.compra = compra;
    }

    public CatalogoProducto getProducto() {
        return this.producto;
    }

    public void setProducto(final CatalogoProducto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(final int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioUnitario() {
        return this.precioUnitario;
    }

    public void setPrecioUnitario(final float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }


}
