package com.example.parkapi.web.controller;

import com.example.parkapi.entity.Usuario;
import com.example.parkapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
        Usuario user = service.salvar(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();
        return ResponseEntity.created(uri).body(user);
    }
}
