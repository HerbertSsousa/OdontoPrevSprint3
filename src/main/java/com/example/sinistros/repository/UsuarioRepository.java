package com.example.sinistros.repository;

import com.example.sinistros.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT COALESCE(MAX(u.idUser), 0) as Id from Usuario u")
    Integer getLastUserId();
}
