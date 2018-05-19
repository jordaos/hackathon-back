package com.hackathon.service.impl;

import com.hackathon.entity.Hackathon;
import com.hackathon.repository.HackathonRepository;
import com.hackathon.service.HackathonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HackathonServiceImpl implements HackathonService{

    @Autowired
    private HackathonRepository repository;

    @Override
    public List<Hackathon> getAll() {
        return repository.findAll();
    }

    @Override
    public Hackathon save(Hackathon hackathon) {
        return repository.save(hackathon);
    }

    @Override
    public Hackathon find(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(Hackathon hackathon) {
        repository.delete(hackathon);
    }
}
