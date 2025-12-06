package com.example.BackEndPi.entity.dtos;

import com.example.BackEndPi.entity.TipoInteracao;
import jakarta.validation.constraints.NotNull;

public class InteracaoDTO {
    @NotNull(message = "Informe o id do usuário.")
    public Long usuarioId;

    @NotNull(message = "Informe o id da avaliação.")
    public Long avaliacaoId;

    @NotNull(message = "Informe o tipo de interação. Podendo ser 'CURTIDA', 'COMENTARIO' ou 'RESPOSTA'.")
    public TipoInteracao tipo;

    @NotNull(message = "Informe o contéudo de sua interação.")
    public String conteudo;

    public Long respostaAIntercaoId;
}
