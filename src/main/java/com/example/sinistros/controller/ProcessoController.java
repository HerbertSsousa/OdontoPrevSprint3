package com.example.sinistros.controller;

import com.example.sinistros.dto.ProcessoDTO;
import com.example.sinistros.service.ProcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/processo")
public class ProcessoController {

    @Autowired
    private ProcessoService processoService;

    @GetMapping
    public ResponseEntity<List<ProcessoDTO>> listarProcessos() {
        List<ProcessoDTO> processos = processoService.listarProcessos();
        return ResponseEntity.ok(processos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcessoDTO> buscarProcessoPorId(@PathVariable Integer id) {
        Optional<ProcessoDTO> processo = processoService.buscarProcessoPorId(id);
        return processo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProcessoDTO> criarProcesso(@RequestBody ProcessoDTO processoDTO) {
        ProcessoDTO novoProcesso = processoService.criarProcesso(processoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProcesso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProcessoDTO> atualizarProcesso(@PathVariable Integer id, @RequestBody ProcessoDTO processoDTO) {
        ProcessoDTO processoAtualizado = processoService.atualizarProcesso(id, processoDTO);
        return ResponseEntity.ok(processoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProcesso(@PathVariable Integer id) {
        processoService.deletarProcesso(id);
        return ResponseEntity.noContent().build();
    }
}
