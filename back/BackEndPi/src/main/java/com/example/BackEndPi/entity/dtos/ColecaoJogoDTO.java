package com.example.BackEndPi.entity.dtos;

import com.example.BackEndPi.entity.StatusJogo;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ColecaoJogoDTO {
    @NotNull(message = "Informe o Id do usuário.")
    public Long usuarioId;

    @NotNull(message = "Informe o Id do jogo.")
    public Long jogoId;

    @NotNull(message = "Informe o status.")
    public StatusJogo status;

    public LocalDate dataInicio;
    public LocalDate dataFim;
}
