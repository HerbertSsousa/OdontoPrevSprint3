package com.example.sinistros.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
public class FuncionarioDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String cargo;
    private Double salario;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) // Garante que o formato da data seja ISO (yyyy-MM-dd)
    private Date dataAdmissao;
    private String telefone;
    private String email;
}
