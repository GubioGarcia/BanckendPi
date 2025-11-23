package com.example.BackEndPi.entity.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class AvaliacaoUpdateDTO {
    @NotNull(message = "Informe o id da resenha.")
    public Long id;

    public Long usuarioId;
    public Long jogoId;
    public String tituloResenha;
    public String textoResenha;

    @Min(0)
    @Max(10)
    public int nota;
}
