package com.pedro.demo.repository;

import com.pedro.demo.model.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio que gestiona las operaciones CRUD de la entidad {@link Editorial}.
 */
public interface EditorialRepository extends JpaRepository<Editorial, Integer> {

}