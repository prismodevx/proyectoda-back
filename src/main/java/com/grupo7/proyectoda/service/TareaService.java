package com.grupo7.proyectoda.service;

import com.grupo7.proyectoda.entity.Tarea;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TareaService {
    public List<Tarea> findAll(Pageable page);
    public List<Tarea> findAll();
    public List<Tarea> findByTitulo(String titulo, Pageable page);
    public Tarea findById(int id);
    public Tarea save(Tarea registro);
    public void delete(int id);
}
