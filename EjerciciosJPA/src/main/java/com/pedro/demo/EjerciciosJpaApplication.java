package com.pedro.demo;

import com.pedro.demo.model.Autor;
import com.pedro.demo.model.Libro;
import com.pedro.demo.repository.AutorRepository;
import com.pedro.demo.repository.EditorialRepository;
import com.pedro.demo.repository.LibroRepository;
import com.pedro.demo.repository.TematicaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class EjerciciosJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjerciciosJpaApplication.class, args);
	}

}
