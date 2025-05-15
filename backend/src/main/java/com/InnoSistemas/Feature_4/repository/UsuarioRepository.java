package com.InnoSistemas.Feature_4.repository;

import com.InnoSistemas.Feature_4.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
