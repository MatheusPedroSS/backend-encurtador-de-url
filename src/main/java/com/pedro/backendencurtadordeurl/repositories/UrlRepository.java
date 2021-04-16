package com.pedro.backendencurtadordeurl.repositories;

import java.util.List;
import java.util.Optional;

import com.pedro.backendencurtadordeurl.model.Url;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Integer> {

    @Query(value = "SELECT * FROM url u WHERE u.hash_url = ?1", nativeQuery = true)
    Optional<Url> findByHashUrl(String hashUrl);
    
    @Query(value = "SELECT * FROM url u WHERE u.usuario_id = ?1", nativeQuery = true)
    List<Url> findAllByUsuarioId(Integer usuarioId);
}
