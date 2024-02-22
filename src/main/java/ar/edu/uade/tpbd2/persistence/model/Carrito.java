package ar.edu.uade.tpbd2.persistence.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "carrito")
public class Carrito {

    @Id
    private String id;

    private String nickname;

    @Field(value = "estado_actual")
    private EstadoActual estadoActual;

    @Field(value = "estado_anterior")
    private EstadoAnterior estadoAnterior;

    public String getId() {
        return this.id;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(final String nickname) {
        this.nickname = nickname;
    }

    public EstadoActual getEstadoActual() {
        return this.estadoActual;
    }

    public void setEstadoActual(final EstadoActual estadoActual) {
        this.estadoActual = estadoActual;
    }

    public EstadoAnterior getEstadoAnterior() {
        return this.estadoAnterior;
    }

    public void setEstadoAnterior(final EstadoAnterior estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }
}