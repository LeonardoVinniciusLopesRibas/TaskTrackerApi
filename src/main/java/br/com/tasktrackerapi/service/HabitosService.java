package br.com.tasktrackerapi.service;

import br.com.tasktrackerapi.dto.HabitosRequest;
import br.com.tasktrackerapi.model.Habitos;
import br.com.tasktrackerapi.model.Tarefas;
import br.com.tasktrackerapi.model.Usuario;
import br.com.tasktrackerapi.repository.HabitosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitosService {

    @Autowired
    private HabitosRepository habitosRepository;

    @Autowired
    private UsuarioService usuarioService;

    public String novaTarefa(HabitosRequest habitosRequest) {
        Usuario usuario = usuarioService.getUsuario(habitosRequest.getUsuarioId());

        Habitos habitos = new Habitos();
        habitos.setDescricao(habitosRequest.getDescricao());
        habitos.setUsuario(usuario);

        habitosRepository.save(habitos);
        return "Tarefa criada com sucesso!";
    }

    public List<Habitos> get() {
        return habitosRepository.findAll();


    }
}
