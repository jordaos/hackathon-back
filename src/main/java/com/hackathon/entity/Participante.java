package com.hackathon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Participante implements UserDetails {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String nome;
    @NotNull
    private String email;
    @NotNull
    private String password;
    private String foto;
    @NotNull
    private String telefone;
    @NotNull
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

    public Participante(Integer id, String nome, @NotNull String email, @NotNull String password, String foto, String telefone, String tamCamisa) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.password = password;
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

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

