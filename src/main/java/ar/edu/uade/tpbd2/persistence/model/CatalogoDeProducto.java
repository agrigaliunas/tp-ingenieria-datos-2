package ar.edu.uade.tpbd2.persistence.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "catalogo_de_productos")
public class CatalogoDeProducto {
    @Id
    private String id;
    private String productoID;
    private String nombre;
    private String marca;
    private String descripcion;
    private Float precio;
    private Integer stockActual;
    private String categoria;
    private LocalDateTime ultimaActualizacion;
    private List<Actividad> actividades;

    public List<Actividad> getActividades() {
        return this.actividades;
    }

    public void setActividades(final List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public void agregarActividad(final Actividad actividad) {
        this.actividades.add(actividad);
    }

    public void borrarActividad(final Actividad actividad) {
        this.actividades.remove(actividad);
    }

    public String getProductoID() {
        return this.productoID;
    }

    public void setProductoID(final String productoID) {
        this.productoID = productoID;
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
        return this.marca;
    }

    public void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio() {
        return this.precio;
    }

    public void setPrecio(final Float precio) {
        this.precio = precio;
    }

    public Integer getStockActual() {
        return this.stockActual;
    }

    public void setStockActual(final Integer stockActual) {
        this.stockActual = stockActual;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(final String categoria) {
        this.categoria = categoria;
    }

    public LocalDateTime getUltimaActualizacion() {
        return this.ultimaActualizacion;
    }

    public void setUltimaActualizacion(final LocalDateTime ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    @Override
    public String toString() {
        return "CatalogoDeProducto{" +
                "productoID=" + productoID +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", stockActual=" + stockActual +
                ", categoria='" + categoria + '\'' +
                ", ultimaActualizacion=" + ultimaActualizacion +
                ", actividades=" + actividades +
                '}';
    }
}