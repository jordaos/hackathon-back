package com.hackathon.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Equipe {
    @Id
    @GeneratedValue
    private Integer id;
    private String nome;

    @ManyToOne
    private Hackathon hackathon;

    @OneToMany
    private List<Participante> participantes;

    public Equipe() {
    }

    public Equipe(Integer id, String nome, Hackathon hackathon, List<Participante> participantes) {
        this.id = id;
        this.nome = nome;
        this.hackathon = hackathon;
        this.participantes = participantes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Hackathon getHackathon() {
        return hackathon;
    }

    public void setHackathon(Hackathon hackathon) {
        this.hackathon = hackathon;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }
}
