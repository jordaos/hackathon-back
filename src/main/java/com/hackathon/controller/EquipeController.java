package com.hackathon.controller;

import com.hackathon.entity.Equipe;
import com.hackathon.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/equipe")
@CrossOrigin(origins = "*")
public class EquipeController {

    @Autowired
    private EquipeService equipeService;

    @GetMapping("/")
    public @ResponseBody
    List<Equipe> index() {
        return equipeService.getAll();
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
}
