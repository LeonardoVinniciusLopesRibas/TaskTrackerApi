package br.com.tasktrackerapi.controller;

import br.com.tasktrackerapi.dto.HabitoHistoricoRequest;
import br.com.tasktrackerapi.dto.HabitosRequest;
import br.com.tasktrackerapi.model.HabitoHistorico;
import br.com.tasktrackerapi.service.HabitoHistoricoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/habitohistorico")
@CrossOrigin("*")
public class HabitoHistoricoController {

    @Autowired
    private HabitoHistoricoService habitoHistoricoService;

    @PostMapping("/nova")
    public ResponseEntity<String> novaHabitoHistorico(@RequestBody @Valid HabitoHistoricoRequest habitoHistoricoRequest) {

        String retorno = habitoHistoricoService.novo(habitoHistoricoRequest);
        return ResponseEntity.ok(retorno);

    }

}
