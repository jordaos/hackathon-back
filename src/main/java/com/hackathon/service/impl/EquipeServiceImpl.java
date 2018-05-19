package com.hackathon.service.impl;

import com.hackathon.entity.Equipe;
import com.hackathon.entity.Hackathon;
import com.hackathon.entity.Participante;
import com.hackathon.repository.EquipeRepository;
import com.hackathon.repository.HackathonRepository;
import com.hackathon.repository.ParticipanteRepository;
import com.hackathon.service.EquipeService;
import com.hackathon.service.HackathonService;
import com.hackathon.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeServiceImpl implements EquipeService{

    @Autowired
    private EquipeRepository repository;

    @Autowired
    private ParticipanteService participanteService;

    @Autowired
    private HackathonService hackathonService;

    @Override
    public List<Equipe> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Equipe> findByHackathon(Hackathon hackathon) {
        return repository.findAllByHackathon(hackathon);
    }

    @Override
    public Equipe save(Equipe equipe) throws Exception{
        Hackathon hackathon = hackathonService.find(equipe.getHackathon().getId());
        for (Participante participante: equipe.getParticipantes()) {
            if(participante.getId() == null) {
                Participante aux = participanteService.save(participante);
                equipe.getParticipantes().remove(participante);
                equipe.getParticipantes().add(aux);
            } else if(estaNaHackathon(participante, findByHackathon(hackathon))) {
                throw new Exception("Participante já está em uma equipe nessa hackathon.");
            }
        }
        return repository.save(equipe);
    }

    private boolean estaNaHackathon(Participante participante, List<Equipe> equipes) {
        System.out.println("------------------");
        for (Equipe equipe: equipes) {
            for (Participante p: equipe.getParticipantes()) {
                System.out.println(p.toString());
                System.out.println(participante.toString());
                if(p.getId() == participante.getId()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Equipe find(int id) {
        return repository.findById(id).get();
    }
}
