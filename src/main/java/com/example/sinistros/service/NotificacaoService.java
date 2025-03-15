package com.example.sinistros.service;

import com.example.sinistros.dto.NotificacaoDTO;
import com.example.sinistros.model.Notificacao;
import com.example.sinistros.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    // Método para converter Notificacao para NotificacaoDTO
    private NotificacaoDTO converterParaDTO(Notificacao notificacao) {
        return new NotificacaoDTO(
                notificacao.getIdNotificacoes(),
                notificacao.getMensagem(),
                notificacao.getDataNotificacao(),
                notificacao.getLida(),
                notificacao.getUsuario() != null ? notificacao.getUsuario().getIdUser() : null // Supondo que a entidade Usuario tem o método getIdUsuario()
        );
    }

    // Método para converter NotificacaoDTO para Notificacao
    private Notificacao converterParaEntidade(NotificacaoDTO notificacaoDTO) {
        Notificacao notificacao = new Notificacao();
        notificacao.setIdNotificacoes(notificacaoDTO.getIdNotificacoes());
        notificacao.setMensagem(notificacaoDTO.getMensagem());
        notificacao.setDataNotificacao(notificacaoDTO.getDataNotificacao());
        notificacao.setLida(notificacaoDTO.getLida());
        // Aqui, você pode buscar o usuário no banco de dados usando o usuarioId
        // Se você tem um serviço de Usuário, pode ser utilizado para recuperar o objeto Usuário
        return notificacao;
    }

    public List<NotificacaoDTO> listarNotificacoes() {
        return notificacaoRepository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public Optional<NotificacaoDTO> buscarNotificacaoPorId(Integer id) {
        return notificacaoRepository.findById(id).map(this::converterParaDTO);
    }

    public NotificacaoDTO criarNotificacao(NotificacaoDTO notificacaoDTO) {
        Notificacao notificacao = converterParaEntidade(notificacaoDTO);
        Notificacao notificacaoSalva = notificacaoRepository.save(notificacao);
        return converterParaDTO(notificacaoSalva);
    }

    public NotificacaoDTO atualizarNotificacao(Integer id, NotificacaoDTO notificacaoDTO) {
        notificacaoDTO.setIdNotificacoes(id);
        Notificacao notificacao = converterParaEntidade(notificacaoDTO);
        Notificacao notificacaoAtualizada = notificacaoRepository.save(notificacao);
        return converterParaDTO(notificacaoAtualizada);
    }

    public void deletarNotificacao(Integer id) {
        notificacaoRepository.deleteById(id);
    }
}
