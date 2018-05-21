package com.hackathon.repository;

import com.hackathon.entity.Equipe;
import com.hackathon.entity.Hackathon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HackathonRepository extends JpaRepository<Hackathon, Integer> {

}
