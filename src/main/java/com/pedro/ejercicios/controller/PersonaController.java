package com.pedro.ejercicios.controller;

import com.pedro.ejercicios.bean.Persona;
import com.pedro.ejercicios.service.PersonaService;

import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonaController {

    private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(PersonaController.class);
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    // EJERCICIO 1
    @GetMapping("/persona")
    public Persona getPerson() {
        return personaService.obtenerPersona();
    }

    // EJERCICIO 2
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
    @PutMapping("/persona")
    public String updatePerson(@RequestBody Persona updatedPerson) {
        try {
            return personaService.updatePersona(updatedPerson);
        } catch (Exception e) {
            log.error("error en el controlador 3.2");
            throw new RuntimeException(e);
        }
    }
}