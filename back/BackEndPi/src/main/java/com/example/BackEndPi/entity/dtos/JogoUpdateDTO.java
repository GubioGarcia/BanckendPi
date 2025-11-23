package com.example.BackEndPi.entity.dtos;

import com.example.BackEndPi.entity.Categoria;
import com.example.BackEndPi.entity.Desenvolvedora;
import com.example.BackEndPi.entity.Plataforma;
import jakarta.validation.constraints.NotNull;

public class JogoUpdateDTO {
    @NotNull(message = "Id é obrigatório.")
    public Long id;

    @NotNull(message = "Título é obrigatória.")
    public String titulo;

    @NotNull(message = "Informe plataforma.")
    public Plataforma plataforma;

    @NotNull(message = "Informe a categoria.")
    public Categoria categoria;

    @NotNull(message = "Informe a desenvolvedora.")
    public Desenvolvedora desenvolvedora;

    public int anoLancamento;
    public String capaUrl;
}
