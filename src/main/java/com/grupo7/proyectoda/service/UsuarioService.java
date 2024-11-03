package com.grupo7.proyectoda.service;

import com.grupo7.proyectoda.entity.Usuario;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UsuarioService {
    public List<Usuario> findAll(Pageable page);
    public List<Usuario> findAll();
    public Usuario findById(int id);
    public Usuario save(Usuario registro);
}
