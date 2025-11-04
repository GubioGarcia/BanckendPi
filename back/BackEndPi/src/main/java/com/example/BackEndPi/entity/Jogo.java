package com.example.BackEndPi.entity;

import jakarta.persistence.*;

@Entity
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String titulo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Plataforma plataforma;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column(nullable = false, length = 4)
    private int anoLancamento;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Desenvolvedora desenvolvedora;

    @Column(nullable = false, length = 255)
    private String capaUrl;

    public Jogo() {
    }

    public Jogo(Long id, String titulo, Plataforma plataforma, Categoria categoria, int anoLancamento, Desenvolvedora desenvolvedora, String capaUrl) {
        this.id = id;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.categoria = categoria;
        this.anoLancamento = anoLancamento;
        this.desenvolvedora = desenvolvedora;
        this.capaUrl = capaUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Desenvolvedora getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(Desenvolvedora desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public String getCapaUrl() {
        return capaUrl;
    }

    public void setCapaUrl(String capaUrl) {
        this.capaUrl = capaUrl;
    }
}
