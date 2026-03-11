package com.pedro.ejercicios.bean;

import java.time.LocalDate;
import jakarta.validation.constraints.*;

/**
 * Clase que representa una persona dentro del sistema.
 *
 * Contiene la informacion basica de identificacion y datos personales
 * como nombre, apellidos, fecha de nacimiento y sexo.
 */
public class Persona {

    /** DNI de la persona. */
    @NotBlank(message = "dni obligatorio")
    @Size(min = 9, max = 9, message = "el dni debe tener 9 caracteres")
    private String dni;

    /** Nombre de la persona. */
    @NotBlank(message = "nombre obligatorio")
    @Size(min = 2, max = 30, message = "el nombre debe tener entre 2 y 30 caracteres")
    private String nombre;

    /** Primer apellido de la persona. */
    @NotBlank(message = "primer apellido obligatorio")
    @Size(min = 2, max = 30)
    private String primerApellido;

    /** Segundo apellido de la persona. */
    @NotBlank(message = "segundo apellido obligatorio")
    @Size(min = 2, max = 30)
    private String segundoApellido;

    /** Nombre completo de la persona compuesto por nombre y apellidos. */
    private String nombreCompleto;

    /** Fecha de nacimiento de la persona. */
    @NotNull(message = "fecha de nacimiento obligatoria")
    @Past(message = "la fecha debe ser anterior a hoy")
    private LocalDate fechaNacimiento;

    /** Sexo de la persona. */
    @NotBlank(message = "sexo obligatorio")
    private String sexo;

    /**
     * Constructor vacio de la clase Persona.
     */
    public Persona() {
    }

    // CONSTRUCTOR SIN DNI EJERCICIOS 1 Y 2

    public Persona(String nombre, String primerApellido, String segundoApellido, LocalDate fechaNacimiento, String sexo) {

        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nombreCompleto = nombre + " " + primerApellido + " " + segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    // CONSTRUCTOR CON DNI EJERCICIO 3

    public Persona(String dni, String nombre, String primerApellido, String segundoApellido, LocalDate fechaNacimiento, String sexo) {

        this.dni = dni;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nombreCompleto = nombre + " " + primerApellido + " " + segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}