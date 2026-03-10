package com.pedro.ejercicios.bean;

import java.util.List;

public class Personas {

    private List<Persona> personas;

    public Personas(List<Persona> personas) {
        this.personas = personas;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
}