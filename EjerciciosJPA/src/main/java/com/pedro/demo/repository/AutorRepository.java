package com.pedro.demo.repository;

import com.pedro.demo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repositorio que gestiona las operaciones CRUD de la entidad {@link Autor}.
 * Proporciona métodos personalizados para consultas por nombre y ordenación.
 */
public interface AutorRepository extends JpaRepository<Autor, Integer> {

    /**
     * Busca autores por su nombre exacto.
     *
     * @param nombre nombre del autor a buscar
     * @return lista de autores que coinciden con el nombre
     */
    List<Autor> findByNombre(String nombre);

    /**
     * Obtiene todos los autores ordenados por nombre en orden ascendente.
     *
     * @return lista de autores ordenados alfabéticamente por nombre
     */
    List<Autor> findAllByOrderByNombreAsc();
}