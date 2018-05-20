package com.hackathon.repository;

import com.hackathon.entity.Participante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipanteRepository extends JpaRepository<Participante, Integer> {
    Participante findAllByNomeOrEmail(String nome, String email);
    Participante findByEmail(String email);
}
