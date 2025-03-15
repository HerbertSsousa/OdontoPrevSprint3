package com.example.sinistros.controller;

import com.example.sinistros.dto.UsuarioDTO;
import com.example.sinistros.dto.FuncionarioDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/usuarios/form")
    public String exibirFormularioUsuario(Model model) {
        model.addAttribute("usuario", new UsuarioDTO()); //
        return "form";
    }

    @GetMapping("/funcionarios/form")
    public String exibirFormularioFuncionario(Model model) {
        model.addAttribute("funcionario", new FuncionarioDTO()); //
        return "funcionario";
    }

}
