package com.pedro.backendencurtadordeurl.resources;

import java.net.URI;

import com.pedro.backendencurtadordeurl.model.Usuario;
import com.pedro.backendencurtadordeurl.services.UsuarioService;

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
@RequestMapping(value = "/usuario")
public class UsuarioResource {
    
    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Usuario obj) {
        Usuario usuario = service.insert(obj);
        URI  uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> find(@PathVariable Integer id) {
        Usuario usuario = service.find(id);
        return ResponseEntity.ok().body(usuario);
    }
}
