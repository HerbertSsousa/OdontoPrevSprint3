package com.example.sinistros.service;

import com.example.sinistros.dto.FotoDTO;
import com.example.sinistros.model.Foto;
import com.example.sinistros.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FotoService {

    @Autowired
    private FotoRepository fotoRepository;

    // Método para converter Foto para FotoDTO
    private FotoDTO converterParaDTO(Foto foto) {
        return new FotoDTO(
                foto.getIdFotos(),
                foto.getCaminhoFoto(),
                foto.getDataEnvio(),
                foto.getUsuario() != null ? foto.getUsuario().getIdUser() : null // Supondo que a entidade Usuario tem o método getIdUsuario()
        );
    }

    // Método para converter FotoDTO para Foto
    private Foto converterParaEntidade(FotoDTO fotoDTO) {
        Foto foto = new Foto();
        foto.setIdFotos(fotoDTO.getIdFotos());
        foto.setCaminhoFoto(fotoDTO.getCaminhoFoto());
        foto.setDataEnvio(fotoDTO.getDataEnvio());
        // Aqui, você pode buscar o usuário no banco de dados usando o usuarioId
        // Se você tem um serviço de Usuário, pode ser utilizado para recuperar o objeto Usuário
        return foto;
    }

    public List<FotoDTO> listarFotos() {
        return fotoRepository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public Optional<FotoDTO> buscarFotoPorId(Integer id) {
        return fotoRepository.findById(id).map(this::converterParaDTO);
    }

    public FotoDTO criarFoto(FotoDTO fotoDTO) {
        Foto foto = converterParaEntidade(fotoDTO);
        Foto fotoSalva = fotoRepository.save(foto);
        return converterParaDTO(fotoSalva);
    }

    public FotoDTO atualizarFoto(Integer id, FotoDTO fotoDTO) {
        fotoDTO.setIdFotos(id);
        Foto foto = converterParaEntidade(fotoDTO);
        Foto fotoAtualizada = fotoRepository.save(foto);
        return converterParaDTO(fotoAtualizada);
    }

    public void deletarFoto(Integer id) {
        fotoRepository.deleteById(id);
    }
}
