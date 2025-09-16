///
/// @author Gabriel Araújo Lima, RM 231125
/// @author Andrey Nardy, RM 231126
///

package br.com.etechas.tarefas.services;

import br.com.etechas.tarefas.entities.Tarefa;
import br.com.etechas.tarefas.enums.TarefaStatusEnum;
import br.com.etechas.tarefas.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {
    private final TarefaRepository repository;

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

    public ResponseEntity<?> criarNova(Tarefa tarefa) {
        tarefa.setStatus(TarefaStatusEnum.PENDENTE);

        if (tarefa.getData().isBefore(LocalDate.now())) {
            throw new RuntimeException("Data invalida");
        }

        repository.save(tarefa);

        return ResponseEntity.noContent().build();
    }
}
