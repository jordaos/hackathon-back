package com.hackathon.service;

import com.hackathon.entity.Equipe;
import com.hackathon.entity.Hackathon;

import java.util.List;

public interface HackathonService {
    List<Hackathon> getAll();
    Hackathon save(Hackathon hackathon);
    Hackathon find(int id);
    Hackathon encerrar(Hackathon hackathon);
    void delete(Hackathon hackathon);
}
