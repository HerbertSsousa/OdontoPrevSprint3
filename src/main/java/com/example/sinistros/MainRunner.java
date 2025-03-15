//package com.example.sinistros;
//
//import com.example.sinistros.Procedure.UsuarioDAO;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MainRunner implements ApplicationRunner {
//
//    private final UsuarioDAO usuarioDAO;
//
//    public MainRunner(UsuarioDAO usuarioDAO) {
//        this.usuarioDAO = usuarioDAO;
//    }
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        // Inserindo dois usuários
//        usuarioDAO.inserirUsuario(1, "thales Silva", "12345678901", "senha123");
//        usuarioDAO.inserirUsuario(2, "Maria Oliveira", "10987654321", "senha456");
//
//        // Atualizando os dois usuários
//        usuarioDAO.atualizarUsuario(1, "thales S.", "12345678901", "novaSenha123");
//        usuarioDAO.atualizarUsuario(2, "Maria O.", "10987654321", "novaSenha456");
//
//        // Deletando os dois usuários
//        usuarioDAO.deletarUsuario(1);
//        usuarioDAO.deletarUsuario(2);
//    }
//}
