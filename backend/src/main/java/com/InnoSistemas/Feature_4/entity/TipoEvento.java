package com.InnoSistemas.Feature_4.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "tbltiposeventos")
@Data
public class TipoEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_evento", nullable = false)
    private Integer id;

    @NotBlank
    @Column(name = "tipo_evento", nullable = false)
    private String tipo;
}
