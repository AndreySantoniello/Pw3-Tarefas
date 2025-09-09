///
/// @author Gabriel Araújo Lima, RM 231125
/// @author Andrey Nardy, RM 231126
///

package br.com.etechas.tarefas.services;

import br.com.etechas.tarefas.entities.Tarefa;
import br.com.etechas.tarefas.enums.TarefaStatusEnum;
import br.com.etechas.tarefas.repository.TarefaRepository;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<?> excluirPorId(Long id) {
        var tarefaOptional = repository.findById(id);

        if (tarefaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var tarefa = tarefaOptional.get();

        if (tarefa.getStatus() != TarefaStatusEnum.PENDENTE) {
            throw new RuntimeException("Tarefa não é pendente");
        }

        repository.delete(tarefa);

        return ResponseEntity.noContent().build();
    }
}
