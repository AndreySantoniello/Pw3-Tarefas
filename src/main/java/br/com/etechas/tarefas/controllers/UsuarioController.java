package br.com.etechas.tarefas.controllers;

import br.com.etechas.tarefas.entities.Usuario;
import br.com.etechas.tarefas.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Usuario> registrar(
            @RequestBody Usuario usuario
    ) {
        return ResponseEntity
                .ok(service.registrar(usuario));
    }
}
