package com.example.sinistros.dto;

import com.example.sinistros.model.Foto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FotoDTO {

    private Integer idFotos;

    @NotBlank
    private String caminhoFoto;

    private LocalDate dataEnvio;

    private Integer usuarioId; // Usar ID para referência

    // Construtor que recebe a entidade Foto
    public FotoDTO(Foto foto) {
        this.idFotos = foto.getIdFotos();
        this.caminhoFoto = foto.getCaminhoFoto();
        this.dataEnvio = foto.getDataEnvio();
        this.usuarioId = foto.getUsuario().getIdUser(); // Assumindo que exista um método getIdUsuario()
    }
}
