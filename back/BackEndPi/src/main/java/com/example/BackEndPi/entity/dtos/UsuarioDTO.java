package com.example.BackEndPi.entity.dtos;

import jakarta.validation.constraints.*;

public class UsuarioDTO {
    @NotBlank(message = "Senha é obrigatória.")
    public String nome;

    @NotBlank(message = "Email é obrigatório.")
    @Email(message = "Email inválido.")
    public String email;

    @NotBlank(message = "Senha é obrigatória.")
    public String senha;

    public String bio;
}
