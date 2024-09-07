package br.com.tasktrackerapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarefasRequest {

    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private boolean concluida;
    private Long usuarioId;
}
