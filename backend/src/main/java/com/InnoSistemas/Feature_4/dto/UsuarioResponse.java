package com.InnoSistemas.Feature_4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioResponse {
    private Integer id;
    private String nombre;
    private String apellido;
    private String correo;
    private String rol;
    private String equipo;
}