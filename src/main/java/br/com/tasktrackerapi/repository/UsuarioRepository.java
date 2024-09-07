package br.com.tasktrackerapi.repository;

import br.com.tasktrackerapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmailAndSenha(String usuario, String senha);
}
