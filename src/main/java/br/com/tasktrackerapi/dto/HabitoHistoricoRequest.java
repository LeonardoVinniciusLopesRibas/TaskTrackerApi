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
public class HabitoHistoricoRequest {

    private LocalDate data;
    private Long usuarioId;
}
