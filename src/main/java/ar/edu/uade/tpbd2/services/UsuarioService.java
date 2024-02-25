package ar.edu.uade.tpbd2.services;

import ar.edu.uade.tpbd2.persistence.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private RedisTemplate<String, Usuario> redisTemplate;

    public Usuario guardarUsuarioPorNickname(String nickname, Usuario usuario) {
        redisTemplate.opsForValue().set(nickname, usuario);
        return usuario;
    }

    public Usuario obtenerUsuarioPorNickname(String nickname) {
        return redisTemplate.opsForValue().get(nickname);
    }

    public void eliminarUsuarioPorNickname(String nickname) {
        redisTemplate.delete(nickname);
    }
}
