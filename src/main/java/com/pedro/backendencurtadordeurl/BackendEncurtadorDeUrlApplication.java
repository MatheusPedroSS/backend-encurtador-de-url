package com.pedro.backendencurtadordeurl;

import com.pedro.backendencurtadordeurl.model.Usuario;
import com.pedro.backendencurtadordeurl.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendEncurtadorDeUrlApplication implements CommandLineRunner {

	@Autowired
	private UsuarioService service;

	public static void main(String[] args) {
		SpringApplication.run(BackendEncurtadorDeUrlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario usuario = new Usuario("matheus", "123456");
		service.insert(usuario);
	}

}
