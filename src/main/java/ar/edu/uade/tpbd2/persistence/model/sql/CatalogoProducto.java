package ar.edu.uade.tpbd2.persistence.model.sql;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Catalogo_productos")
public class CatalogoProducto {

    @Id
    @Column(name = "productoID")
    private String productoId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "marca")
    private String marca;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "precio")
    private float precio;

    @Column(name = "stock_actual")
    private int stockActual;

    @Column(name = "categoria")
    private String categoria;

    public String getProductoId() {
        return this.productoId;
    }

    public void setProductoId(final String productoId) {
        this.productoId = productoId;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(final String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(final float precio) {
        this.precio = precio;
    }

    public int getStockActual() {
        return this.stockActual;
    }

    public void setStockActual(final int stockActual) {
        this.stockActual = stockActual;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(final String categoria) {
        this.categoria = categoria;
    }

}