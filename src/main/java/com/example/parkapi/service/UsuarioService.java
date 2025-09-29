package com.example.parkapi.service;

import com.example.parkapi.entity.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario salvar(Usuario request);
    Usuario buscarPorId(Long id);
    Usuario editarSenha(Long id, String senhaAtual, String novaSenha, String confirmaSenha);
    List<Usuario> buscarTodos();
}
