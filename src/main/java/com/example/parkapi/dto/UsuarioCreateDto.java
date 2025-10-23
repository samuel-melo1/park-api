package com.example.parkapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioCreateDto {

    @NotBlank
    @Email(regexp = "^[a-z0-9.+-]+@[a-z0-9.-]+\\.[a-z]{2,}$",message = "Formato do e-mail está inválido")
    private String username;
    @NotBlank
    @Size(min = 6, max = 6)
    private String password;
    public UsuarioCreateDto(){}
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}
