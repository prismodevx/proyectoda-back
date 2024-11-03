package com.grupo7.proyectoda.converter;

import com.grupo7.proyectoda.dto.TareaDto;
import com.grupo7.proyectoda.entity.Tarea;
import com.grupo7.proyectoda.entity.Usuario;
import com.grupo7.proyectoda.service.UsuarioService;
import org.springframework.stereotype.Component;

@Component
public class TareaConverter extends AbstractConverter<Tarea, TareaDto> {
    private final UsuarioService service;

    public TareaConverter(UsuarioService service) {
        this.service = service;
    }

    @Override
    public TareaDto fromEntity(Tarea entity) {
        if(entity == null) return null;

        return TareaDto.builder()
                .id(entity.getId())
                .titulo(entity.getTitulo())
                .descripcion(entity.getDescripcion())
                .usuarioId(entity.getUsuario().getId())
                .fechaInicio(entity.getFechaInicio())
                .fechaFin(entity.getFechaFin())
                .fechaLimite(entity.getFechaLimite())
                .build();
    }

    @Override
    public Tarea fromDto(TareaDto dto) {
        if(dto == null) return null;

        Usuario usuario = service.findById(dto.getUsuarioId());

        return Tarea.builder()
                .id(dto.getId())
                .titulo(dto.getTitulo())
                .descripcion(dto.getDescripcion())
                .usuario(usuario)
                .fechaInicio(dto.getFechaInicio())
                .fechaFin(dto.getFechaFin())
                .fechaLimite(dto.getFechaLimite())
                .build();
    }
}
