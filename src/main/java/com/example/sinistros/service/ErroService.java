package com.example.sinistros.service;

import com.example.sinistros.dto.ErroDTO;
import com.example.sinistros.model.Erro;
import com.example.sinistros.repository.ErroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ErroService {

    @Autowired
    private ErroRepository erroRepository;

    // Método para converter Erro para ErroDTO
    private ErroDTO converterParaDTO(Erro erro) {
        return new ErroDTO(
                erro.getIdErro(),
                erro.getUsuario() != null ? erro.getUsuario().getIdUser() : null, // Supondo que a entidade Usuario tem o método getIdUsuario()
                erro.getMensagem(),
                erro.getDataOcorrencia()
        );
    }

    // Método para converter ErroDTO para Erro
    private Erro converterParaEntidade(ErroDTO erroDTO) {
        Erro erro = new Erro();
        erro.setIdErro(erroDTO.getIdErro());
        erro.setMensagem(erroDTO.getMensagem());
        erro.setDataOcorrencia(erroDTO.getDataOcorrencia());
        // Aqui, você pode buscar o usuário no banco de dados usando o usuarioId
        // Se você tem um serviço de Usuário, pode ser utilizado para recuperar o objeto Usuário
        return erro;
    }

    public List<ErroDTO> listarErros() {
        return erroRepository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public Optional<ErroDTO> buscarErroPorId(Integer id) {
        return erroRepository.findById(id).map(this::converterParaDTO);
    }

    public ErroDTO criarErro(ErroDTO erroDTO) {
        Erro erro = converterParaEntidade(erroDTO);
        Erro erroSalvo = erroRepository.save(erro);
        return converterParaDTO(erroSalvo);
    }

    public ErroDTO atualizarErro(Integer id, ErroDTO erroDTO) {
        erroDTO.setIdErro(id);
        Erro erro = converterParaEntidade(erroDTO);
        Erro erroAtualizado = erroRepository.save(erro);
        return converterParaDTO(erroAtualizado);
    }

    public void deletarErro(Integer id) {
        erroRepository.deleteById(id);
    }
}
