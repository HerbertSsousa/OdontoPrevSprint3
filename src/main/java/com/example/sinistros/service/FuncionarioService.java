package com.example.sinistros.service;

import com.example.sinistros.dto.FuncionarioDTO;
import com.example.sinistros.model.Funcionario;
import com.example.sinistros.model.Usuario;
import com.example.sinistros.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarPorId(Long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }

    public Funcionario salvar(FuncionarioDTO dto) {
        Funcionario funcionario = new Funcionario();
        Long newId = funcionarioRepository.getLastUserId();
        funcionario.setId(newId+1);
        funcionario.setNome(dto.getNome());
        funcionario.setCpf(dto.getCpf());
        funcionario.setCargo(dto.getCargo());
        funcionario.setSalario(dto.getSalario());
        funcionario.setDataAdmissao(dto.getDataAdmissao());
        funcionario.setTelefone(dto.getTelefone());
        funcionario.setEmail(dto.getEmail());
        return funcionarioRepository.save(funcionario);
    }

    public void excluir(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
