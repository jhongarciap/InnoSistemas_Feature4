package com.InnoSistemas.Feature_4.repository;

import com.InnoSistemas.Feature_4.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
}
