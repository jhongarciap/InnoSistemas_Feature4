package com.InnoSistemas.Feature_4.controller;

import com.InnoSistemas.Feature_4.dto.EventoRequestDTO;
import com.InnoSistemas.Feature_4.entity.Evento;
import com.InnoSistemas.Feature_4.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @PostMapping("/registrar")
    public ResponseEntity<Evento> registrarEvento(@RequestBody EventoRequestDTO dto) {
        Evento nuevoEvento = eventoService.registrarEvento(dto);
        return ResponseEntity.ok(nuevoEvento);
    }
}
