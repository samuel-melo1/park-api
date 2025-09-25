package com.example.parkapi.service.impl;


import com.example.parkapi.entity.Usuario;
import com.example.parkapi.repository.UsuarioRepository;
import com.example.parkapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    @Override
    @Transactional
    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }
}
