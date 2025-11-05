package com.example.BackEndPi.entity.dtos;

import jakarta.validation.constraints.*;

public class UsuarioLoginDTO {
    @NotBlank(message = "Email é obrigatório.")
    @Email(message = "Email inválido.")
    public String email;

    @NotBlank(message = "Senha é obrigatória.")
    public String senha;
}
