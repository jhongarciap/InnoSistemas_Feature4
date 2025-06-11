package com.InnoSistemas.Feature_4.controller;

import com.InnoSistemas.Feature_4.dto.EventoHistorialResponseDTO;
import com.InnoSistemas.Feature_4.dto.EventoRequestDTO;
import com.InnoSistemas.Feature_4.entity.Evento;
import com.InnoSistemas.Feature_4.entity.Usuario;
import com.InnoSistemas.Feature_4.repository.UsuarioRepository;
import com.InnoSistemas.Feature_4.segurity.JwtUtil;
import com.InnoSistemas.Feature_4.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/registrar")
    public ResponseEntity<Evento> registrarEvento(@RequestBody EventoRequestDTO dto) {
        Evento nuevoEvento = eventoService.registrarEvento(dto);
        return ResponseEntity.ok(nuevoEvento);
    }

    @GetMapping("/historial")
    public ResponseEntity<List<EventoHistorialResponseDTO>> obtenerHistorial(
            @RequestHeader("Authorization") String authHeader) {

        // 1. Extrae el token (remueve "Bearer ")
        String token = authHeader.substring(7);

        // 2. Extrae el correo del token JWT
        String correo = jwtUtil.extractUsername(token);

        // 3. Busca el usuario por correo
        Usuario usuario = usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        // 4. Obtiene los eventos por ID de usuario
        List<EventoHistorialResponseDTO> historial = eventoService.obtenerEventosPorUsuario(usuario.getId());

        return ResponseEntity.ok(historial);
    }
}
