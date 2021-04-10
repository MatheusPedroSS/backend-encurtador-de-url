package com.pedro.backendencurtadordeurl.services;

import java.util.Optional;

import com.pedro.backendencurtadordeurl.domain.Url;
import com.pedro.backendencurtadordeurl.repositories.UrlRepository;
import com.pedro.backendencurtadordeurl.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService {
    
    @Autowired
    private UrlRepository repository;

    public Url find(Integer id){
        Optional<Url> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Url não encontrada!"));
    }

    public Url insert(Url obj) {
        return repository.save(obj);
    }

    public Url update(Url obj) {
        find(obj.getId());
        return repository.save(obj);
    }

}
