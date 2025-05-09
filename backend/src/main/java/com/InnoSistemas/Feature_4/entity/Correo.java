package com.InnoSistemas.Feature_4.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "tblcorreos")
@Data
public class Correo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_correo", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_usuario_envia", referencedColumnName = "id_usuario", nullable = false)
    @NotNull
    private Usuario usuarioEnvia;

    @NotBlank
    @Column(name = "asunto", nullable = false)
    private String asunto;

    @NotBlank
    @Column(name = "informacion_correo", nullable = false)
    private String informacionCorreo;

    @ManyToOne
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso", nullable = false)
    @NotNull
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto", nullable = false)
    @NotNull
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo", nullable = false)
    @NotNull
    private Equipo equipo;
}
