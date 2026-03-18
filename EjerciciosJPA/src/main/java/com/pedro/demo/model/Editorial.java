package com.pedro.demo.model;

import jakarta.persistence.*;

// EJERCICIO 2

/**
 * Entidad que representa una editorial dentro del sistema.
 * Mapea la tabla EDITORIALES de la base de datos.
 */
@Entity
@Table(name = "EDITORIALES")
public class Editorial {

    /**
     * Constructor vacío requerido por JPA.
     */
    public Editorial() {
    }

    /**
     * Identificador único de la editorial.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdEditorial")
    private Integer idEditorial;

    /**
     * Nombre de la editorial.
     */
    @Column(name = "Editorial", nullable = false, length = 150)
    private String editorial;

    /**
     * Razón social de la editorial.
     */
    @Column(name = "RazonSocial", length = 200)
    private String razonSocial;

    /**
     * Constructor con parámetros.
     *
     * @param idEditorial identificador de la editorial
     * @param editorial nombre de la editorial
     */
    public Editorial(Integer idEditorial, String editorial) {
        this.idEditorial = idEditorial;
        this.editorial = editorial;
    }

    // getters y setters

    /**
     * Obtiene la razón social.
     * @return razón social
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * Establece la razón social.
     * @param razonSocial razón social
     */
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    /**
     * Obtiene el nombre de la editorial.
     * @return editorial
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Establece el nombre de la editorial.
     * @param editorial nombre
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * Obtiene el identificador de la editorial.
     * @return id
     */
    public Integer getIdEditorial() {
        return idEditorial;
    }

    /**
     * Establece el identificador de la editorial.
     * @param idEditorial identificador
     */
    public void setIdEditorial(Integer idEditorial) {
        this.idEditorial = idEditorial;
    }
}