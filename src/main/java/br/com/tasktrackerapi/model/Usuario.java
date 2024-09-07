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
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Nome é obrigatório")
    private String nome;

    @Column(nullable = false)
    @NotNull(message = "E-mail é obrigatório")
    private String email;

    @Column(nullable = false)
    @NotNull(message = "Senha é obrigatória")
    private String senha;

}
