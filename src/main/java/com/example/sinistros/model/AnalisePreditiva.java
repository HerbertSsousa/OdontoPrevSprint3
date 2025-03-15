package com.example.sinistros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "analise_preditiva")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnalisePreditiva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAnalise;

    @Column(name = "resultado_analise", nullable = false)
    private String resultadoAnalise;

    @Column(name = "frequencia_sinistros", nullable = false)
    private Integer frequenciaSinistros;

    @OneToOne
    @JoinColumn(name = "foto_id", nullable = false)
    private Foto foto;

    @Column(name = "data_analise", nullable = false)
    private LocalDate dataAnalise;

    // Método de processamento de imagem para aptidão
    public String processarImagemParaAptidao() {
        return "Apto";
    }

    // Método de previsão de frequência de sinistros
    public int preverFrequenciaSinistros() {
        return 5; // Simulação de resultado de modelo ML
    }
}
