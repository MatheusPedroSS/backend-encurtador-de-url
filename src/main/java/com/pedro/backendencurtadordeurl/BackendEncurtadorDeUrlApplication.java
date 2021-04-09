package com.pedro.backendencurtadordeurl;

import com.pedro.backendencurtadordeurl.domain.Usuario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendEncurtadorDeUrlApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BackendEncurtadorDeUrlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Usuario usuario = new Usuario(null, "matheus", "100568");
		System.out.println(usuario);
		
	}

}
