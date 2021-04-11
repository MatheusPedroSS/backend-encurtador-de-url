package com.pedro.backendencurtadordeurl.services;

import java.util.Optional;

import com.pedro.backendencurtadordeurl.domain.Usuario;
import com.pedro.backendencurtadordeurl.repositories.UsuarioRepository;
import com.pedro.backendencurtadordeurl.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private BCryptPasswordEncoder passwordEnconder;

    @Autowired
    private UsuarioRepository repository;

    public Usuario find(Integer id){
        Optional<Usuario> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
    }

    public Usuario insert(Usuario obj) {
        obj.setSenha(passwordEnconder.encode(obj.getSenha()));
        return repository.save(obj);
    }

    public Usuario update(Usuario obj) {
        find(obj.getId());
        return repository.save(obj);
    }

}
