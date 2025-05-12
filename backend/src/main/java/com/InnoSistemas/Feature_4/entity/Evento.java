package com.InnoSistemas.Feature_4.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="tbleventos")
@Data
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_evento", nullable=false)
    private Integer id;

    @NotBlank
    @Column(name="nombre_evento", nullable=false)
    private String nombre;

    @JsonFormat(pattern = "yyyy-MM-dd")  // Formato de fecha
    @Column(name="fecha_evento", nullable=false)
    private LocalDate fecha;

    @JsonFormat(pattern = "HH:mm:ss")  // Formato de hora
    @Column(name="hora_evento", nullable=false)
    private LocalTime hora;

    @NotBlank
    @Column(name="descripcion_evento", nullable=false)
    private String descripcion;

    @NotNull
    @Column(name="evento_realizado", nullable=false)
    private Boolean realizado;

    @ManyToOne
    @JoinColumn(name = "id_prioridad", referencedColumnName = "id_prioridad")
    @NotNull
    private Prioridad prioridad;

    @ManyToOne
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo")
    @NotNull
    private Equipo equipo;

    @ManyToOne
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
    @NotNull
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso")
    @NotNull
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "tipo_evento", referencedColumnName = "id_tipo_evento")
    @NotNull
    private TipoEvento tipoEvento;
}
