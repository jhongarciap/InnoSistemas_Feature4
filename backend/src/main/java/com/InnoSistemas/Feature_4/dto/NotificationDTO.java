package com.InnoSistemas.Feature_4.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class NotificationDTO {
    private String mensaje;
    private LocalDateTime fecha;
    private String tipo; // "evento", "alerta", etc.
    private Integer usuarioId; // ID del usuario destinatario
}