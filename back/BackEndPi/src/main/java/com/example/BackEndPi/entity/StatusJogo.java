package com.example.BackEndPi.entity;

public enum StatusJogo {
    JOGADO("Jogado"),
    JOGANDO("Jogando"),
    ABANDONADO("Abandonado"),
    QUERO_JOGAR("Quero jogar");

    private final String descricao;

    StatusJogo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
