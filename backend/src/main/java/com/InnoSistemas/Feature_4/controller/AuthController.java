package com.InnoSistemas.Feature_4.controller;

import com.InnoSistemas.Feature_4.dto.AuthRequest;
import com.InnoSistemas.Feature_4.dto.AuthResponse;
import com.InnoSistemas.Feature_4.dto.RegisterRequest;
import com.InnoSistemas.Feature_4.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }
}

