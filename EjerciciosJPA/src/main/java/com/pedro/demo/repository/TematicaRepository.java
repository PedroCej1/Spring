package com.pedro.demo.repository;

import com.pedro.demo.model.Tematica;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio que gestiona las operaciones CRUD de la entidad {@link Tematica}.
 */
public interface TematicaRepository extends JpaRepository<Tematica, Integer> {

}