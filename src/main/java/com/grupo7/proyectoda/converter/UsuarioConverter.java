package com.grupo7.proyectoda.converter;

import com.grupo7.proyectoda.dto.UsuarioDto;
import com.grupo7.proyectoda.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter extends AbstractConverter<Usuario, UsuarioDto> {
    @Override
    public UsuarioDto fromEntity(Usuario entity) {
        if(entity == null) return null;

        return UsuarioDto.builder()
                .id(entity.getId())
                .alias(entity.getAlias())
                .email(entity.getEmail())
                .avatar(entity.getAvatar())
                .build();
    }

    @Override
    public Usuario fromDto(UsuarioDto dto) {
        if(dto == null) return null;

        return Usuario.builder()
                .id(dto.getId())
                .alias(dto.getAlias())
                .email(dto.getEmail())
                .avatar(dto.getAvatar())
                .build();
    }
}
