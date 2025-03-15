package com.example.sinistros.service;

import com.example.sinistros.dto.AnalisePreditivaDTO;
import com.example.sinistros.model.AnalisePreditiva;
import com.example.sinistros.repository.AnalisePreditivaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AnalisePreditivaService {

    @Autowired
    private AnalisePreditivaRepository analisePreditivaRepository;

    public List<AnalisePreditiva> listarTodas() {
        return analisePreditivaRepository.findAll();
    }

    public AnalisePreditiva buscarPorId(Integer id) {
        return analisePreditivaRepository.findById(id).orElse(null);
    }

    public AnalisePreditiva salvar(AnalisePreditivaDTO dto) {
        AnalisePreditiva analise = new AnalisePreditiva();
        analise.setResultadoAnalise(dto.getResultadoAnalise());
        analise.setFrequenciaSinistros(dto.getFrequenciaSinistros());
        // Aqui, você pode precisar buscar a entidade Foto pelo ID antes de definir
        // analise.setFoto(fotoRepository.findById(dto.getFotoId()).orElse(null));
        analise.setDataAnalise(dto.getDataAnalise());
        return analisePreditivaRepository.save(analise);
    }

    public void excluir(Integer id) {
        analisePreditivaRepository.deleteById(id);
    }
}
