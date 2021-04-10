package com.pedro.backendencurtadordeurl.repositories;

import com.pedro.backendencurtadordeurl.domain.Url;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Integer> {
}
