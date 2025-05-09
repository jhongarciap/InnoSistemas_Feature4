package com.InnoSistemas.Feature_4.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tblhistorialcorreos")
@Data
public class HistorialCorreo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial_correos", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_correo", referencedColumnName = "id_correo", nullable = false)
    @NotNull
    private Correo correo;

    @ManyToOne
    @JoinColumn(name = "id_correo_usuario", referencedColumnName = "id_correo_usuario", nullable = false)
    @NotNull
    private CorreoUsuario correoUsuario;

    @Column(name = "fecha_notificacion", nullable = false)
    private LocalDate fechaNotificacion;

    @Column(name = "hora_notificacion", nullable = false)
    private LocalTime horaNotificacion;
}
