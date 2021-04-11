package com.pedro.backendencurtadordeurl.resources;

import java.net.URI;
import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/url")
public class UrlResource {
    
    @Autowired
    private UrlService service;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Url obj) {
        String baseUrl = ServletUriComponentsBuilder.fromCurrentRequest().path("/").toUriString();
        Url url = service.insert(obj, baseUrl);
        URI  uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{hashUrl}").buildAndExpand(url.getHashUrl()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{hashUrl}")
    public ModelAndView find(@PathVariable String hashUrl) {
        Url url = service.findByUrlEncurtada(hashUrl);
        return new ModelAndView("redirect:" + url.getUrlOriginal());
    }

    @GetMapping
    public List<Url> findAllUrl() {
        return service.findAllUrl();
    }
}
