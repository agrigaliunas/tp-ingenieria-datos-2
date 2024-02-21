package ar.edu.uade.tpbd2.persistence.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "carrito")
public class Carrito {

    @Id
    private String id;

    private String usuarioId;

    private EstadoActual estadoActual;

    private EstadoAnterior estadoAnterior;

    public String getId() {
        return this.id;
    }

    public String getUsuarioId() {
        return this.usuarioId;
    }

    public void setUsuarioId(final String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Estado getEstadoActual() {
        return this.estadoActual;
    }

    public void setEstadoActual(final EstadoActual estadoActual) {
        this.estadoActual = estadoActual;
    }

    public Estado getEstadoAnterior() {
        return this.estadoAnterior;
    }

    public void setEstadoAnterior(final EstadoAnterior estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }
}