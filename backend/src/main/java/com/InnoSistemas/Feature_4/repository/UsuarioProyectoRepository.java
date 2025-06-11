package com.InnoSistemas.Feature_4.repository;
import com.InnoSistemas.Feature_4.entity.Proyecto;
import com.InnoSistemas.Feature_4.entity.UsuarioProyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioProyectoRepository extends JpaRepository<UsuarioProyecto, Integer> {
    List<UsuarioProyecto> findByProyecto(Proyecto proyecto);
}
