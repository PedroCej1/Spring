package com.pedro.demo.controller;

import com.pedro.demo.model.Autor;
import com.pedro.demo.repository.AutorRepository;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que gestiona las operaciones relacionadas con la entidad Autor.
 * Expone endpoints para consultar, crear y eliminar autores.
 */
@RestController
@RequestMapping("/autores")
public class AutorController {

    /**
     * Logger para registrar eventos del controlador.
     */
    private static final Logger logger = LogManager.getLogger(AutorController.class);

    @Autowired
    private AutorRepository autorRepository;

    /**
     * Obtiene todos los autores.
     *
     * @return lista de autores
     */
    @GetMapping
    public List<Autor> getAllAutores() {
        logger.info("Solicitud para obtener todos los autores");
        return autorRepository.findAll();
    }

    /**
     * Obtiene un autor por su identificador.
     *
     * @param id identificador del autor
     * @return autor encontrado o null si no existe
     */
    @GetMapping("/{id}")
    public Autor getAutorById(@PathVariable Integer id) {
        logger.info("Solicitud para obtener autor con id: {}", id);
        return autorRepository.findById(id).orElse(null);
    }

    /**
     * Crea un nuevo autor.
     *
     * @param autor objeto autor a guardar
     * @return autor guardado
     */
    @PostMapping
    public Autor createAutor(@Valid @RequestBody Autor autor) {
        logger.info("Creando nuevo autor: {}", autor.getNombre());
        return autorRepository.save(autor);
    }

    /**
     * Elimina un autor por su identificador.
     *
     * @param id identificador del autor a eliminar
     */
    @DeleteMapping("/{id}")
    public void deleteAutor(@PathVariable Integer id) {
        logger.warn("Eliminando autor con id: {}", id);
        autorRepository.deleteById(id);
    }
}