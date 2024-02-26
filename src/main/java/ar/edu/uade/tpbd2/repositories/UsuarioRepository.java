package ar.edu.uade.tpbd2.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.uade.tpbd2.persistence.model.redis.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {
    Optional<Usuario> findByNickname(String nickname);
}