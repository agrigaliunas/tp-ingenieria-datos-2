package ar.edu.uade.tpbd2.repositories;

import ar.edu.uade.tpbd2.persistence.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {

    public Usuario findByNickname(String nickname);
}