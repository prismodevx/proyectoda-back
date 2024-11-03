package com.grupo7.proyectoda.dto;

import com.grupo7.proyectoda.entity.Usuario;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TareaDto {
    private int id;
    private String titulo;
    private String descripcion;
    private int usuarioId;
    private Date fechaInicio;
    private Date fechaFin;
    private Date fechaLimite;
}
