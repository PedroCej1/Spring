package com.pedro.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

// EJERCICIO 2

/**
 * Entidad que representa un libro dentro del sistema.
 * Mapea la tabla LIBROS de la base de datos.
 */
@Entity
@Table(name = "LIBROS")
public class Libro {

    /**
     * Identificador único del libro.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdLibro")
    private Integer idLibro;

    /**
     * Código ISBN del libro.
     */
    @Column(name = "ISBN", nullable = false, unique = true, length = 20)
    private String isbn;

    /**
     * Título del libro.
     */
    @Column(name = "Titulo", nullable = false, length = 200)
    private String titulo;

    /**
     * Año de publicación del libro.
     */
    private LocalDate anioPublicacion;

    /**
     * Autor del libro.
     */
    @ManyToOne
    @JoinColumn(name = "IdAutor")
    private Autor autor;

    /**
     * Editorial del libro.
     */
    @ManyToOne
    @JoinColumn(name = "IdEditorial")
    private Editorial editorial;

    /**
     * Temática del libro.
     */
    @ManyToOne
    @JoinColumn(name = "IdTematica")
    private Tematica tematica;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Libro() {

    }

    /**
     * Constructor con parámetros.
     *
     * @param idLibro identificador del libro
     * @param titulo título del libro
     * @param autor autor asociado
     * @param editorial editorial asociada
     * @param tematica temática asociada
     */
    public Libro(Integer idLibro, String titulo, Autor autor, Editorial editorial, Tematica tematica) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.tematica = tematica;
    }

    // getters y setters

    public Tematica getTematica() {
        return tematica;
    }

    public void setTematica(Tematica tematica) {
        this.tematica = tematica;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public LocalDate getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(LocalDate anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }
}