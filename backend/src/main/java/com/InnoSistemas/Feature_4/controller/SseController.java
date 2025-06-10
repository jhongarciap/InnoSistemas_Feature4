package com.InnoSistemas.Feature_4.controller;


import com.InnoSistemas.Feature_4.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/api/notificaciones")
public class SseController {

    @Autowired
    private NotificationService notificationService;

    // Endpoint para que el frontend se suscriba
    @GetMapping("/suscripcion/{usuarioId}")
    public SseEmitter subscribe(@PathVariable Integer usuarioId) {
        return notificationService.subscribe(usuarioId);
    }
}
