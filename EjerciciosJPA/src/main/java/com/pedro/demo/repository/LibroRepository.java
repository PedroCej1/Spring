package com.pedro.demo.repository;

import com.pedro.demo.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Repositorio que gestiona las operaciones CRUD de la entidad {@link Libro}.
 * Incluye consultas personalizadas por título, autor, fechas, ISBN y editorial.
 */
public interface LibroRepository extends JpaRepository<Libro, Integer> {

    /**
     * Busca libros cuyo título contenga el texto indicado.
     *
     * @param titulo texto parcial del título
     * @return lista de libros que contienen el texto en su título
     */
    List<Libro> findByTituloContaining(String titulo);

    /**
     * Busca libros por el identificador del autor.
     *
     * @param autorId identificador del autor
     * @return lista de libros del autor indicado
     */
    List<Libro> findByAutorId(Integer autorId);

    /**
     * Busca libros publicados después de una fecha determinada.
     *
     * @param fecha fecha a partir de la cual buscar libros
     * @return lista de libros posteriores a la fecha indicada
     */
    @Query("SELECT l FROM Libro l WHERE l.anioPublicacion > :fecha")
    List<Libro> findLibrosPosterioresA(@Param("fecha") LocalDate fecha);

    /**
     * Busca libros cuyo año de publicación sea mayor que la fecha indicada.
     *
     * @param fecha fecha de referencia
     * @return lista de libros posteriores a la fecha
     */
    List<Libro> findByAnioPublicacionGreaterThan(LocalDate fecha);

    /**
     * Busca libros publicados entre dos fechas.
     *
     * @param inicio fecha inicial del rango
     * @param fin fecha final del rango
     * @return lista de libros dentro del rango indicado
     */
    List<Libro> findByAnioPublicacionBetween(LocalDate inicio, LocalDate fin);

    /**
     * Busca un libro por su ISBN.
     *
     * @param isbn código ISBN del libro
     * @return libro encontrado o {@link Optional#empty()} si no existe
     */
    Optional<Libro> findByIsbn(String isbn);

    /**
     * Busca libros por el nombre de la editorial.
     *
     * @param editorial nombre de la editorial
     * @return lista de libros de la editorial indicada
     */
    List<Libro> findByEditorialEditorial(String editorial);

    /**
     * Busca libros por editorial y rango de fechas de publicación.
     *
     * @param editorial nombre de la editorial
     * @param inicio fecha inicial del rango
     * @param fin fecha final del rango
     * @return lista de libros que cumplen los criterios
     */
    List<Libro> findByEditorialEditorialAndAnioPublicacionBetween(
            String editorial,
            LocalDate inicio,
            LocalDate fin
    );
}