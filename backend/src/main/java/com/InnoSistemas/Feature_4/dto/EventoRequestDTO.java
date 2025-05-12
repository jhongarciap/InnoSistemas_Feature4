package com.InnoSistemas.Feature_4.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class EventoRequestDTO {
    private String nombre;
    private LocalDate fecha;
    private LocalTime hora;
    private String descripcion;
    private Boolean realizado;
    private Integer idPrioridad;
    private Integer idEquipo;
    private Integer idProyecto;
    private Integer idCurso;
    private Integer idTipoEvento;
}
