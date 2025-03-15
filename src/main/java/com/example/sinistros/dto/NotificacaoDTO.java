package com.example.sinistros.dto;

import com.example.sinistros.model.Notificacao;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificacaoDTO extends RepresentationModel<NotificacaoDTO> {

    private Integer idNotificacoes;

    @NotBlank
    private String mensagem;

    private LocalDate dataNotificacao;

    private Boolean lida;

    private Integer usuarioId; // Usar ID para referência

    // Construtor com Notificacao
    public NotificacaoDTO(Notificacao notificacao) {
        this.idNotificacoes = notificacao.getIdNotificacoes();
        this.mensagem = notificacao.getMensagem();
        this.dataNotificacao = notificacao.getDataNotificacao();
        this.lida = notificacao.getLida() == 1; // Convertendo 0/1 para Boolean
        this.usuarioId = notificacao.getUsuario().getIdUser(); // Supondo que a classe Usuario tem o método getId()

        // Adicionando links HATEOAS
        this.add(Link.of("/notificacoes/" + this.idNotificacoes).withSelfRel());
        this.add(Link.of("/notificacoes").withRel("all-notificacoes"));
        // Adicione mais links conforme necessário
    }

    public NotificacaoDTO(Integer idNotificacoes, String mensagem, LocalDate dataNotificacao, int lida, Integer usuarioId) {
    }
}
