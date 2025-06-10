package com.InnoSistemas.Feature_4.service;

import com.InnoSistemas.Feature_4.dto.NotificationDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class NotificationService {
    private final Map<Integer, SseEmitter> emitters = new ConcurrentHashMap<>();

    // Añadir un emisor (frontend se conecta aquí)
    public SseEmitter subscribe(Integer usuarioId) {
        SseEmitter emitter = new SseEmitter(3600000L); // 1 hora de timeout
        emitters.put(usuarioId, emitter);

        emitter.onCompletion(() -> emitters.remove(usuarioId));
        emitter.onTimeout(() -> emitters.remove(usuarioId));

        return emitter;
    }

    // Enviar notificación a un usuario específico
    public void sendNotification(Integer usuarioId, NotificationDTO notification) {
        SseEmitter emitter = emitters.get(usuarioId);
        if (emitter != null) {
            try {
                emitter.send(notification);
            } catch (IOException e) {
                emitters.remove(usuarioId);
            }
        }
    }
}