package com.example.sinistros.Procedure;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class UsuarioDAO {

    private final DataSource dataSource;

    @Autowired
    public UsuarioDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void inserirUsuario(int idUser, String nome, String cpf, String senha) {
        String sql = "{CALL inserir_usuario(?, ?, ?, ?)}";

        try (Connection conn = dataSource.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idUser);
            stmt.setString(2, nome);
            stmt.setString(3, cpf);
            stmt.setString(4, senha);

            stmt.execute();
            System.out.println("Usuário inserido com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir usuário: " + e.getMessage());
        }
    }

    public void atualizarUsuario(int idUser, String nome, String cpf, String senha) {
        String sql = "{CALL atualizar_usuario(?, ?, ?, ?)}";

        try (Connection conn = dataSource.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idUser);
            stmt.setString(2, nome);
            stmt.setString(3, cpf);
            stmt.setString(4, senha);

            stmt.execute();
            System.out.println("Usuário atualizado com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
        }
    }

    public void deletarUsuario(int idUser) {
        String sql = "{CALL deletar_usuario(?)}";

        try (Connection conn = dataSource.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idUser);

            stmt.execute();
            System.out.println("Usuário deletado com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao deletar usuário: " + e.getMessage());
        }
    }
}
