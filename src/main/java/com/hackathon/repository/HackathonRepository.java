package com.hackathon.repository;

import com.hackathon.entity.Hackathon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HackathonRepository extends JpaRepository<Hackathon, Integer> {
}
