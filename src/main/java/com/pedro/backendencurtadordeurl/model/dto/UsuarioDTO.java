package com.pedro.backendencurtadordeurl.model.dto;

import com.pedro.backendencurtadordeurl.model.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
public class UsuarioDTO {
    
    @Getter private String username;
    @Getter private String password;

    public Usuario dtoFromObject() {
        return new Usuario(username, password);
    }
}
