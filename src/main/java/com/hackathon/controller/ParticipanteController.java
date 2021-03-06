package com.hackathon.controller;

import com.hackathon.entity.Equipe;
import com.hackathon.entity.Hackathon;
import com.hackathon.entity.Participante;
import com.hackathon.service.EquipeService;
import com.hackathon.service.ParticipanteService;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/participante")
@CrossOrigin(origins = "*")
public class ParticipanteController {
    @Autowired
    private ParticipanteService participanteService;

    @Autowired
    private EquipeService equipeService;

    @GetMapping({"/", ""})
    public ResponseEntity index() {
        return new ResponseEntity<>(participanteService.getAll(), null, HttpStatus.OK);
    }

    @RequestMapping(value="/", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_UTF8_VALUE,produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity save(@RequestBody Participante participante){
        try {
            return new ResponseEntity<>(participanteService.save(participante), null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, null, HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/currentUser")
    public ResponseEntity getCurrentUser(Authentication auth) {
        String email = auth.getPrincipal().toString();
        Participante participante = participanteService.findByEmail(email);
        return new ResponseEntity<>(participante, null, HttpStatus.OK);
    }

    @GetMapping("/hackathons")
    public ResponseEntity getHackathons(Authentication auth){
        String email = auth.getPrincipal().toString();
        Participante participante = participanteService.findByEmail(email);
        List<Equipe> equipes = equipeService.getAll();
        List<Hackathon> hackathons = new ArrayList<Hackathon>();
        for (Equipe e : equipes) {
            if (e.getParticipantes().contains(participante))
                hackathons.add(e.getHackathon());
        }
        return new ResponseEntity<>(hackathons, null, HttpStatus.OK);
    }

    @GetMapping("/equipes")
    public ResponseEntity getEquipes(Authentication auth){
        String email = auth.getPrincipal().toString();
        Participante participante = participanteService.findByEmail(email);
        List<Equipe> equipes = equipeService.getAll();
        List<Equipe> desseParticipante = new ArrayList<Equipe>();
        for (Equipe e : equipes) {
            if (e.getParticipantes().contains(participante))
                desseParticipante.add(e);
        }
        return new ResponseEntity<>(desseParticipante, null, HttpStatus.OK);
    }


}
