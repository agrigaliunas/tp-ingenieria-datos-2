package ar.edu.uade.tpbd2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.uade.tpbd2.persistence.model.Usuario;
import ar.edu.uade.tpbd2.services.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    public UsuarioService usuarioService;

    @GetMapping("/{nickname}")
    public ResponseEntity<Usuario> obtenerPorNickname(@PathVariable("nickname") final String nickname) {
        return this.usuarioService.obtenerPorNickname(nickname);
    }

    @PostMapping("")
    public Usuario guardarUsuarioPorNickname(@RequestBody final Usuario request) {
        return this.usuarioService.guardarUsuarioPorNickname(request);
    }

    @PutMapping("")
    public Usuario actualizarUsuarioPorNickname(@RequestBody final Usuario request) {
        return this.usuarioService.guardarUsuarioPorNickname(request);
    }

    @DeleteMapping("/{nickname}")
    public void eliminarUsuarioPorNickname(@PathVariable("nickname") final String nickname) {
        this.usuarioService.eliminarUsuarioPorNickname(nickname);
    }

}
