package com.challangue.literalura;

import com.challangue.literalura.Principal.Principal;
import com.challangue.literalura.repository.LibroRepository;
import com.challangue.literalura.services.ConsumirAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	LibroRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository);
		principal.mostrarMenu();

	}

}
