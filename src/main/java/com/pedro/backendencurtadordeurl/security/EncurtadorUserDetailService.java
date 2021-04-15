package com.pedro.backendencurtadordeurl.security;

import com.pedro.backendencurtadordeurl.model.Usuario;
import com.pedro.backendencurtadordeurl.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class EncurtadorUserDetailService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository.findByUsername(username);

        if(usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }
        return new UsuarioSistema(usuario.getUsername(), usuario.getPassword());
    }
    
}
