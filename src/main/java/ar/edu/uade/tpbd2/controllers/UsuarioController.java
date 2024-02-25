package ar.edu.uade.tpbd2.controllers;

import ar.edu.uade.tpbd2.persistence.model.Carrito;
import ar.edu.uade.tpbd2.persistence.model.Usuario;
import ar.edu.uade.tpbd2.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    public UsuarioService usuarioService;

    @GetMapping("/{nickname}")
    public Usuario obtenerPorNickname(@PathVariable("nickname") final String nickname) {
        return this.usuarioService.obtenerUsuarioPorNickname(nickname);
    }

    @PostMapping("")
    public Usuario guardarUsuarioPorNickname(@RequestBody final Usuario request) {
        return this.usuarioService.guardarUsuarioPorNickname(request.getNickname(), request);
    }

    @PutMapping("")
    public Usuario actualizarUsuarioPorNickname(@RequestBody final Usuario request) {
        return this.usuarioService.guardarUsuarioPorNickname(request.getNickname(), request);
    }

    @DeleteMapping("/{nickname}")
    public void eliminarUsuarioPorNickname(@PathVariable("nickname") final String nickname) {
        this.usuarioService.eliminarUsuarioPorNickname(nickname);
    }

}
