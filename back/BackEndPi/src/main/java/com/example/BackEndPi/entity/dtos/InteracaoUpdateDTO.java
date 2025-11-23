package com.example.BackEndPi.entity.dtos;

import com.example.BackEndPi.entity.TipoInteracao;
import jakarta.validation.constraints.NotNull;

public class InteracaoUpdateDTO {
    @NotNull(message = "Informe o id da interação.")
    public Long id;

    public Long usuarioId;
    public Long avaliacaoId;
    public TipoInteracao tipo;
    public String conteudo;
    public Long respostaAIntercaoId;
}
