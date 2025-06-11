package com.InnoSistemas.Feature_4.repository;

import com.InnoSistemas.Feature_4.entity.EventoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoUsuarioRepository extends JpaRepository<EventoUsuario, Integer> {
    List<EventoUsuario> findByUsuarioId(Integer id_usuario);

}