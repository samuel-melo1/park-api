package com.example.parkapi.service.impl;


import com.example.parkapi.entity.Usuario;
import com.example.parkapi.repository.UsuarioRepository;
import com.example.parkapi.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
    public UsuarioServiceImpl(UsuarioRepository repository){
        this.repository = repository;
    }

    @Override
    @Transactional
    public Usuario salvar(Usuario request) {
        return repository.save(request);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado"));
    }

    @Override
    @Transactional
    public Usuario editarSenha(Long id, String senhaAtual, String novaSenha, String confirmaSenha) {
        if (!novaSenha.equals(confirmaSenha)){
            throw new RuntimeException("Nova senha não confere com confirmação de senha.");
        }

        Usuario user = buscarPorId(id);
        if (!user.getPassword().equals(senhaAtual)){
            throw new RuntimeException("Sua senha não confere");
        }

        user.setPassword(novaSenha);
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos() {
        return repository.findAll();
    }
}
