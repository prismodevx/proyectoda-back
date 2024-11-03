package com.grupo7.proyectoda.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDto {
    private int id;
    private String alias;
    private String email;
    private String avatar;
}
