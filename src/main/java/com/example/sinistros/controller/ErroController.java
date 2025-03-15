package com.example.sinistros.controller;

import com.example.sinistros.dto.ErroDTO;
import com.example.sinistros.service.ErroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/erros")
public class ErroController {

    @Autowired
    private ErroService erroService;

    @GetMapping
    public ResponseEntity<List<EntityModel<ErroDTO>>> listarErros() {
        List<EntityModel<ErroDTO>> erros = erroService.listarErros().stream()
                .map(erro -> EntityModel.of(erro,
                        WebMvcLinkBuilder.linkTo(methodOn(ErroController.class).buscarErroPorId(erro.getIdErro())).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(methodOn(ErroController.class).listarErros()).withRel("all-erros")))
                .collect(Collectors.toList());
        return ResponseEntity.ok(erros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ErroDTO>> buscarErroPorId(@PathVariable Integer id) {
        Optional<ErroDTO> erro = erroService.buscarErroPorId(id);
        return erro.map(value -> {
            EntityModel<ErroDTO> resource = EntityModel.of(value,
                    WebMvcLinkBuilder.linkTo(methodOn(ErroController.class).buscarErroPorId(id)).withSelfRel(),
                    WebMvcLinkBuilder.linkTo(methodOn(ErroController.class).listarErros()).withRel("all-erros"));
            return ResponseEntity.ok(resource);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EntityModel<ErroDTO>> criarErro(@RequestBody ErroDTO erroDTO) {
        ErroDTO novoErro = erroService.criarErro(erroDTO);
        EntityModel<ErroDTO> resource = EntityModel.of(novoErro,
                WebMvcLinkBuilder.linkTo(methodOn(ErroController.class).buscarErroPorId(novoErro.getIdErro())).withSelfRel());
        return ResponseEntity.status(HttpStatus.CREATED).body(resource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<ErroDTO>> atualizarErro(@PathVariable Integer id, @RequestBody ErroDTO erroDTO) {
        ErroDTO erroAtualizado = erroService.atualizarErro(id, erroDTO);
        EntityModel<ErroDTO> resource = EntityModel.of(erroAtualizado,
                WebMvcLinkBuilder.linkTo(methodOn(ErroController.class).buscarErroPorId(id)).withSelfRel());
        return ResponseEntity.ok(resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarErro(@PathVariable Integer id) {
        erroService.deletarErro(id);
        return ResponseEntity.noContent().build();
    }
}
