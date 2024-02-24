package ar.edu.uade.tpbd2.persistence.model;

import java.util.Date;

public class Actividad {
    private String campoActualizado;
    private String valorAnterior;
    private String valorActual;
    private Date fechaDeActividad;
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

    public Date getFechaDeActividad() {
        return this.fechaDeActividad;
    }

    public void setFechaDeActividad(final Date fechaDeActividad) {
        this.fechaDeActividad = fechaDeActividad;
    }

    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(final String comentario) {
        this.comentario = comentario;
    }

}
