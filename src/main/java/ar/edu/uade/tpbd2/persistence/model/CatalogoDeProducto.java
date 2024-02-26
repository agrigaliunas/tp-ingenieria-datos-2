package ar.edu.uade.tpbd2.persistence.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public List<Actividad> compararCon(CatalogoDeProducto otroProducto) {
        List<Actividad> diferencias = new ArrayList<>();

        if (this.productoID != null && !this.productoID.equals(otroProducto.getProductoID())) {
            diferencias.add(new Actividad("productoID", this.productoID, otroProducto.getProductoID()));
        }
        if (this.nombre != null && !this.nombre.equals(otroProducto.getNombre())) {
            diferencias.add(new Actividad("nombre", this.nombre, otroProducto.getNombre()));
        }
        if (this.marca != null && !this.marca.equals(otroProducto.getMarca())) {
            diferencias.add(new Actividad("marca", this.marca, otroProducto.getMarca()));
        }
        if (this.descripcion != null && !this.descripcion.equals(otroProducto.getDescripcion())) {
            diferencias.add(new Actividad("descripcion", this.descripcion, otroProducto.getDescripcion()));
        }
        if (this.precio != null && !this.precio.equals(otroProducto.getPrecio())) {
            diferencias.add(new Actividad("precio", String.valueOf(this.precio), String.valueOf(otroProducto.getPrecio())));
        }
        if (this.stockActual != null && !this.stockActual.equals(otroProducto.getStockActual())) {
            diferencias.add(new Actividad("stockActual", String.valueOf(this.stockActual), String.valueOf(otroProducto.getStockActual())));
        }
        if (this.categoria != null && !this.categoria.equals(otroProducto.getCategoria())) {
            diferencias.add(new Actividad("categoria", this.categoria, otroProducto.getCategoria()));
        }
        if (this.ultimaActualizacion != null && !this.ultimaActualizacion.equals(otroProducto.getUltimaActualizacion())) {
            diferencias.add(new Actividad("ultimaActualizacion", this.ultimaActualizacion.toString(), otroProducto.getUltimaActualizacion().toString()));
        }

        System.out.println(diferencias);
        return diferencias;
    }

    public void unirActividades(CatalogoDeProducto otroProducto) {
        this.actividades.addAll(otroProducto.actividades);
    }

}