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

    @GetMapping("/")
    public @ResponseBody List<Participante> index() {
        return participanteService.getAll();
    }

    @RequestMapping(value="/", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_UTF8_VALUE,produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity save(@RequestBody Participante participante){
        if(participanteService.findByNomeOrEmail(participante.getNome(), participante.getEmail()) != null) {
            return new ResponseEntity<>(participanteService.save(participante), null, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, null, HttpStatus.CONFLICT);
    }

    @GetMapping("/hackathons")
    public ResponseEntity get(Authentication auth){
        Participante participante = (Participante) auth.getPrincipal();
        List<Equipe> equipes = equipeService.getAll();
        List<Hackathon> hackathons = new ArrayList<Hackathon>();
        for (Equipe e: equipes) {
            if(e.getParticipantes().contains(participante))
                hackathons.add(e.getHackathon());
        }
        return new ResponseEntity<>(hackathons, null, HttpStatus.OK);
    }


}
