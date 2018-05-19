package com.hackathon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Participante {
    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String email;
    private String foto;
    private String telefone;
    private String tamCamisa;

    public Participante() {
    }

    public Participante(Integer id, String nome, String email, String foto, String telefone, String tamCamisa) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.foto = foto;
        this.telefone = telefone;
        this.tamCamisa = tamCamisa;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTamCamisa() {
        return tamCamisa;
    }

    public void setTamCamisa(String tamCamisa) {
        this.tamCamisa = tamCamisa;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", foto='" + foto + '\'' +
                ", telefone='" + telefone + '\'' +
                ", tamCamisa='" + tamCamisa + '\'' +
                '}';
    }
}

