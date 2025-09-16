///
/// @author Gabriel Araújo Lima, RM 231125
/// @author Andrey Nardy, RM 231126
///

package br.com.etechas.tarefas.controllers;

import br.com.etechas.tarefas.entities.Tarefa;
import br.com.etechas.tarefas.services.TarefasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tarefas")
public class TarefasController {
    private TarefasService service;

    public TarefasController(TarefasService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTodos() {
        var listaTarefas = service.listarTarefas();
        return ResponseEntity
                .status(200)
                .body(listaTarefas);
    }

    @PostMapping
    public ResponseEntity<?> criarNova(@RequestBody Tarefa tarefa) {
        return service.criarNova(tarefa);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        return service.excluirPorId(id);
    }
}
