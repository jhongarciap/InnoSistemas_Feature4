package com.InnoSistemas.Feature_4.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class EventoHistorialResponseDTO {
    private String nombre;
    private String descripcion;
    private LocalDate fecha;
    private LocalTime hora;
    private String equipo;
    private String proyecto;
    private String curso;
    private String tipo;
}