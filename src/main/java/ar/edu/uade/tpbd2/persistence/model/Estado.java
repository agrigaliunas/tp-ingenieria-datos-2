package ar.edu.uade.tpbd2.persistence.model;

import java.util.List;

abstract class Estado {

    private List<Producto> productos;

    protected Estado(final List<Producto> productos) {
        this.productos = productos;
    }

    public List<Producto> getProductos() {
        return this.productos;
    }

    public void setProductos(final List<Producto> productos) {
        this.productos = productos;
    }


    protected abstract void actualizarEstado();
}
