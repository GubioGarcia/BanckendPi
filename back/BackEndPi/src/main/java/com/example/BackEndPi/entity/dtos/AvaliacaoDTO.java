package com.example.BackEndPi.entity.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class AvaliacaoDTO {
    @NotNull(message = "Informe o id do usuário.")
    public Long usuarioId;

    @NotNull(message = "Informe o id do jogo.")
    public Long jogoId;

    @NotNull(message = "Informe a nota para o jogo.")
    @Min(0)
    @Max(10)
    public int nota;

    @NotNull(message = "Informe o título para a resenha.")
    public String tituloResenha;

    @NotNull(message = "Informe o texto para a resenha.")
    public String textoResenha;
}
