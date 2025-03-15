package com.example.sinistros.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "fotos")
@Data
@NoArgsConstructor
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFotos;

    @NotBlank
    @Column(name = "caminho_foto", nullable = false)
    private String caminhoFoto;

    @Column(name = "data_envio", nullable = false)
    private LocalDate dataEnvio;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Construtor com parâmetros
    public Foto(String caminhoFoto, LocalDate dataEnvio, Usuario usuario) {
        this.caminhoFoto = caminhoFoto;
        this.dataEnvio = dataEnvio;
        this.usuario = usuario;
    }
}
