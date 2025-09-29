package com.example.parkapi.dto.mapper;

import com.example.parkapi.dto.UsuarioCreateDto;
import com.example.parkapi.dto.UsuarioResponseDto;
import com.example.parkapi.dto.UsuarioSenhaDto;
import com.example.parkapi.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


public class UsuarioMapper {

    public static Usuario toUsuario(UsuarioCreateDto createDto){
        return new ModelMapper().map(createDto, Usuario.class);
    }

    public static UsuarioResponseDto toDto(Usuario usuario){
        String role = usuario.getRole().name().substring("ROLE_".length());
        PropertyMap<Usuario, UsuarioResponseDto> props = new PropertyMap<Usuario, UsuarioResponseDto>() {
            @Override
            protected void configure() {
                map().setRole(role);
            }
        };
        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(props);
        return mapper.map(usuario, UsuarioResponseDto.class);
    }

    public static List<UsuarioResponseDto> toListDto(List<Usuario> usuarios){
        return usuarios.stream()
                .map(usuario -> toDto(usuario))
                .collect(Collectors.toList());
    }
}
