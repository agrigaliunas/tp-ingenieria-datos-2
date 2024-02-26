package ar.edu.uade.tpbd2.persistence.model.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection = "pedido")
public class Pedido {

    @Id
    private String id;

    private Carrito carrito;

    private String nombreUsuario;

    private String apellidoUsuario;

    private String email;

    private String domicilio;

    private String telefono;

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public Carrito getCarrito() {
        return this.carrito;
    }

    public void setCarrito(final Carrito carrito) {
        this.carrito = carrito;
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    public void setNombreUsuario(final String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return this.apellidoUsuario;
    }

    public void setApellidoUsuario(final String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getDomicilio() {
        return this.domicilio;
    }

    public void setDomicilio(final String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(final String telefono) {
        this.telefono = telefono;
    }


}
