package com.InnoSistemas.Feature_4.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "tblproyectos")
@Data
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyecto", nullable = false)
    private Integer id;

    @NotBlank
    @Column(name = "proyecto", nullable = false)
    private String proyecto;

    @NotBlank
    @Column(name = "descripcion_proyecto", nullable = false)
    private String descripcion;
}
