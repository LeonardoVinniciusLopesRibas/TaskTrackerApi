package br.com.tasktrackerapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tarefas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Descrição da tarefa é obrigatória")
    private String descricao;

    @Column(nullable = false)
    @NotNull(message = "Data de início é obrigatória")
    private LocalDate dataInicio;

    @Column(nullable = false)
    @NotNull(message = "Data de fim é obrigatória")
    private LocalDate dataFim;

    private boolean concluida;

    @ManyToOne
    @JoinColumn(name = "usuarioId", nullable = false)
    private Usuario usuario;

}
