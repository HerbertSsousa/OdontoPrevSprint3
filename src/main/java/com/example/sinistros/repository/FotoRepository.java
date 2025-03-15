package com.example.sinistros.repository;


import com.example.sinistros.model.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Integer> {
    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
    // Exemplo: List<Foto> findByUsuarioId(Integer usuarioId);
}
