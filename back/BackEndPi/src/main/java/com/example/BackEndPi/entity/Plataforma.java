package com.example.BackEndPi.entity;

public enum Plataforma {
    PC("PC"),
    PLAYSTATION_5("PlayStation 5"),
    PLAYSTATION_4("PlayStation 4"),
    PLAYSTATION_3("PlayStation 3"),
    XBOX_SERIES_X_S("Xbox Series X/S"),
    XBOX_ONE("Xbox One"),
    XBOX_360("Xbox 360"),
    NINTENDO_SWITCH("Nintendo Switch"),
    NINTENDO_WII_U("Nintendo Wii U"),
    NINTENDO_3DS("Nintendo 3DS"),
    NINTENDO_DS("Nintendo DS"),
    PLAYSTATION_VITA("PlayStation Vita"),
    PSP("PlayStation Portable"),
    NINTENDO_WII("Nintendo Wii"),
    ANDROID("Android"),
    IOS("iOS"),
    STADIA("Stadia"),
    STEAM_DECK("Steam Deck"),
    ATARI("Atari 2600"),
    SUPER_NINTENDO("Super Nintendo (SNES)");

    private final String descricao;

    Plataforma(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
