package com.hackathon.service;

import com.hackathon.entity.Participante;

import java.util.List;

public interface ParticipanteService {
    List<Participante> getAll();
    Participante save(Participante participante);
    Participante findByNomeOrEmail(String nome, String email);
    Participante find(int id);
}
