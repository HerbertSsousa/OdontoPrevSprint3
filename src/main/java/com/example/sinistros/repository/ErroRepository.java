package com.example.sinistros.repository;


import com.example.sinistros.model.Erro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErroRepository extends JpaRepository<Erro, Integer> {
    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
    // Exemplo: List<Erro> findByUsuarioId(Integer usuarioId);
}
