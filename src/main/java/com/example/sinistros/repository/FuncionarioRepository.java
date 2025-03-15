package com.example.sinistros.repository;

import com.example.sinistros.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    // Métodos personalizados, se necessário
    @Query("SELECT COALESCE(MAX(u.id), 0) as Id from Funcionario u")
    Long getLastUserId();
}
