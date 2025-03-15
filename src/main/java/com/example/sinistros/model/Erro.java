package com.example.sinistros.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "erros")
@Data
@NoArgsConstructor
public class Erro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idErro;

    @NotBlank
    @Column(name = "mensagem", nullable = false)
    private String mensagem;

    @Column(name = "data_ocorrencia", nullable = false)
    private LocalDate dataOcorrencia;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Construtor adicional para facilitar instância
    public Erro(String mensagem, LocalDate dataOcorrencia, Usuario usuario) {
        this.mensagem = mensagem;
        this.dataOcorrencia = dataOcorrencia;
        this.usuario = usuario;
    }
}
