package com.grupo7.proyectoda.service.impl;

import com.grupo7.proyectoda.entity.Tarea;
import com.grupo7.proyectoda.entity.Usuario;
import com.grupo7.proyectoda.exception.GeneralException;
import com.grupo7.proyectoda.exception.NoDataFoundException;
import com.grupo7.proyectoda.exception.ValidateException;
import com.grupo7.proyectoda.repository.UsuarioRepository;
import com.grupo7.proyectoda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll(Pageable page) {
        try {
            List<Usuario> registros = repository.findAll(page).toList();
            return registros;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        } catch (GeneralException e) {
            throw new GeneralException("Error del servidorr");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        try {
            List<Usuario> registros = repository.findAll();
            return registros;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        } catch (GeneralException e) {
            throw new GeneralException("Error del servidorr");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findById(int id) {
        try {
            Usuario registro = repository.findById(id)
                    .orElseThrow(() -> new NoDataFoundException("No existe un registro con ese id"));
            return registro;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        } catch (GeneralException e) {
            throw new GeneralException("Error del servidor");
        }
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        try {
//            CategoriaValidator.save(categoria);

            if(usuario.getId() == 0) {
                Usuario nuevo = repository.save(usuario);
                return nuevo;
            }

            Usuario registro = repository.findById(usuario.getId())
                    .orElseThrow(() -> new NoDataFoundException("No existe un registro con ese id"));
            registro.setAlias(usuario.getAlias());
            registro.setEmail(usuario.getEmail());
            registro.setPassword(usuario.getPassword());
            registro.setAvatar(usuario.getAvatar());
            repository.save(registro);

            return registro;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        } catch (GeneralException e) {
            throw new GeneralException("Error del servidor");
        }
    }
}
