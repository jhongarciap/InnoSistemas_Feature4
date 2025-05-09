package com.InnoSistemas.Feature_4.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="tblusuarios")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @NotNull
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento")
    @NotNull
    private TipoDocumento tipoDocumento;

    @ManyToOne
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo")
    @NotNull
    private Equipo equipo;

    @NotBlank
    @Column(name = "documento", nullable = false)
    private String documento;

    @NotBlank
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotBlank
    @Column(name = "apellido", nullable = false)
    private String apellido;

    @NotBlank
    @Column(name = "correo", nullable = false)
    private String correo;

    @NotBlank
    @Column(name = "numero", nullable = false)
    private String numero;

    @NotBlank
    @Column(name = "contraseña", nullable = false)
    private String contrasena;
}
