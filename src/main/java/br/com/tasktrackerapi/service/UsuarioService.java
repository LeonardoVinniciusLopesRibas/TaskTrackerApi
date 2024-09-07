// UsuarioService.java

package br.com.tasktrackerapi.service;

import br.com.tasktrackerapi.dto.UsuarioRequest;
import br.com.tasktrackerapi.model.Usuario;
import br.com.tasktrackerapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String novoUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
        return "Usuário criado com sucesso!";
    }

    public Usuario getUsuario(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public List<Usuario> getListUsuario() {
        return usuarioRepository.findAll();
    }

    public Usuario logar(UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioRepository.findByEmailAndSenha(usuarioRequest.getUsuario(), usuarioRequest.getSenha());
        if (usuario == null) {
            throw new RuntimeException("Usuário ou senha incorretos");
        }
        return usuario;
    }

    public String delete(Long id) {
        usuarioRepository.deleteById(id);
        return "Deletado com sucesso";
    }
}
