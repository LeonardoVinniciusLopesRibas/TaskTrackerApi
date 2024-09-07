// UsuarioController.java

package br.com.tasktrackerapi.controller;

import br.com.tasktrackerapi.dto.UsuarioRequest;
import br.com.tasktrackerapi.model.Usuario;
import br.com.tasktrackerapi.service.UsuarioService;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/novo")
    public ResponseEntity<String> novoUsuario(@RequestBody @Valid Usuario usuario) {
        String retorno = usuarioService.novoUsuario(usuario);
        return ResponseEntity.ok(retorno);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.getUsuario(id));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Usuario>> getListUsuario() {
        List<Usuario> usuarios = usuarioService.getListUsuario();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("/validasenha")
    public ResponseEntity<Usuario> logar(@RequestBody UsuarioRequest usuarioRequest) {
        return ResponseEntity.ok(usuarioService.logar(usuarioRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        String retorno = usuarioService.delete(id);
        return ResponseEntity.ok(retorno);
    }
}
