package com.example.sinistros.repository;


import com.example.sinistros.model.Processo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Integer> {
    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
    // Exemplo: List<Processo> findByUsuarioId(Integer usuarioId);
}
