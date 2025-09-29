package com.example.parkapi.web.controller;

import com.example.parkapi.dto.UsuarioCreateDto;
import com.example.parkapi.dto.UsuarioResponseDto;
import com.example.parkapi.dto.UsuarioSenhaDto;
import com.example.parkapi.dto.mapper.UsuarioMapper;
import com.example.parkapi.entity.Usuario;
import com.example.parkapi.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService service;
    public  UsuarioController(UsuarioService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> create(@RequestBody UsuarioCreateDto createDto){
        Usuario user = service.salvar(UsuarioMapper.toUsuario(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> getById(@PathVariable("id") Long id){
        Usuario user = service.buscarPorId(id);
        return ResponseEntity.ok(UsuarioMapper.toDto(user));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassword(@PathVariable("id") Long id, @RequestBody UsuarioSenhaDto dto){
        service.editarSenha(id, dto.getSenhaAtual(), dto.getNovaSenha(), dto.getConfirmaSenha());
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> getAll(){
        return ResponseEntity.ok(UsuarioMapper.toListDto(service.buscarTodos()));
    }
}
