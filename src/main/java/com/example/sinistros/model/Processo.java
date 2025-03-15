package com.example.sinistros.model;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "processo")
public class Processo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProcesso;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "analise_id", nullable = false)
    private Integer analiseId;

    @Column(name = "data_analise", nullable = false)
    private LocalDate dataAnalise;

    // Construtor padrão
    public Processo() {
    }

    // Construtor com parâmetros
    public Processo(Usuario usuario, Integer analiseId, LocalDate dataAnalise) {
        this.usuario = usuario;
        this.analiseId = analiseId;
        this.dataAnalise = dataAnalise;
    }

    // Getters e Setters
    public Integer getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(Integer idProcesso) {
        this.idProcesso = idProcesso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getAnaliseId() {
        return analiseId;
    }

    public void setAnaliseId(Integer analiseId) {
        this.analiseId = analiseId;
    }

    public LocalDate getDataAnalise() {
        return dataAnalise;
    }

    public void setDataAnalise(LocalDate dataAnalise) {
        this.dataAnalise = dataAnalise;
    }
}
