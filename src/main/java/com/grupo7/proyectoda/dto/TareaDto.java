package com.grupo7.proyectoda.dto;

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
    private Date fechaInicio;
    private Date fechaFin;
    private Date fechaLimite;
}
