package com.grupo7.proyectoda.repository;

import com.grupo7.proyectoda.entity.Tarea;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {
    List<Tarea> findByTituloContaining(String titulo, Pageable pageable);
}
