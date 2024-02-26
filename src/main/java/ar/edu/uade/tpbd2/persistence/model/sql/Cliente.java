package ar.edu.uade.tpbd2.persistence.model.sql;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class Cliente {

    @Id
    @Column(name = "nickname")
    private String nickname;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "domicilio")
    private String domicilio;

    @Column(name = "categorizacion")
    private String categorizacion;

    @Column(name = "pedidos_realizados")
    private int pedidosRealizados;

    @Column(name = "contrasena")
    private String contrasena;

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(final String nickname) {
        this.nickname = nickname;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(final String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return this.domicilio;
    }

    public void setDomicilio(final String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCategorizacion() {
        return this.categorizacion;
    }

    public void setCategorizacion(final String categorizacion) {
        this.categorizacion = categorizacion;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(final String contrasena) {
        this.contrasena = contrasena;
    }

}
