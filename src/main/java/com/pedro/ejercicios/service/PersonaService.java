package com.pedro.ejercicios.service;

import com.pedro.ejercicios.bean.Persona;
import com.pedro.ejercicios.bean.Personas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class PersonaService {

    private static final Logger log = LoggerFactory.getLogger(PersonaService.class);

    private Personas personas;
    private Persona storedPerson;

    // regex DNI
    private static final Pattern DNI_PATTERN = Pattern.compile("^[0-9]{8}[A-Za-z]$");

    public PersonaService() {

        log.info("Inicializando lista de personas");

        List<Persona> lista = new ArrayList<>();
        lista.add(new Persona("11111111A","Juan","Perez","Lopez", LocalDate.of(1990,1,10),"Masculino"));
        lista.add(new Persona("22222222B","Ana","Gomez","Martinez", LocalDate.of(1992,3,12),"Femenino"));
        lista.add(new Persona("33333333C","Luis","Rodriguez","Diaz", LocalDate.of(1988,7,5),"Masculino"));
        lista.add(new Persona("44444444D","Maria","Fernandez","Ruiz", LocalDate.of(1995,9,20),"Femenino"));
        lista.add(new Persona("55555555E","Carlos","Sanchez","Molina", LocalDate.of(1991,4,2),"Masculino"));
        lista.add(new Persona("66666666F","Laura","Romero","Gil", LocalDate.of(1993,11,8),"Femenino"));
        lista.add(new Persona("77777777G","Pedro","Cejudo","Villar", LocalDate.of(2002,9,2),"Masculino"));
        lista.add(new Persona("88888888H","David","Torres","Navarro", LocalDate.of(1987,6,14),"Masculino"));
        lista.add(new Persona("99999999I","Sofia","Castro","Ortega", LocalDate.of(1994,8,30),"Femenino"));
        lista.add(new Persona("10101010J","Miguel","Herrera","Vega", LocalDate.of(1996,12,18),"Masculino"));
        personas = new Personas(lista);

        log.info("Personas cargadas correctamente");
    }

    // EJERCICIO 1
    public Persona obtenerPersona() {
        log.info("Inicio obtenerPersona");

        try {
            Persona persona = new Persona("Pedro", "Cejudo", "Villar", LocalDate.of(2002,9,2), "Masculino");
            log.info("Persona creada");
            return persona;

        } catch (Exception e) {
            log.error("Error en obtenerPersona", e);
            throw e;
        }
    }

    // EJERCICIO 2
    public String recibirFormulario(String nombre, String apellido1, String apellido2, String fechaNacimiento, String sexo) throws Exception {
        log.info("Inicio recibirFormulario");

        try {
            LocalDate birthDate = LocalDate.parse(fechaNacimiento);
            storedPerson = new Persona(nombre, apellido1, apellido2, birthDate, sexo
            );
            // mejor con st{}, var que con st + var
            log.info("--------------- Persona almacenada ------------");
            log.info("Nombre: {}", nombre);
            log.info("Apellido1: {}", apellido1);
            log.info("Apellido2: {}", apellido2);
            log.info("Fecha nacimiento: {}", fechaNacimiento);
            log.info("Sexo: {}", sexo);
            log.info("------------------------------------------------");

            return "Datos recibidos correctamente";

        } catch (Exception e) {
            log.error("Error en el formulario", e);
            throw e;
        }
    }

    // validar DNI
    private void validarDni(String dni) throws Exception {

        log.info("Validando DNI {}", dni);

        if (dni == null || !DNI_PATTERN.matcher(dni).matches()) {
            log.error("Formato DNI incorrecto");
            throw new Exception("DNI inválido");
        }
    }

    // EJERCICIO 3.1
    public Persona getPersonaByDni(String dni) throws Exception {
        log.info("Buscando persona por DNI {}", dni);
        try {

            validarDni(dni);
            for (Persona p : personas.getPersonas()) {
                if (p.getDni().equalsIgnoreCase(dni)) {
                    log.info("Persona encontrada");
                    return p;
                }
            }

            log.error("Persona no encontrada");
            return null;

        } catch (Exception e) {
            log.error("Error buscando persona", e);
            throw e;
        }
    }

    // EJERCICIO 3.2
    public String updatePersona(Persona updatedPerson) throws Exception {
        log.info("Inicio actualizarPersona");

        try {
            validarDni(updatedPerson.getDni());
            for (Persona p : personas.getPersonas()) {
                if (p.getDni().equalsIgnoreCase(updatedPerson.getDni())) {
                    log.info("Persona encontrada, actualizando");

                    p.setNombre(updatedPerson.getNombre());
                    p.setPrimerApellido(updatedPerson.getPrimerApellido());
                    p.setSegundoApellido(updatedPerson.getSegundoApellido());
                    p.setFechaNacimiento(updatedPerson.getFechaNacimiento());
                    p.setSexo(updatedPerson.getSexo());

                    log.info("Persona actualizada crrectamente");
                    return "Persona actualizada correctamente";
                }
            }

            log.info("Persona no encontrada");
            return "Persona no encontrada";
        } catch (Exception e) {
            log.error("Error actualizando persona", e);
            throw e;
        }
    }
}