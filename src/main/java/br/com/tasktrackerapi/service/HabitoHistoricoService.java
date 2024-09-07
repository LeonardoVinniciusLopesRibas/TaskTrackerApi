package br.com.tasktrackerapi.service;

import br.com.tasktrackerapi.dto.HabitoHistoricoRequest;
import br.com.tasktrackerapi.model.HabitoHistorico;
import br.com.tasktrackerapi.model.Usuario;
import br.com.tasktrackerapi.repository.HabitoHistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabitoHistoricoService {

    @Autowired
    private HabitoHistoricoRepository habitoHistoricoRepository;

    @Autowired
    private UsuarioService usuarioService;


    public String novo(HabitoHistoricoRequest habitoHistoricoRequest) {

        Usuario usuario = usuarioService.getUsuario(habitoHistoricoRequest.getUsuarioId());

        HabitoHistorico habitoHistorico = new HabitoHistorico();
        habitoHistorico.setData(habitoHistoricoRequest.getData());
        habitoHistorico.setUsuarioId(usuario);

        habitoHistoricoRepository.save(habitoHistorico);
        return "Hábito cadastrado com sucesso";

    }
}
