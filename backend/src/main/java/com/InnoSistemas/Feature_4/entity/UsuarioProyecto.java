package com.InnoSistemas.Feature_4.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "tblusuariosxproyecto")
@Data
public class UsuarioProyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuarios_proyecto", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto", nullable = false)
    @NotNull
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    @NotNull
    private Usuario usuario;
}
