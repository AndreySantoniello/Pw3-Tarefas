package br.com.etechas.tarefas.services;

import br.com.etechas.tarefas.entities.Tarefa;
import br.com.etechas.tarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefasService {
    private TarefaRepository repository;

    public TarefasService(TarefaRepository repository) {
        this.repository = repository;
    }

    public List<Tarefa> listarTarefas() {
        return repository.findAll();
    }
}
