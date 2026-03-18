package com.pedro.demo.model;

import jakarta.persistence.*;

// EJERCICIO 2

/**
 * Entidad que representa una temática o categoría dentro del sistema.
 * Mapea la tabla TEMATICAS de la base de datos.
 */
@Entity
@Table(name = "TEMATICAS")
public class Tematica {

    /**
     * Constructor vacío requerido por JPA.
     */
    public Tematica() {
    }

    /**
     * Identificador único de la temática.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTematica")
    private Integer idTematica;

    /**
     * Nombre de la categoría o temática.
     */
    @Column(name = "Categoria", nullable = false, length = 100)
    private String categoria;

    /**
     * Constructor con parámetros.
     *
     * @param idTematica identificador de la temática
     * @param categoria nombre de la categoría
     */
    public Tematica(Integer idTematica, String categoria) {
        this.idTematica = idTematica;
        this.categoria = categoria;
    }

    // getters y setters

    /**
     * Obtiene la categoría.
     * @return categoría
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría.
     * @param categoria nombre de la categoría
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Obtiene el identificador de la temática.
     * @return id
     */
    public Integer getIdTematica() {
        return idTematica;
    }

    /**
     * Establece el identificador de la temática.
     * @param idTematica identificador
     */
    public void setIdTematica(Integer idTematica) {
        this.idTematica = idTematica;
    }
}