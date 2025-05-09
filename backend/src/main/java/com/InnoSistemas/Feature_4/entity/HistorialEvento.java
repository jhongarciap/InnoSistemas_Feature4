package com.InnoSistemas.Feature_4.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tblhistorialevento")
@Data
public class HistorialEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial_eventos", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_evento", referencedColumnName = "id_evento", nullable = false)
    @NotNull
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    @NotNull
    private Usuario usuario;

    @Column(name = "fecha_notificacion", nullable = false)
    private LocalDate fechaNotificacion;

    @Column(name = "hora_notificacion", nullable = false)
    private LocalTime horaNotificacion;
}
