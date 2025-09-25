package com.example.parkapi.service.impl;


import com.example.parkapi.repository.UsuarioRepository;
import com.example.parkapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
}
