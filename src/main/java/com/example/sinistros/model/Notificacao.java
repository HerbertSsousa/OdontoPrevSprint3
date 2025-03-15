package com.example.sinistros.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "notificacoes")
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacoes")  // Nome exato da coluna no banco
    private Integer idNotificacoes;

    @NotBlank
    @Column(name = "mensagem", nullable = false, length = 50)
    private String mensagem;

    @Column(name = "data_notificacao", nullable = false)
    private LocalDate dataNotificacao;

    @Column(name = "lida", nullable = false)
    private int lida = 0;  // Utilizando Integer para mapear o valor 0 ou 1

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)  // Nome exato da coluna de chave estrangeira
    private Usuario usuario;

    public Notificacao(String mensagem, LocalDate dataNotificacao, Integer lida, Usuario usuario) {
        this.mensagem = mensagem;
        this.dataNotificacao = dataNotificacao;
        this.lida = lida;
        this.usuario = usuario;
    }

    public void setLida(Boolean lida) {
        return;
    }
}
