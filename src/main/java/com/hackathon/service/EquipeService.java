package com.hackathon.service;

import com.hackathon.entity.Equipe;
import com.hackathon.entity.Hackathon;

import java.util.List;

public interface EquipeService {
    List<Equipe> getAll();
    List<Equipe> findByHackathon(Hackathon hackathon);
    Equipe save(Equipe equipe) throws Exception;
    Equipe find(int id);
}
