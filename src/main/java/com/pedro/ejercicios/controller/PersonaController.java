package com.pedro.ejercicios.controller;

import com.pedro.ejercicios.bean.Persona;
import com.pedro.ejercicios.service.PersonaService;

import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar personas.
 */
@RestController
public class PersonaController {

    /** Logger de la clase. */
    private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(PersonaController.class);

    /** Servicio que gestiona la lógica de personas. */
    private final PersonaService personaService;

    /**
     * Constructor del controlador.
     *
     * @param personaService servicio de personas
     */
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    // EJERCICIO 1
    /**
     * Devuelve una persona.
     *
     * @return persona
     */
    @GetMapping("/persona")
    public Persona getPerson() {
        return personaService.obtenerPersona();
    }

    // EJERCICIO 2
    /**
     * Recibe los datos del formulario y crea una persona.
     *
     * @param nombre nombre
     * @param apellido1 primer apellido
     * @param apellido2 segundo apellido
     * @param fechaNacimiento fecha de nacimiento
     * @param sexo sexo
     * @return mensaje con el resultado
     */
    @PostMapping("/envioFormulario")
    public String receiveForm(
            @RequestParam String nombre,
            @RequestParam String apellido1,
            @RequestParam String apellido2,
            @RequestParam String fechaNacimiento,
            @RequestParam String sexo
    ) {

        try {
            return personaService.recibirFormulario(nombre, apellido1, apellido2, fechaNacimiento, sexo
            );
        } catch (Exception e) {
            log.error("error en el controlador ejercicio 2");
            throw new RuntimeException(e);
        }
    }

    // EJERCICIO 3.1
    /**
     * Devuelve una persona buscando por dni.
     *
     * @param dni dni de la persona
     * @return persona encontrada
     */
    @GetMapping("/persona/{dni}")
    public Persona getPersonByDni(@PathVariable String dni) {
        try {
            return personaService.getPersonaByDni(dni);
        } catch (Exception e) {
            log.error("error en el controlador 3.1");
            throw new RuntimeException(e);
        }
    }

    // EJERCICIO 3.2
    /**
     * Actualiza los datos de una persona.
     *
     * @param updatedPerson persona con los datos actualizados
     * @return mensaje con el resultado
     */
    @PutMapping("/persona")
    public String updatePerson(@RequestBody Persona updatedPerson) {
        try {
            return personaService.updatePersona(updatedPerson);
        } catch (Exception e) {
            log.error("error en el controlador 3.2");
            throw new RuntimeException(e);
        }
    }

    /**
     * Actualiza los datos de una persona con DNI.
     *
     * @param updatedPerson persona con los datos actualizados
     * @return mensaje con el resultado
     */
    @PutMapping("/persona/{dni}")
    public String updatePersonByDni(@Valid @RequestBody Persona updatedPerson) {
        try {
            return personaService.updatePersona(updatedPerson);
        } catch (Exception e) {
            log.error("error en el controlador 3.2 por dni");
            throw new RuntimeException(e);
        }
    }

}