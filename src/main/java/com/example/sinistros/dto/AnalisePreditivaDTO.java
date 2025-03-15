package com.example.sinistros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnalisePreditivaDTO {
    private Integer idAnalise;
    private String resultadoAnalise;
    private Integer frequenciaSinistros;
    private Long fotoId; // Supondo que você tenha um ID para a foto
    private LocalDate dataAnalise;
}
