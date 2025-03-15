package com.example.sinistros.controller;

import com.example.sinistros.dto.UsuarioDTO;
import com.example.sinistros.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        List<UsuarioDTO> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepresentationModel<UsuarioDTO>> buscarUsuarioPorId(@PathVariable Integer id) {
        Optional<UsuarioDTO> usuario = usuarioService.buscarUsuarioPorId(id);
        return usuario.map(this::criarUsuarioComLinks)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO novoUsuario = usuarioService.criarUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable Integer id, @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioAtualizado = usuarioService.atualizarUsuario(id, usuarioDTO);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Integer id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    private RepresentationModel<UsuarioDTO> criarUsuarioComLinks(UsuarioDTO usuarioDTO) {
        RepresentationModel<UsuarioDTO> resource = new RepresentationModel<>(usuarioDTO.getLinks());
        resource.add(Link.of("/usuarios/" + usuarioDTO.getIdUser(), "self"));
        resource.add(Link.of("/usuarios", "listar"));
        resource.add(Link.of("/usuarios/" + usuarioDTO.getIdUser(), "atualizar"));
        resource.add(Link.of("/usuarios/" + usuarioDTO.getIdUser(), "deletar"));
        return resource;
    }


    @PostMapping("/salvar")
    public String salvarUsuario(@ModelAttribute UsuarioDTO usuarioDTO) {
        if (usuarioDTO.getIdUser() != null) {
            usuarioService.atualizarUsuario(usuarioDTO.getIdUser(), usuarioDTO);
        } else {
            usuarioService.criarUsuario(usuarioDTO);
        }
        return "redirect:"; // Redireciona para a lista de usuários
    }

}
