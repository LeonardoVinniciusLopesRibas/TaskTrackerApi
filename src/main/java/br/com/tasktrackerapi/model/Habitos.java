package br.com.tasktrackerapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Habitos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "A decrição do hábito é obrigatória")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "usuarioId", nullable = false)
    private Usuario usuario;

}
