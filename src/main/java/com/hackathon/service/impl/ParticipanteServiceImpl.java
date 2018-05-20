package com.hackathon.service.impl;

import com.hackathon.entity.Participante;
import com.hackathon.repository.ParticipanteRepository;
import com.hackathon.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipanteServiceImpl implements ParticipanteService {
    @Autowired
    private ParticipanteRepository repository;

    @Override
    public List<Participante> getAll() {
        return repository.findAll();
    }

    @Override
    public Participante save(Participante participante) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        participante.setPassword(encoder.encode("12345"));
        return repository.save(participante);
    }

    @Override
    public Participante findByNomeOrEmail(String nome, String email) {
        return repository.findAllByNomeOrEmail(nome, email);
    }

    @Override
    public Participante find(int id) {
        return repository.findById(id).get();
    }
}
