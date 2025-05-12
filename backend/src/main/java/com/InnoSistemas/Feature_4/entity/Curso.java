package com.InnoSistemas.Feature_4.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "tblcursos")
@Data
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso", nullable = false)
    private Integer id;

    @NotBlank
    @Column(name = "curso", nullable = false)
    private String curso;

    @NotBlank
    @Column(name = "descripcion_curso", nullable = false)
    private String descripcionCurso;
}
