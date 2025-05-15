package com.InnoSistemas.Feature_4.controller;

import com.InnoSistemas.Feature_4.dto.UsuarioResponse;
import com.InnoSistemas.Feature_4.entity.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/protegido")
public class ProtegidoController {

    @GetMapping("/saludo")
    public String saludo() {
        return "Accediste a un endpoint protegido con JWT válido";
    }

    @GetMapping("/usuario")
    public ResponseEntity<UsuarioResponse> obtenerUsuarioAutenticado(Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();

        UsuarioResponse dto = new UsuarioResponse(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getCorreo(),
                usuario.getRol().getRol(),
                usuario.getEquipo().getEquipo()
        );

        return ResponseEntity.ok(dto);
    }
}



