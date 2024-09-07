package br.com.tasktrackerapi.controller;

import br.com.tasktrackerapi.dto.HabitosRequest;
import br.com.tasktrackerapi.model.Habitos;
import br.com.tasktrackerapi.model.Tarefas;
import br.com.tasktrackerapi.service.HabitosService;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitos")
@CrossOrigin("*")
public class HabitosController {

    @Autowired
    private HabitosService habitosService;

    @PostMapping("/nova")
    public ResponseEntity<String> novaTarefa(@RequestBody @Valid HabitosRequest habitosRequest) {
        String retorno = habitosService.novaTarefa(habitosRequest);
        return ResponseEntity.ok(retorno);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Habitos>> get(){
        return ResponseEntity.ok(habitosService.get());
    }
}
