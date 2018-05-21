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

import java.util.ArrayList;
import java.util.Collections;
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
        List<Participante> toSave = new ArrayList<Participante>();
        for (Participante participante: equipe.getParticipantes()) {
            int occurrences = Collections.frequency(equipe.getParticipantes(), participante);
            if (occurrences > 1) {
                throw new Exception("Não é permitido cadastrar o mesmo participante mais de uma vez na mesma equipe.");
            } if(participante.getId() == null) {
                toSave.add(participante);
            } else if(estaNaHackathon(participante, findByHackathon(hackathon))) {
                throw new Exception("Um dos participantes já está em uma equipe nessa hackathon.");
            }
        }

        for (Participante p : toSave) {
            equipe.getParticipantes().remove(p);
            participanteService.save(p);
        }

        System.out.println(equipe.toString());

        equipe.setParticipando(true);
        return repository.save(equipe);
    }

    private boolean estaNaHackathon(Participante participante, List<Equipe> equipes) {
        for (Equipe equipe: equipes) {
            for (Participante p: equipe.getParticipantes()) {
                if(p.getId() == participante.getId() && equipe.isParticipando()) {
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

    @Override
    public void cancelSubscription(Equipe equipe, Participante participante) throws Exception {
        if(equipe.getParticipantes().contains(participante) && equipe.isParticipando()) {
            equipe.setParticipando(false);
            repository.save(equipe);
            return;
        }
        throw new Exception("Você não tem permissões para cancelar a inscrição.");
    }
}
