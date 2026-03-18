package com.pedro.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

// EJERCICIO 2

/**
 * Entidad que representa un autor dentro del sistema.
 * Mapea la tabla AUTORES de la base de datos.
 */
@Entity
@Table(name = "AUTORES")
public class Autor {

    /**
     * Identificador único del autor.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAutor")
    private Integer id;

    /**
     * Nombre del autor.
     */
    @Column(name = "Nombre", nullable = false, length = 100)
    private String nombre;

    /**
     * Apellidos del autor.
     */
    @Column(name = "Apellidos", nullable = false, length = 150)
    private String apellidos;

    /**
     * Fecha de nacimiento del autor.
     */
    @Column(name = "FechaNacimiento")
    private LocalDate fechaNacimiento;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Autor() {

    }

    /**
     * Constructor con parámetros.
     *
     * @param idAutor identificador del autor
     * @param apellidos apellidos del autor
     * @param nombre nombre del autor
     */
    public Autor(Integer idAutor, String apellidos, String nombre) {
        this.id = idAutor;
        this.apellidos = apellidos;
        this.nombre = nombre;
    }

    // getters y setters

    /**
     * Obtiene el identificador del autor.
     * @return id del autor
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el identificador del autor.
     * @param id identificador
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del autor.
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del autor.
     * @param nombre nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos del autor.
     * @return apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del autor.
     * @param apellidos apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene la fecha de nacimiento.
     * @return fecha de nacimiento
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento.
     * @param fechaNacimiento fecha
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}