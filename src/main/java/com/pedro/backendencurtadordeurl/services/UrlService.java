package com.pedro.backendencurtadordeurl.services;

import java.util.List;
import java.util.Optional;

import com.pedro.backendencurtadordeurl.domain.Url;
import com.pedro.backendencurtadordeurl.repositories.UrlRepository;
import com.pedro.backendencurtadordeurl.services.exceptions.ObjectNotFoundException;
import com.pedro.backendencurtadordeurl.services.utils.HashUrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService {
    
    @Autowired
    private UrlRepository repository;

    public Url findByUrlEncurtada(String hashUrl) {
        Optional<Url> obj = repository.findByHashUrl(hashUrl);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Url não encontrada!"));
    }

    public Url insert(Url obj, String baseUrl) {
        obj.setHashUrl(HashUrl.create().toString());
        obj.setUrlEncurtada(baseUrl + obj.getHashUrl());
        return repository.save(obj);
    }

    public List<Url> findAllUrl() {
        return repository.findAll();
    }

}
