package com.example.BackEndPi.entity.dtos;

import com.example.BackEndPi.entity.StatusJogo;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ColecaoJogoUpdateDTO {
    @NotNull(message = "Informe o Id da coleção de jogos.")
    public Long id;

    public Long usuarioId;
    public Long jogoId;
    public StatusJogo status;
    public LocalDate dataInicio;
    public LocalDate dataFim;
}
