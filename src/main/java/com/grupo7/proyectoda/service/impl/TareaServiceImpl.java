package com.grupo7.proyectoda.service.impl;

import com.grupo7.proyectoda.entity.Tarea;
import com.grupo7.proyectoda.exception.GeneralException;
import com.grupo7.proyectoda.exception.NoDataFoundException;
import com.grupo7.proyectoda.exception.ValidateException;
import com.grupo7.proyectoda.repository.TareaRepository;
import com.grupo7.proyectoda.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TareaServiceImpl implements TareaService {
    @Autowired
    private TareaRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Tarea> findAll(Pageable page) {
        try {
            List<Tarea> registros = repository.findAll(page).toList();
            return registros;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        } catch (GeneralException e) {
            throw new GeneralException("Error del servidorr");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tarea> findAll() {
        try {
            List<Tarea> registros = repository.findAll();
            return registros;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        } catch (GeneralException e) {
            throw new GeneralException("Error del servidorr");
        }
    }

    @Override
    public List<Tarea> findByTitulo(String titulo, Pageable page) {
        try {
            List<Tarea> registros = repository.findByTituloContaining(titulo, page);
            return registros;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        } catch (GeneralException e) {
            throw new GeneralException("Error del servidor");
        }
    }

    @Override
    public Tarea findById(int id) {
        try {
            Tarea registro = repository.findById(id)
                    .orElseThrow(() -> new NoDataFoundException("No existe un registro con ese id"));
            return registro;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        } catch (GeneralException e) {
            throw new GeneralException("Error del servidor");
        }
    }

    @Override
    public Tarea save(Tarea tarea) {
        try {
//            CategoriaValidator.save(categoria);

            if(tarea.getId() == 0) {
                Tarea nuevo = repository.save(tarea);
                return nuevo;
            }

            Tarea registro = repository.findById(tarea.getId())
                    .orElseThrow(() -> new NoDataFoundException("No existe un registro con ese id"));
            registro.setTitulo(tarea.getTitulo());
            registro.setDescripcion(tarea.getDescripcion());
            registro.setFechaInicio(tarea.getFechaInicio());
            registro.setFechaFin(tarea.getFechaFin());
            registro.setFechaLimite(tarea.getFechaLimite());
            repository.save(registro);

            return registro;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        } catch (GeneralException e) {
            throw new GeneralException("Error del servidor");
        }
    }

    @Override
    public void delete(int id) {

    }
}
