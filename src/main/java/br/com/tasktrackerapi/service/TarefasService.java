// TarefasService.java

package br.com.tasktrackerapi.service;

import br.com.tasktrackerapi.dto.TarefasRequest;
import br.com.tasktrackerapi.model.Tarefas;
import br.com.tasktrackerapi.model.Usuario;
import br.com.tasktrackerapi.repository.TarefasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefasService {

    @Autowired
    private TarefasRepository tarefaRepository;

    @Autowired
    private UsuarioService usuarioService;

    public String novaTarefa(TarefasRequest tarefasRequest) {
        tarefasRequest.setConcluida(false);
        Usuario usuario = usuarioService.getUsuario(tarefasRequest.getUsuarioId());

        Tarefas tarefas = new Tarefas();
        tarefas.setDescricao(tarefasRequest.getDescricao());
        tarefas.setDataInicio(tarefasRequest.getDataInicio());
        tarefas.setDataFim(tarefasRequest.getDataFim());
        tarefas.setConcluida(false);
        tarefas.setUsuario(usuario);

        tarefaRepository.save(tarefas);
        return "Tarefa criada com sucesso!";
    }

    public String updateTarefaConcluida(Long id, boolean concluida) {
        Optional<Tarefas> tarefaOptional = tarefaRepository.findById(id);
        if (tarefaOptional.isPresent()) {
            Tarefas tarefas = tarefaOptional.get();
            tarefas.setConcluida(concluida);
            tarefaRepository.save(tarefas);
            return "Tarefa atualizada com sucesso!";
        } else {
            return "Tarefa não encontrada.";
        }
    }

    public List<Tarefas> get() {
        return tarefaRepository.findAll();
    }
}
