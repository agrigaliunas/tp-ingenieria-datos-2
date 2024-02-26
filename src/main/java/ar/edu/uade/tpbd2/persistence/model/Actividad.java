package ar.edu.uade.tpbd2.persistence.model;

import java.time.LocalDateTime;

public class Actividad {

    private String campoActualizado;

    private String valorAnterior;

    private String valorActual;

    private LocalDateTime fechaDeActividad;

    public Actividad(String campoActualizado, String valorActual, String valorAnterior) {
        this.campoActualizado = campoActualizado;
        this.valorAnterior = valorAnterior;
        this.valorActual = valorActual;
        this.fechaDeActividad = LocalDateTime.now();
    }

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

    @Override
    public String toString() {
        return "Actividad{" +
                "campoActualizado='" + campoActualizado + '\'' +
                ", valorAnterior='" + valorAnterior + '\'' +
                ", valorActual='" + valorActual + '\'' +
                ", fechaDeActividad=" + fechaDeActividad +
                '}';
    }
}
