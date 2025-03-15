package com.example.sinistros.repository;


import com.example.sinistros.model.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Integer> {
    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
    // Exemplo: List<Notificacao> findByUsuarioId(Integer usuarioId);
}
