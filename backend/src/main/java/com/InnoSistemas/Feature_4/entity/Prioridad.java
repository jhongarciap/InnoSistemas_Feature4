package com.InnoSistemas.Feature_4.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "tblprioridades")
@Data
public class Prioridad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prioridad", nullable = false)
    private Integer id;

    @NotBlank
    @Column(name = "prioridad", nullable = false)
    private String prioridad;
}
