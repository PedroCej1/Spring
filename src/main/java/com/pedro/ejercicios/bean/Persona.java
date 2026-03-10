package com.pedro.ejercicios.bean;

import java.time.LocalDate;
public class Persona {

    private String dni;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private String sexo;

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