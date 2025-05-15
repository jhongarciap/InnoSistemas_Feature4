package com.InnoSistemas.Feature_4.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String correo;
    private String contrasena;
    private String nombre;
    private String apellido;
    private String documento;
    private String numero;
    private Integer idRol;
    private Integer idTipoDocumento;
    private Integer idEquipo;
}
