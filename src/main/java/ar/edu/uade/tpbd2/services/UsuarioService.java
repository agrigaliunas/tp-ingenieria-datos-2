package ar.edu.uade.tpbd2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ar.edu.uade.tpbd2.persistence.model.redis.Usuario;
import ar.edu.uade.tpbd2.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private RedisTemplate<String, Usuario> redisTemplate;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<Usuario> obtenerPorID(final String id) {
        Usuario fetchUsuario = this.usuarioRepository.findById(id)
                .orElse(null);
        if (fetchUsuario != null) {
            return ResponseEntity.status(HttpStatus.OK).body(fetchUsuario);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(fetchUsuario);
        }
    }

    public Usuario guardarUsuarioPorNickname(final Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public ResponseEntity<Usuario> obtenerPorNickname(final String nickname) {
        Usuario fetchUsuario = this.usuarioRepository.findByNickname(nickname)
                .orElse(null);

        if (fetchUsuario != null) {
            return ResponseEntity.status(HttpStatus.OK).body(fetchUsuario);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(fetchUsuario);
        }
    }

    public void eliminarUsuarioPorNickname(final String nickname) {
        this.redisTemplate.delete(nickname);
    }
}