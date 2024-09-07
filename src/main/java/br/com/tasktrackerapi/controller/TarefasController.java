package br.com.tasktrackerapi.controller;

import br.com.tasktrackerapi.dto.TarefasRequest;
import br.com.tasktrackerapi.model.Tarefas;
import br.com.tasktrackerapi.service.TarefasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
@CrossOrigin("*")
public class TarefasController {

    @Autowired
    private TarefasService tarefasService;

    @PostMapping("/nova")
    public ResponseEntity<String> novaTarefa(@RequestBody @Valid TarefasRequest tarefasRequest) {
        String retorno = tarefasService.novaTarefa(tarefasRequest);
        return ResponseEntity.ok(retorno);
    }

    @PutMapping("/concluida/{id}")
    public ResponseEntity<String> updateTarefaConcluida(@PathVariable Long id, @RequestParam boolean concluida) {
        String retorno = tarefasService.updateTarefaConcluida(id, concluida);
        return ResponseEntity.ok(retorno);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Tarefas>> get(){
        return ResponseEntity.ok(tarefasService.get());
    }
}
