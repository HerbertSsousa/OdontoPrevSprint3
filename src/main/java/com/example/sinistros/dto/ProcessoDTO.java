package com.example.sinistros.dto;

import com.example.sinistros.model.Processo;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcessoDTO extends RepresentationModel<ProcessoDTO> {

    private Integer idProcesso;

    private Integer usuarioId; // Usar ID para referência

    @NotNull
    private Integer analiseId; // Referência para análise

    private LocalDate dataAnalise;

    // Construtor com Processo
    public ProcessoDTO(Processo processo) {
        this.idProcesso = processo.getIdProcesso();
        this.usuarioId = processo.getUsuario().getIdUser(); // Supondo que a classe Usuario tem o método getId()
        this.analiseId = processo.getAnaliseId();
        this.dataAnalise = processo.getDataAnalise();

        // Adicionando links HATEOAS
        this.add(Link.of("/processo/" + this.idProcesso).withSelfRel());
        this.add(Link.of("/processo").withRel("all-processos"));
        // Adicione mais links conforme necessário
    }
}
