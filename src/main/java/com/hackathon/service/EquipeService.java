package com.hackathon.service;

import com.hackathon.entity.Equipe;
import com.hackathon.entity.Hackathon;
import com.hackathon.entity.Participante;

import java.util.List;

public interface EquipeService {
    List<Equipe> getAll();
    List<Equipe> findByHackathon(Hackathon hackathon);
    Equipe save(Equipe equipe) throws Exception;
    Equipe find(int id);
    void cancelSubscription(Equipe equipe, Participante participante) throws Exception;
}
