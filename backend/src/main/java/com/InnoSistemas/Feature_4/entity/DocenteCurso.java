package com.InnoSistemas.Feature_4.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "tbldocentexcurso")
@Data
public class DocenteCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_docente_curso", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso", nullable = false)
    @NotNull
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    @NotNull
    private Usuario usuario;
}
