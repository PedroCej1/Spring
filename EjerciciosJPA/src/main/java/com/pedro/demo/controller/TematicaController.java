package com.pedro.demo.controller;

import com.pedro.demo.model.Tematica;
import com.pedro.demo.repository.TematicaRepository;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que gestiona las operaciones relacionadas con la entidad Tematica.
 * Permite consultar y crear temáticas.
 */
@RestController
@RequestMapping("/tematicas")
public class TematicaController {

    /**
     * Logger para registrar las operaciones del controlador.
     */
    private static final Logger logger = LogManager.getLogger(TematicaController.class);

    @Autowired
    private TematicaRepository tematicaRepository;

    /**
     * Obtiene todas las temáticas.
     *
     * @return lista de temáticas
     */
    @GetMapping
    public List<Tematica> getAll() {
        logger.info("Solicitud para obtener todas las temáticas");
        return tematicaRepository.findAll();
    }

    /**
     * Crea una nueva temática.
     *
     * @param tematica objeto temática a guardar
     * @return temática guardada
     */
    @PostMapping
    public Tematica create(@Valid @RequestBody Tematica tematica) {
        logger.info("Creando nueva temática: {}", tematica.getCategoria());
        return tematicaRepository.save(tematica);
    }
}