package com.example.sinistros.dto;

import com.example.sinistros.model.Erro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErroDTO {
    private Integer idErro;
    private Integer usuarioId;

    @NotBlank
    private String mensagem;

    private LocalDate dataOcorrencia;

    public ErroDTO(Erro erro) {
        this.idErro = erro.getIdErro();
        this.usuarioId = erro.getUsuario().getIdUser(); // Assumindo que exista um método getIdUsuario()
        this.mensagem = erro.getMensagem();
        this.dataOcorrencia = erro.getDataOcorrencia();
    }
}
