package ar.edu.uade.tpbd2.services;

import ar.edu.uade.tpbd2.persistence.model.Usuario;
import ar.edu.uade.tpbd2.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private RedisTemplate<String, Usuario> redisTemplate;
    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario obtenerPorID(String id) {
        return usuarioRepository.findById(id).get();
    }

    public Usuario guardarUsuarioPorNickname(String nickname, Usuario usuario) {
        usuarioRepository.save(usuario);
        return usuario;
    }

    public Usuario obtenerUsuarioPorNickname(String nickname) {

        return usuarioRepository.findByNickname(nickname);
    }

    public void eliminarUsuarioPorNickname(String nickname) {
        redisTemplate.delete(nickname);
    }
}
