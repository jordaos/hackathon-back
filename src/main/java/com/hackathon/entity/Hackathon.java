package com.hackathon.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Hackathon {
    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String descricao;
    private String local;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date data;
    private int numEquipes;
    private int numParticipantesEquipe;

    public Hackathon() {
    }

    public Hackathon(Integer id, String nome, String descricao, String local, Date data, int numEquipes, int numParticipantesEquipe) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.local = local;
        this.data = data;
        this.numEquipes = numEquipes;
        this.numParticipantesEquipe = numParticipantesEquipe;
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumEquipes() {
        return numEquipes;
    }

    public void setNumEquipes(int numEquipes) {
        this.numEquipes = numEquipes;
    }

    public int getNumParticipantesEquipe() {
        return numParticipantesEquipe;
    }

    public void setNumParticipantesEquipe(int numParticipantesEquipe) {
        this.numParticipantesEquipe = numParticipantesEquipe;
    }

    @Override
    public String toString() {
        return "Hackathon{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", local='" + local + '\'' +
                ", data=" + data +
                ", numEquipes=" + numEquipes +
                ", numParticipantesEquipe=" + numParticipantesEquipe +
                '}';
    }
}
