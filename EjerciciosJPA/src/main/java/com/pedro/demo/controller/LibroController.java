package com.pedro.demo.controller;

import com.pedro.demo.model.Libro;
import com.pedro.demo.repository.LibroRepository;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Controlador REST que gestiona las operaciones relacionadas con la entidad Libro.
 * Incluye consultas básicas y consultas avanzadas por fecha, ISBN y editorial.
 */
@RestController
@RequestMapping("/libros")
public class LibroController {

    /**
     * Logger para registrar las operaciones del controlador.
     */
    private static final Logger logger = LogManager.getLogger(LibroController.class);

    @Autowired
    private LibroRepository libroRepository;

    /**
     * Obtiene todos los libros.
     *
     * @return lista de libros
     */
    @GetMapping
    public List<Libro> getAll() {
        logger.info("Solicitud para obtener todos los libros");
        return libroRepository.findAll();
    }

    /**
     * Obtiene un libro por su identificador.
     *
     * @param id identificador del libro
     * @return libro encontrado o null si no existe
     */
    @GetMapping("/{id}")
    public Libro getById(@PathVariable Integer id) {
        logger.info("Solicitud para obtener libro con id: {}", id);
        return libroRepository.findById(id).orElse(null);
    }

    /**
     * Crea un nuevo libro.
     *
     * @param libro libro a guardar
     * @return libro guardado
     */
    @PostMapping
    public Libro create(@Valid @RequestBody Libro libro) {
        logger.info("Creando libro con título: {}", libro.getTitulo());
        return libroRepository.save(libro);
    }

    /**
     * Elimina un libro por su identificador.
     *
     * @param id identificador del libro
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        logger.warn("Eliminando libro con id: {}", id);
        libroRepository.deleteById(id);
    }

    // EJERCICIO 4

    /**
     * Obtiene libros posteriores al 1 de diciembre de 2001.
     *
     * @return lista de libros posteriores
     */
    @GetMapping("/posteriores-2001")
    public List<Libro> posteriores() {
        logger.info("Buscando libros posteriores a 2001");
        return libroRepository.findLibrosPosterioresA(
                LocalDate.of(2001, 12, 1)
        );
    }

    // EJERCICIO 5

    /**
     * Obtiene libros posteriores usando método derivado.
     *
     * @return lista de libros posteriores
     */
    @GetMapping("/posteriores-metodo")
    public List<Libro> posterioresMetodo() {
        logger.info("Buscando libros posteriores usando método derivado");
        return libroRepository.findByAnioPublicacionGreaterThan(
                LocalDate.of(2001, 12, 1)
        );
    }

    // EJERCICIO 6

    /**
     * Busca libros por año de publicación.
     *
     * @param year año a consultar
     * @return lista de libros del año indicado
     */
    @GetMapping("/anio/{year}")
    public List<Libro> librosPorAnio(@PathVariable int year) {
        logger.info("Buscando libros del año: {}", year);
        return libroRepository
                .findByAnioPublicacionBetween(
                        LocalDate.of(year, 1, 1),
                        LocalDate.of(year, 12, 31)
                );
    }

    /**
     * Busca un libro por su ISBN.
     *
     * @param isbn código ISBN
     * @return libro encontrado
     */
    @GetMapping("/isbn/{isbn}")
    public Optional<Libro> buscarPorIsbn(@PathVariable String isbn) {
        logger.info("Buscando libro con ISBN: {}", isbn);
        return libroRepository.findByIsbn(isbn);
    }

    /**
     * Busca libros por nombre de editorial.
     *
     * @param nombre nombre de la editorial
     * @return lista de libros
     */
    @GetMapping("/editorial/{nombre}")
    public List<Libro> librosPorEditorial(@PathVariable String nombre) {
        logger.info("Buscando libros de la editorial: {}", nombre);
        return libroRepository.findByEditorialEditorial(nombre);
    }

    /**
     * Busca libros por editorial y año.
     *
     * @param nombre nombre de la editorial
     * @param year año de publicación
     * @return lista de libros
     */
    @GetMapping("/editorial={nombre}/anio={year}")
    public List<Libro> librosPorEditorialYAnio(
            @PathVariable String nombre,
            @PathVariable int year) {

        logger.info("Buscando libros de la editorial {} del año {}", nombre, year);

        return libroRepository
                .findByEditorialEditorialAndAnioPublicacionBetween(
                        nombre,
                        LocalDate.of(year, 1, 1),
                        LocalDate.of(year, 12, 31)
                );
    }
}