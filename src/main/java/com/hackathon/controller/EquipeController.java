package com.hackathon.controller;

import com.hackathon.entity.Equipe;
import com.hackathon.entity.Participante;
import com.hackathon.service.EquipeService;
import com.hackathon.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/equipe")
@CrossOrigin(origins = "*")
public class EquipeController {

    @Autowired
    private EquipeService equipeService;

    @Autowired
    private ParticipanteService participanteService;

    @GetMapping({"/", ""})
    public ResponseEntity index() {
        return new ResponseEntity<>(equipeService.getAll(), null, HttpStatus.OK);
    }

    @RequestMapping(value="/", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_UTF8_VALUE,produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity save(@RequestBody Equipe equipe){
        try {
            return new ResponseEntity<>(equipeService.save(equipe), null, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity find(@PathVariable("id") int id){
        Equipe equipe = equipeService.find(id);
        return new ResponseEntity<>(equipe, null, HttpStatus.OK);
    }

    @GetMapping("/{id}/participantes")
    public ResponseEntity getParticipantes(@PathVariable("id") int id){
        Equipe equipe = equipeService.find(id);
        return new ResponseEntity<>(equipe.getParticipantes(), null, HttpStatus.OK);
    }

    @GetMapping("/{id}/cancelar")
    public ResponseEntity cancelInscricao(
            @PathVariable("id") int id,
            Authentication auth
    ){
        try {
            String email = auth.getPrincipal().toString();
            Participante participante = participanteService.findByEmail(email);
            Equipe equipe = equipeService.find(id);
            equipeService.cancelSubscription(equipe, participante);
            return new ResponseEntity<>(equipe, null, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.CONFLICT);
        }
    }
}
