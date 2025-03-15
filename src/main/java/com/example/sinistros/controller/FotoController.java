package com.example.sinistros.controller;

import com.example.sinistros.dto.FotoDTO;
import com.example.sinistros.service.FotoService;
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
@RequestMapping("/fotos")
public class FotoController {

    @Autowired
    private FotoService fotoService;

    @GetMapping
    public ResponseEntity<List<EntityModel<FotoDTO>>> listarFotos() {
        List<EntityModel<FotoDTO>> fotos = fotoService.listarFotos().stream()
                .map(foto -> EntityModel.of(foto,
                        WebMvcLinkBuilder.linkTo(methodOn(FotoController.class).buscarFotoPorId(foto.getIdFotos())).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(methodOn(FotoController.class).listarFotos()).withRel("all-fotos")))
                .collect(Collectors.toList());
        return ResponseEntity.ok(fotos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<FotoDTO>> buscarFotoPorId(@PathVariable Integer id) {
        Optional<FotoDTO> foto = fotoService.buscarFotoPorId(id);
        return foto.map(value -> {
            EntityModel<FotoDTO> resource = EntityModel.of(value,
                    WebMvcLinkBuilder.linkTo(methodOn(FotoController.class).buscarFotoPorId(id)).withSelfRel(),
                    WebMvcLinkBuilder.linkTo(methodOn(FotoController.class).listarFotos()).withRel("all-fotos"));
            return ResponseEntity.ok(resource);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EntityModel<FotoDTO>> criarFoto(@RequestBody FotoDTO fotoDTO) {
        FotoDTO novaFoto = fotoService.criarFoto(fotoDTO);
        EntityModel<FotoDTO> resource = EntityModel.of(novaFoto,
                WebMvcLinkBuilder.linkTo(methodOn(FotoController.class).buscarFotoPorId(novaFoto.getIdFotos())).withSelfRel());
        return ResponseEntity.status(HttpStatus.CREATED).body(resource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<FotoDTO>> atualizarFoto(@PathVariable Integer id, @RequestBody FotoDTO fotoDTO) {
        FotoDTO fotoAtualizada = fotoService.atualizarFoto(id, fotoDTO);
        EntityModel<FotoDTO> resource = EntityModel.of(fotoAtualizada,
                WebMvcLinkBuilder.linkTo(methodOn(FotoController.class).buscarFotoPorId(id)).withSelfRel());
        return ResponseEntity.ok(resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFoto(@PathVariable Integer id) {
        fotoService.deletarFoto(id);
        return ResponseEntity.noContent().build();
    }
}
