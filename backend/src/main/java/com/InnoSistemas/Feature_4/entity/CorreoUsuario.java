package com.InnoSistemas.Feature_4.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "tblcorreosxusuario")
@Data
public class CorreoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_correo_usuario", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_correo", referencedColumnName = "id_correo", nullable = false)
    @NotNull
    private Correo correo;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    @NotNull
    private Usuario usuario;
}
