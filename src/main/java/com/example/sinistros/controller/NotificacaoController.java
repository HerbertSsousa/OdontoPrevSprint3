package com.example.sinistros.controller;

import com.example.sinistros.dto.NotificacaoDTO;
import com.example.sinistros.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController {

    @Autowired
    private NotificacaoService notificacaoService;

    @GetMapping
    public ResponseEntity<List<NotificacaoDTO>> listarNotificacoes() {
        List<NotificacaoDTO> notificacoes = notificacaoService.listarNotificacoes();
        return ResponseEntity.ok(notificacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacaoDTO> buscarNotificacaoPorId(@PathVariable Integer id) {
        Optional<NotificacaoDTO> notificacao = notificacaoService.buscarNotificacaoPorId(id);
        return notificacao.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<NotificacaoDTO> criarNotificacao(@RequestBody NotificacaoDTO notificacaoDTO) {
        NotificacaoDTO novaNotificacao = notificacaoService.criarNotificacao(notificacaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaNotificacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificacaoDTO> atualizarNotificacao(@PathVariable Integer id, @RequestBody NotificacaoDTO notificacaoDTO) {
        NotificacaoDTO notificacaoAtualizada = notificacaoService.atualizarNotificacao(id, notificacaoDTO);
        return ResponseEntity.ok(notificacaoAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarNotificacao(@PathVariable Integer id) {
        notificacaoService.deletarNotificacao(id);
        return ResponseEntity.noContent().build();
    }
}
