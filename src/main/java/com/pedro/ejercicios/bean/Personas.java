package com.pedro.ejercicios.bean;

import java.util.List;

/**
 * Clase que contiene una lista de personas.
 */
public class Personas {

    /** Lista de personas. */
    private List<Persona> personas;

    /**
     * Constructor que inicializa la lista de personas.
     *
     * @param personas lista de personas
     */
    public Personas(List<Persona> personas) {
        this.personas = personas;
    }

    /**
     * Devuelve la lista de personas.
     *
     * @return lista de personas
     */
    public List<Persona> getPersonas() {
        return personas;
    }

    /**
     * Establece la lista de personas.
     *
     * @param personas lista de personas
     */
    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
}