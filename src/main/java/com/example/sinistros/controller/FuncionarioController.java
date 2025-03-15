package com.example.sinistros.controller;

import com.example.sinistros.dto.FuncionarioDTO;
import com.example.sinistros.dto.UsuarioDTO;
import com.example.sinistros.model.Funcionario;
import com.example.sinistros.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;


    //////////////////////


    ///////////////////





    @GetMapping
    public List<EntityModel<Funcionario>> listar() {
        List<Funcionario> funcionarios = funcionarioService.listarTodos();
        return funcionarios.stream()
                .map(funcionario -> EntityModel.of(funcionario,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(FuncionarioController.class).buscarPorId(funcionario.getId())).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(FuncionarioController.class).listar()).withRel("funcionarios")))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Funcionario>> buscarPorId(@PathVariable Long id) {
        Funcionario funcionario = funcionarioService.buscarPorId(id);
        if (funcionario == null) {
            return ResponseEntity.notFound().build();
        }
        EntityModel<Funcionario> resource = EntityModel.of(funcionario,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(FuncionarioController.class).buscarPorId(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(FuncionarioController.class).listar()).withRel("funcionarios"));
        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<Funcionario> criar(@RequestBody FuncionarioDTO dto) {
        Funcionario funcionario = funcionarioService.salvar(dto);
        return ResponseEntity.ok(funcionario);
    }


    @PostMapping("/salvar")
    public String salvarFuncionario(@ModelAttribute FuncionarioDTO funcionarioDTO) {
        if (funcionarioDTO.getId() != null) {
          //  FuncionarioService.atualizarUsuario(funcionarioDTO.getIdUser(), usuarioDTO);
        } else {
            funcionarioService.salvar(funcionarioDTO);
        }
        return "redirect:/"; // Redireciona para a lista de usuários
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        funcionarioService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
