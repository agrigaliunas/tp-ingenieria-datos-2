package ar.edu.uade.tpbd2.persistence.model.mongo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "carrito")
public class Carrito {

    @Id
    private String id;

    private String nickname;

    private List<Producto> productosActual;

    private List<Producto> productosAnterior;

    public List<Producto> getProductosActual() {
        return this.productosActual;
    }

    public void setProductosActual(final List<Producto> productosActual) {
        this.productosActual = productosActual;
    }

    public List<Producto> getProductosAnterior() {
        return this.productosAnterior;
    }

    public void setProductosAnterior(final List<Producto> productosAnterior) {
        this.productosAnterior = productosAnterior;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(final String nickname) {
        this.nickname = nickname;
    }

    public void addNewProduct(final Producto product) {
        this.productosActual.add(product);
    }

    public void actualizarEstado() {
        List<Producto> copiaProductosActual = new ArrayList<>();

        for (Producto producto : this.productosActual) {
            Producto copiaProducto = new Producto();
            copiaProducto.setProductoId(producto.getProductoId());
            copiaProducto.setNombre(producto.getNombre());
            copiaProducto.setCantidad(producto.getCantidad());
            copiaProducto.setPrecioUnitario(producto.getPrecioUnitario());
            copiaProducto.setDescripcion(producto.getDescripcion());

            copiaProductosActual.add(copiaProducto);
        }

        // Asignar la copia profunda a la lista productosAnterior
        this.productosAnterior = copiaProductosActual;
    }

    public void deleteProduct(final Producto product) {
    	this.productosActual.remove(product);
    }
}