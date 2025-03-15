package com.example.sinistros.repository;

import com.example.sinistros.model.AnalisePreditiva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalisePreditivaRepository extends JpaRepository<AnalisePreditiva, Integer> {
    // Métodos personalizados, se necessário
}
