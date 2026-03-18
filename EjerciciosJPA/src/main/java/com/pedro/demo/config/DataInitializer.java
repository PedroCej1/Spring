package com.pedro.demo.config;

import com.pedro.demo.model.*;
import com.pedro.demo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

/**
 * Clase de configuración encargada de inicializar la base de datos
 * con datos de prueba al arrancar la aplicación.
 * Implementa CommandLineRunner para ejecutar la carga inicial.
 */
@Configuration
public class DataInitializer {

    /**
     * Inicializa la base de datos con autores, editoriales,
     * temáticas y libros de ejemplo.
     *
     * @param autorRepository repositorio de autores
     * @param editorialRepository repositorio de editoriales
     * @param tematicaRepository repositorio de temáticas
     * @param libroRepository repositorio de libros
     * @return CommandLineRunner que ejecuta la inicialización
     */
    @Bean
    CommandLineRunner initDatabase(
            AutorRepository autorRepository,
            EditorialRepository editorialRepository,
            TematicaRepository tematicaRepository,
            LibroRepository libroRepository) {

        return args -> {

            // 🔹 Evitar duplicados
            if (autorRepository.count() > 0) {
                return;
            }

            // =========================
            // AUTORES
            // =========================
            Autor a1 = new Autor();
            a1.setNombre("Gabriel");
            a1.setApellidos("García Márquez");
            a1.setFechaNacimiento(LocalDate.of(1927, 3, 6));

            Autor a2 = new Autor();
            a2.setNombre("Mario");
            a2.setApellidos("Vargas Llosa");
            a2.setFechaNacimiento(LocalDate.of(1936, 3, 28));

            autorRepository.save(a1);
            autorRepository.save(a2);

            // =========================
            // EDITORIALES
            // =========================
            Editorial e1 = new Editorial();
            e1.setEditorial("RBA");

            Editorial e2 = new Editorial();
            e2.setEditorial("PLANETA");

            editorialRepository.save(e1);
            editorialRepository.save(e2);

            // =========================
            // TEMÁTICAS
            // =========================
            Tematica t1 = new Tematica();
            t1.setCategoria("Novela");

            Tematica t2 = new Tematica();
            t2.setCategoria("Historia");

            tematicaRepository.save(t1);
            tematicaRepository.save(t2);

            // =========================
            // LIBROS (casos de prueba)
            // =========================

            Libro l1 = new Libro();
            l1.setTitulo("Libro Año 2001");
            l1.setIsbn("ISBN001");
            l1.setAnioPublicacion(LocalDate.of(2001, 5, 10));
            l1.setAutor(a1);
            l1.setEditorial(e1);
            l1.setTematica(t1);

            Libro l2 = new Libro();
            l2.setTitulo("Libro Posterior 2010");
            l2.setIsbn("ISBN002");
            l2.setAnioPublicacion(LocalDate.of(2010, 3, 15));
            l2.setAutor(a1);
            l2.setEditorial(e2);
            l2.setTematica(t2);

            Libro l3 = new Libro();
            l3.setTitulo("Libro Planeta 1986");
            l3.setIsbn("ISBN003");
            l3.setAnioPublicacion(LocalDate.of(1986, 7, 20));
            l3.setAutor(a2);
            l3.setEditorial(e2);
            l3.setTematica(t1);

            Libro l4 = new Libro();
            l4.setTitulo("Libro RBA 1999");
            l4.setIsbn("ISBN004");
            l4.setAnioPublicacion(LocalDate.of(1999, 1, 1));
            l4.setAutor(a2);
            l4.setEditorial(e1);
            l4.setTematica(t2);

            libroRepository.save(l1);
            libroRepository.save(l2);
            libroRepository.save(l3);
            libroRepository.save(l4);

            System.out.println("✅ Base de datos inicializada correctamente");
        };
    }
}