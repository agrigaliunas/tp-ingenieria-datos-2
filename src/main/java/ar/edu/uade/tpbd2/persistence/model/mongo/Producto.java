package ar.edu.uade.tpbd2.persistence.model.mongo;

public class Producto {

    private int productoId;
    private String nombre;
    private int cantidad;
    private double precioUnitario;
    private String descripcion;

    public int getProductoId() {
        return this.productoId;
    }

    public void setProductoId(final int productoId) {
        this.productoId = productoId;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(final int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return this.precioUnitario;
    }

    public void setPrecioUnitario(final double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }
}