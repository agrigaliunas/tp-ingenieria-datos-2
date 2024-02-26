package ar.edu.uade.tpbd2.persistence.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    public void ActualizarCatalogoDeProducto(CatalogoDeProducto actual) {
        if (this.actividades == null) {
            this.actividades = new ArrayList<>();
        }

        System.out.println("0");
        if (this.productoID != null && !this.productoID.equals(actual.getProductoID())) {
            this.actividades.add(new Actividad("productoID", this.productoID, actual.getProductoID()));
        }
        System.out.println("1");
        if (this.nombre != null && !this.nombre.equals(actual.getNombre())) {
            this.actividades.add(new Actividad("nombre", this.nombre, actual.getNombre()));
        }
        System.out.println("3");
        if (this.marca != null && !this.marca.equals(actual.getMarca())) {
            this.actividades.add(new Actividad("marca", this.marca, actual.getMarca()));
        }
        System.out.println("4");
        if (this.descripcion != null && !this.descripcion.equals(actual.getDescripcion())) {
            this.actividades.add(new Actividad("descripcion", this.descripcion, actual.getDescripcion()));
        }
        System.out.println("5");
        if (this.precio != null && !this.precio.equals(actual.getPrecio())) {
            this.actividades.add(new Actividad("precio", String.valueOf(this.precio), String.valueOf(actual.getPrecio())));
        }
        System.out.println("6");
        if (this.stockActual != null && !this.stockActual.equals(actual.getStockActual())) {
            this.actividades.add(new Actividad("stockActual", String.valueOf(this.stockActual), String.valueOf(actual.getStockActual())));
        }
        System.out.println("7");
        if (this.categoria != null && !this.categoria.equals(actual.getCategoria())) {
            this.actividades.add(new Actividad("categoria", this.categoria, actual.getCategoria()));
        }
    }

    public void unirActividades(CatalogoDeProducto otroProducto) {
        this.actividades.addAll(otroProducto.actividades);
    }

}