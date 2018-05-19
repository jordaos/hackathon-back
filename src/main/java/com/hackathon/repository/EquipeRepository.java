package com.hackathon.repository;

import com.hackathon.entity.Equipe;
import com.hackathon.entity.Hackathon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe, Integer> {
    List<Equipe> findAllByHackathon(Hackathon hackathon);
}
