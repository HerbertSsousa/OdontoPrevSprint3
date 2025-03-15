package com.example.sinistros.service;

import com.example.sinistros.dto.UsuarioDTO;
import com.example.sinistros.model.Usuario;
import com.example.sinistros.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public Optional<UsuarioDTO> buscarUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id).map(this::converterParaDTO);
    }


    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        Integer newId = usuarioRepository.getLastUserId();
        usuario.setIdUser(newId+1);
        usuario.setNome(usuarioDTO.getNome());
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setDataCriacao(LocalDate.now());

        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return converterParaDTO(usuarioSalvo);
    }

    public UsuarioDTO atualizarUsuario(Integer id, UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        usuario.setNome(usuarioDTO.getNome());
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setDataCriacao(LocalDate.now());

        Usuario usuarioAtualizado = usuarioRepository.save(usuario);
        return converterParaDTO(usuarioAtualizado);
    }

    public void deletarUsuario(Integer id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        usuarioRepository.delete(usuario);
    }

    private UsuarioDTO converterParaDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setIdUser(usuario.getIdUser());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setCpf(usuario.getCpf());
        usuarioDTO.setSenha(usuario.getSenha());
        usuarioDTO.setDataCriacao(usuario.getDataCriacao());
        return usuarioDTO;
    }
}
