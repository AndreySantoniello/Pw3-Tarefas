package br.com.etechas.tarefas.services;

import br.com.etechas.tarefas.entities.Usuario;
import br.com.etechas.tarefas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado com username: " + username));
    }

    @Autowired
    private UsuarioRepository repository;


    @Autowired
    private PasswordEncoder passwordEncoder;
    public Usuario registrar(Usuario cadastro) {
        var existe = repository.findByUsername(cadastro.getUsername());
        if (existe.isPresent()) {
            throw new RuntimeException("Nome de usuário já existe");
        }

        var senhaCifrada = passwordEncoder.encode(cadastro.getPassword());
        cadastro.setPassword(senhaCifrada);

        var salvo = repository.save(cadastro);
        return (salvo);
    }

    public List<Usuario> findAll() {
        return repository.findAll();
    }
}
