package com.example.sinistros.controller;

import com.example.sinistros.dto.AnalisePreditivaDTO;
import com.example.sinistros.model.AnalisePreditiva;
import com.example.sinistros.service.AnalisePreditivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/analises")
public class AnalisePreditivaController {

    @Autowired
    private AnalisePreditivaService analisePreditivaService;

    @GetMapping
    public List<EntityModel<AnalisePreditiva>> listar() {
        List<AnalisePreditiva> analises = analisePreditivaService.listarTodas();
        return analises.stream()
                .map(analise -> EntityModel.of(analise,
                        linkTo(methodOn(AnalisePreditivaController.class).buscarPorId(analise.getIdAnalise())).withSelfRel(),
                        linkTo(methodOn(AnalisePreditivaController.class).listar()).withRel("all-analises")))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<AnalisePreditiva>> buscarPorId(@PathVariable Integer id) {
        AnalisePreditiva analise = analisePreditivaService.buscarPorId(id);
        if (analise != null) {
            EntityModel<AnalisePreditiva> resource = EntityModel.of(analise,
                    linkTo(methodOn(AnalisePreditivaController.class).buscarPorId(id)).withSelfRel(),
                    linkTo(methodOn(AnalisePreditivaController.class).listar()).withRel("all-analises"));
            return ResponseEntity.ok(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<EntityModel<AnalisePreditiva>> criar(@RequestBody AnalisePreditivaDTO dto) {
        AnalisePreditiva analise = analisePreditivaService.salvar(dto);
        EntityModel<AnalisePreditiva> resource = EntityModel.of(analise,
                linkTo(methodOn(AnalisePreditivaController.class).buscarPorId(analise.getIdAnalise())).withSelfRel(),
                linkTo(methodOn(AnalisePreditivaController.class).listar()).withRel("all-analises"));
        return ResponseEntity.ok(resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        analisePreditivaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
