package com.example.sinistros.dto;

import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

public class UsuarioDTO extends RepresentationModel<UsuarioDTO> {

    private Integer idUser;
    private String nome;
    private String cpf;
    private String senha;
    private LocalDate dataCriacao;

    // Getters and Setters

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
