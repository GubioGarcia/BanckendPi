package com.example.BackEndPi.entity;

public enum Categoria {
    ACAO("Ação"),
    AVENTURA("Aventura"),
    RPG("RPG"),
    RPG_DE_ACAO("RPG de Ação"),
    FPS("Tiro em Primeira Pessoa"),
    TPS("Tiro em Terceira Pessoa"),
    PLATAFORMA("Plataforma"),
    CORRIDA("Corrida"),
    ESPORTE("Esporte"),
    LUTA("Luta"),
    ESTRATEGIA("Estratégia"),
    RTS("Estratégia em Tempo Real"),
    TBS("Estratégia em Turnos"),
    SIMULACAO("Simulação"),
    SIMULADOR_DE_VIDA("Simulador de Vida"),
    SIMULADOR_DE_VOO("Simulador de Voo"),
    SIMULADOR_DE_CORRIDA("Simulador de Corrida"),
    SANDBOX("Mundo Aberto / Sandbox"),
    SOBREVIVENCIA("Sobrevivência"),
    TERROR("Terror / Horror"),
    FURTIVIDADE("Stealth / Furtividade"),
    PUZZLE("Puzzle / Quebra-Cabeça"),
    MUSICAL("Musical / Ritmo"),
    PARTY("Party / Multijogador Casual"),
    BATTLE_ROYALE("Battle Royale"),
    MOBA("MOBA"),
    MMORPG("MMORPG"),
    ROGUELIKE("Roguelike / Roguelite"),
    METROIDVANIA("Metroidvania"),
    HACK_AND_SLASH("Hack and Slash"),
    SHOOT_EM_UP("Shoot 'em Up / Bullet Hell"),
    VISUAL_NOVEL("Visual Novel"),
    POINT_AND_CLICK("Point and Click"),
    CARD_GAME("Cartas / Card Game"),
    BOARD_GAME("Tabuleiro / Board Game"),
    EDUCATIVO("Educativo"),
    CASUAL("Casual"),
    IDLE("Idle / Incremental"),
    PLATAFORMA_2D("Plataforma 2D"),
    PLATAFORMA_3D("Plataforma 3D"),
    CORRIDA_ARCADE("Corrida Arcade"),
    CORRIDA_REALISTA("Corrida Realista"),
    SURVIVAL_HORROR("Survival Horror"),
    SCI_FI("Ficção Científica"),
    FANTASIA("Fantasia"),
    HISTORICO("Histórico / Guerra"),
    INFANTIL("Infantil / Educacional"),
    TYCOON("Tycoon / Gestão"),
    BEAT_EM_UP("Beat 'em Up"),
    ARCADE_CLASSICO("Arcade Clássico");

    private final String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
