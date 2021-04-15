package com.pedro.backendencurtadordeurl.security;

import java.util.Arrays;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UsuarioSistema extends User {
    private static final long serialVersionUID = 1L;

    public UsuarioSistema(String username, String password) {
        super(username, password, true, true, true, true, Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
    }
}
