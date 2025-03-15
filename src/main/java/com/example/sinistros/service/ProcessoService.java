package com.example.sinistros.service;

import com.example.sinistros.dto.ProcessoDTO;
import com.example.sinistros.model.Processo;
import com.example.sinistros.model.Usuario; // Certifique-se de ter a classe Usuario
import com.example.sinistros.repository.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProcessoService {

    @Autowired
    private ProcessoRepository processoRepository;

    // Aqui você pode precisar de um serviço de Usuário, se você quiser buscar o usuário
    // @Autowired
    // private UsuarioService usuarioService;

    // Método para converter Processo para ProcessoDTO
    private ProcessoDTO converterParaDTO(Processo processo) {
        return new ProcessoDTO(
                processo.getIdProcesso(),
                processo.getUsuario() != null ? processo.getUsuario().getIdUser() : null, // Supondo que a entidade Usuario tem o método getIdUsuario()
                processo.getAnaliseId(),
                processo.getDataAnalise()
        );
    }

    // Método para converter ProcessoDTO para Processo
    private Processo converterParaEntidade(ProcessoDTO processoDTO) {
        Processo processo = new Processo();
        processo.setIdProcesso(processoDTO.getIdProcesso());
        processo.setAnaliseId(processoDTO.getAnaliseId());
        processo.setDataAnalise(processoDTO.getDataAnalise());

        // Aqui, você pode buscar o usuário no banco de dados usando o usuarioId
        // Se você tem um serviço de Usuário, pode ser utilizado para recuperar o objeto Usuário
        // Usuario usuario = usuarioService.buscarUsuarioPorId(processoDTO.getUsuarioId());
        // processo.setUsuario(usuario);

        return processo;
    }

    public List<ProcessoDTO> listarProcessos() {
        return processoRepository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public Optional<ProcessoDTO> buscarProcessoPorId(Integer id) {
        return processoRepository.findById(id).map(this::converterParaDTO);
    }

    public ProcessoDTO criarProcesso(ProcessoDTO processoDTO) {
        Processo processo = converterParaEntidade(processoDTO);
        Processo processoSalvo = processoRepository.save(processo);
        return converterParaDTO(processoSalvo);
    }

    public ProcessoDTO atualizarProcesso(Integer id, ProcessoDTO processoDTO) {
        processoDTO.setIdProcesso(id);
        Processo processo = converterParaEntidade(processoDTO);
        Processo processoAtualizado = processoRepository.save(processo);
        return converterParaDTO(processoAtualizado);
    }

    public void deletarProcesso(Integer id) {
        processoRepository.deleteById(id);
    }
}
