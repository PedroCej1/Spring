package com.pedro.demo.controller;

import com.pedro.demo.model.Editorial;
import com.pedro.demo.repository.EditorialRepository;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que gestiona las operaciones relacionadas con la entidad Editorial.
 * Permite consultar, crear y eliminar editoriales.
 */
@RestController
@RequestMapping("/editoriales")
public class EditorialController {

    /**
     * Logger para registrar las operaciones del controlador.
     */
    private static final Logger logger = LogManager.getLogger(EditorialController.class);

    @Autowired
    private EditorialRepository editorialRepository;

    /**
     * Obtiene todas las editoriales.
     *
     * @return lista de editoriales
     */
    @GetMapping
    public List<Editorial> getAll() {
        logger.info("Solicitud para obtener todas las editoriales");
        return editorialRepository.findAll();
    }

    /**
     * Obtiene una editorial por su identificador.
     *
     * @param id identificador de la editorial
     * @return editorial encontrada o null si no existe
     */
    @GetMapping("/{id}")
    public Editorial getById(@PathVariable Integer id) {
        logger.info("Solicitud para obtener editorial con id: {}", id);
        return editorialRepository.findById(id).orElse(null);
    }

    /**
     * Crea una nueva editorial.
     *
     * @param editorial objeto editorial a guardar
     * @return editorial guardada
     */
    @PostMapping
    public Editorial create(@Valid @RequestBody Editorial editorial) {
        logger.info("Creando nueva editorial: {}", editorial.getEditorial());
        return editorialRepository.save(editorial);
    }

    /**
     * Elimina una editorial por su identificador.
     *
     * @param id identificador de la editorial
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        logger.warn("Eliminando editorial con id: {}", id);
        editorialRepository.deleteById(id);
    }
}