package com.hackathon.service;

import com.hackathon.entity.Equipe;
import com.hackathon.entity.Participante;

import java.util.List;

public interface ParticipanteService {
    List<Participante> getAll();
    Participante save(Participante participante) throws Exception;
    Participante findByNomeOrEmail(String nome, String email);
    Participante findByEmail(String email);
    Participante find(int id);
}
