package com.example.BackEndPi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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

    @Column(nullable = false)
    private double mediaNotas = 0.0;

    @Column(nullable = false)
    private int totalAvaliacoes = 0;

    public Jogo() {
    }

    public Jogo(Long id, String titulo, Plataforma plataforma, Categoria categoria, int anoLancamento,
                Desenvolvedora desenvolvedora, String capaUrl, double mediaNotas, int totalAvaliacoes) {
        this.id = id;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.categoria = categoria;
        this.anoLancamento = anoLancamento;
        this.desenvolvedora = desenvolvedora;
        this.capaUrl = capaUrl;
        this.mediaNotas = mediaNotas;
        this.totalAvaliacoes = totalAvaliacoes;
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

    public double getMediaNotas() {
        return mediaNotas;
    }

    public void setMediaNotas(double mediaNotas) {
        this.mediaNotas = mediaNotas;
    }

    public int getTotalAvaliacoes() {
        return totalAvaliacoes;
    }

    public void setTotalAvaliacoes(int totalAvaliacoes) {
        this.totalAvaliacoes = totalAvaliacoes;
    }
}
