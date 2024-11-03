package com.grupo7.proyectoda.repository;

import com.grupo7.proyectoda.entity.Usuario;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByAlias(String alias, Pageable pageable);
}
