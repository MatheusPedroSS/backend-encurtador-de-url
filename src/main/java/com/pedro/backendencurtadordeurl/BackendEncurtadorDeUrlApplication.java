package com.pedro.backendencurtadordeurl;

import java.util.Date;

import com.pedro.backendencurtadordeurl.domain.Url;
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

		Url url = new Url(null, "https:www.matheus.pedro.dev", "https:www.encu/jrjdj", new Date());
		System.out.println(url);
	}

}
