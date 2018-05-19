package com.hackathon.controller;

import com.hackathon.entity.Equipe;
import com.hackathon.entity.Hackathon;
import com.hackathon.service.EquipeService;
import com.hackathon.service.HackathonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hackathon")
@CrossOrigin(origins = "*")
public class HackathonController {

    @Autowired
    private HackathonService hackathonService;

    @Autowired
    private EquipeService equipeService;

    @GetMapping("/")
    public @ResponseBody
    List<Hackathon> index() {
        return hackathonService.getAll();
    }

    @RequestMapping(value="/", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity save(@RequestBody Hackathon hackathon){
        return new ResponseEntity<>(hackathonService.save(hackathon), null, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Hackathon hackathon){
        hackathonService.delete(hackathon);
        return new ResponseEntity<>(null, null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity find(@PathVariable("id") int id){
        Hackathon hackathon = hackathonService.find(id);
        return new ResponseEntity<>(hackathon, null, HttpStatus.OK);
    }

    @GetMapping("/{id}/equipes")
    public ResponseEntity getEquipes(@PathVariable("id") int id){
        Hackathon hackathon = hackathonService.find(id);
        List<Equipe> equipes = equipeService.findByHackathon(hackathon);
        return new ResponseEntity<>(equipes, null, HttpStatus.OK);
    }
}
