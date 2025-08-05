package br.com.etechas.tarefas.controllers;

import br.com.etechas.tarefas.entities.Tarefa;
import br.com.etechas.tarefas.services.TarefasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TarefasController {
    private TarefasService service;

    public TarefasController(TarefasService service) {
        this.service = service;
    }

    public ResponseEntity<List<Tarefa>> listarTodos() {
        var listaTarefas = service.listarTarefas();
        return ResponseEntity
                .status(200)
                .body(listaTarefas);
    }
}
