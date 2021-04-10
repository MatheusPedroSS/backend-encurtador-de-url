package com.pedro.backendencurtadordeurl.repositories;

import com.pedro.backendencurtadordeurl.domain.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
}
