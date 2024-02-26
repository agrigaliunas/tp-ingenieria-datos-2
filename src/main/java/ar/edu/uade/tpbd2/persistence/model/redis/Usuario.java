package ar.edu.uade.tpbd2.persistence.model.redis;

import org.springframework.data.redis.core.RedisHash;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@RedisHash("Usuario")
public class Usuario {
    @Id
    @GeneratedValue
    private String id;
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private String domicilio;
    private String telefono;

    // Constructor
    public Usuario(final String nickname, final String nombre, final String apellido, final String email, final String contrasena, final String domicilio, final String telefono) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    // Getters and Setters
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(final String contrasena) {
        this.contrasena = contrasena;
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
