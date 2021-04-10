package com.pedro.backendencurtadordeurl.resources;

import java.net.URI;

import com.pedro.backendencurtadordeurl.domain.Url;
import com.pedro.backendencurtadordeurl.services.UrlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/url")
public class UrlResource {
    
    @Autowired
    private UrlService service;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Url obj) {
        Url url = service.insert(obj);
        URI  uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(url.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Url> find(@PathVariable Integer id) {
        Url url = service.find(id);
        return ResponseEntity.ok().body(url);
    }
}
