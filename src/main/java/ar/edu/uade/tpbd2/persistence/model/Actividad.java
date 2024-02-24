package ar.edu.uade.tpbd2.persistence.model;

import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

public class Actividad {


    @Field("campo_actualizado")
    private String campoActualizado;

    @Field("valor_anterior")
    private String valorAnterior;

    @Field("valor_actual")
    private String valorActual;

    @Field("fecha_de_actividad")
    private LocalDateTime fechaDeActividad;

    @Field("comentario")
    private String comentario;

    public String getCampoActualizado() {
        return this.campoActualizado;
    }

    public void setCampoActualizado(final String campoActualizado) {
        this.campoActualizado = campoActualizado;
    }

    public String getValorAnterior() {
        return this.valorAnterior;
    }

    public void setValorAnterior(final String valorAnterior) {
        this.valorAnterior = valorAnterior;
    }

    public String getValorActual() {
        return this.valorActual;
    }

    public void setValorActual(final String valorActual) {
        this.valorActual = valorActual;
    }

    public LocalDateTime getFechaDeActividad() {
        return this.fechaDeActividad;
    }

    public void setFechaDeActividad(final LocalDateTime fechaDeActividad) {
        this.fechaDeActividad = fechaDeActividad;
    }

    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(final String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "campoActualizado='" + campoActualizado + '\'' +
                ", valorAnterior='" + valorAnterior + '\'' +
                ", valorActual='" + valorActual + '\'' +
                ", fechaDeActividad=" + fechaDeActividad +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
