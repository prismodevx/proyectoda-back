package com.grupo7.proyectoda.converter;

import com.grupo7.proyectoda.dto.TareaDto;
import com.grupo7.proyectoda.entity.Tarea;
import org.springframework.stereotype.Component;

@Component
public class TareaConverter extends AbstractConverter<Tarea, TareaDto> {
    @Override
    public TareaDto fromEntity(Tarea entity) {
        if(entity == null) return null;

        return TareaDto.builder()
                .id(entity.getId())
                .titulo(entity.getTitulo())
                .descripcion(entity.getDescripcion())
                .fechaInicio(entity.getFechaInicio())
                .fechaFin(entity.getFechaFin())
                .fechaLimite(entity.getFechaLimite())
                .build();
    }

    @Override
    public Tarea fromDto(TareaDto dto) {
        if(dto == null) return null;

        return Tarea.builder()
                .id(dto.getId())
                .titulo(dto.getTitulo())
                .descripcion(dto.getDescripcion())
                .fechaInicio(dto.getFechaInicio())
                .fechaFin(dto.getFechaFin())
                .fechaLimite(dto.getFechaLimite())
                .build();
    }
}
