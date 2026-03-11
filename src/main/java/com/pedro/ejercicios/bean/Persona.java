package com.pedro.ejercicios.bean;

import java.time.LocalDate;
import jakarta.validation.constraints.*;

/**
 * Clase que representa una persona dentro del sistema.
 *
 * Contiene la información básica de identificación y datos personales
 * como nombre, apellidos, fecha de nacimiento y sexo.
 */
public class Persona {

    /** DNI de la persona. */
    private String dni;

    /** Nombre de la persona. */
    @NotBlank(message = "nombre obligatorio")
    @Size(min = 2, max = 30)
    private String nombre;

    /** Primer apellido de la persona. */
    private String primerApellido;

    /** Segundo apellido de la persona. */
    private String segundoApellido;

    /** Nombre completo de la persona compuesto por nombre y apellidos. */
    private String nombreCompleto;

    /** Fecha de nacimiento de la persona. */
    private LocalDate fechaNacimiento;

    /** Sexo de la persona. */
    private String sexo;

    /**
     * Constructor vacío de la clase Persona.
     * Permite crear un objeto sin inicializar sus atributos.
     */
    public Persona() {
    }

    // CONSTRUCTOR SIN DNI EJERCICIOS 1 Y 2

    /**
     * Constructor que inicializa una persona sin especificar el DNI.
     *
     * @param nombre nombre de la persona
     * @param primerApellido primer apellido de la persona
     * @param segundoApellido segundo apellido de la persona
     * @param fechaNacimiento fecha de nacimiento de la persona
     * @param sexo sexo de la persona
     */
    public Persona(String nombre, String primerApellido, String segundoApellido, LocalDate fechaNacimiento, String sexo) {

        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nombreCompleto = nombre + " " + primerApellido + " " + segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }


    // CONSTRUCTOR CON DNI EJERCICIO 3

    /**
     * Constructor que inicializa todos los datos de una persona incluyendo el DNI.
     *
     * @param dni documento nacional de identidad de la persona
     * @param nombre nombre de la persona
     * @param primerApellido primer apellido de la persona
     * @param segundoApellido segundo apellido de la persona
     * @param fechaNacimiento fecha de nacimiento de la persona
     * @param sexo sexo de la persona
     */
    public Persona(String dni, String nombre, String primerApellido, String segundoApellido, LocalDate fechaNacimiento, String sexo) {

        this.dni = dni;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nombreCompleto = nombre + " " + primerApellido + " " + segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    /**
     * Obtiene el DNI de la persona.
     *
     * @return dni de la persona
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI de la persona.
     *
     * @param dni documento nacional de identidad
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el primer apellido de la persona.
     *
     * @return primer apellido
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * Obtiene el segundo apellido de la persona.
     *
     * @return segundo apellido
     */
    public String getSegundoApellido() {
        return segundoApellido;
    }

    /**
     * Obtiene el nombre completo de la persona.
     *
     * @return nombre completo compuesto por nombre y apellidos
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Obtiene la fecha de nacimiento de la persona.
     *
     * @return fecha de nacimiento
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Obtiene el sexo de la persona.
     *
     * @return sexo de la persona
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el primer apellido de la persona.
     *
     * @param primerApellido primer apellido
     */
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    /**
     * Establece el segundo apellido de la persona.
     *
     * @param segundoApellido segundo apellido
     */
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     *
     * @param fechaNacimiento fecha de nacimiento
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Establece el sexo de la persona.
     *
     * @param sexo sexo de la persona
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}