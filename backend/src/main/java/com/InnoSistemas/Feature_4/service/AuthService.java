package com.InnoSistemas.Feature_4.service;

import com.InnoSistemas.Feature_4.dto.AuthRequest;
import com.InnoSistemas.Feature_4.dto.AuthResponse;
import com.InnoSistemas.Feature_4.dto.RegisterRequest;
import com.InnoSistemas.Feature_4.entity.*;
import com.InnoSistemas.Feature_4.repository.*;
import com.InnoSistemas.Feature_4.segurity.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getCorreo(), request.getContrasena())
        );

        var user = usuarioRepository.findByCorreo(request.getCorreo()).orElseThrow();
        String token = jwtUtil.generateToken(user);
        return new AuthResponse(token);
    }

    public AuthResponse register(RegisterRequest request) {
        Usuario user = new Usuario();
        user.setCorreo(request.getCorreo());
        user.setContrasena(passwordEncoder.encode(request.getContrasena()));
        user.setNombre(request.getNombre());
        user.setApellido(request.getApellido());
        user.setDocumento(request.getDocumento());
        user.setNumero(request.getNumero());

        user.setRol(rolRepository.findById(request.getIdRol())
                .orElseThrow(() -> new RuntimeException("Rol con ID " + request.getIdRol() + " no encontrado")));

        user.setTipoDocumento(tipoDocumentoRepository.findById(request.getIdTipoDocumento())
                .orElseThrow(() -> new RuntimeException("TipoDocumento con ID " + request.getIdTipoDocumento() + " no encontrado")));

        user.setEquipo(equipoRepository.findById(request.getIdEquipo())
                .orElseThrow(() -> new RuntimeException("Equipo con ID " + request.getIdEquipo() + " no encontrado")));

        usuarioRepository.save(user);

        String token = jwtUtil.generateToken(user);
        return new AuthResponse(token);
    }
}