package com.hackathon.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Equipe {
    @Id
    @GeneratedValue
    private Integer id;
    private String nome;

    @ManyToMany
    private List<Participante> participantes;

    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date data;

    @ManyToOne
    private Hackathon hackathon;

    @Column(columnDefinition="tinyint(1) default 1")
    private boolean participando;

    public Equipe() {
    }

    public Equipe(Integer id, String nome, List<Participante> participantes, Date data, Hackathon hackathon, boolean participando) {
        this.id = id;
        this.nome = nome;
        this.participantes = participantes;
        this.data = data;
        this.hackathon = hackathon;
        this.participando = participando;
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

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public boolean isParticipando() {
        return participando;
    }

    public void setParticipando(boolean participando) {
        this.participando = participando;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Hackathon getHackathon() {
        return hackathon;
    }

    public void setHackathon(Hackathon hackathon) {
        this.hackathon = hackathon;
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", participantes=" + participantes +
                ", data=" + data +
                ", participando=" + participando +
                '}';
    }
}
