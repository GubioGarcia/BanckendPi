package com.example.BackEndPi.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Interacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private Long usuarioId;

    @Column(nullable = false, length = 255)
    private Long avaliacaoId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoInteracao tipo;

    @Column(nullable = false, length = 255)
    private String conteudo;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = true)
    private Long respostaAIntercaoId; // relacionamento circular que referência uma interação a outra

    public Interacao() {
    }

    public Interacao(Long id, Long usuarioId, Long avaliacaoId, TipoInteracao tipo, String conteudo, LocalDate data, Long respostaAIntercaoId) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.avaliacaoId = avaliacaoId;
        this.tipo = tipo;
        this.conteudo = conteudo;
        this.data = data;
        this.respostaAIntercaoId = respostaAIntercaoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getAvaliacaoId() {
        return avaliacaoId;
    }

    public void setAvaliacaoId(Long avaliacaoId) {
        this.avaliacaoId = avaliacaoId;
    }

    public TipoInteracao getTipo() {
        return tipo;
    }

    public void setTipo(TipoInteracao tipo) {
        this.tipo = tipo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Long getRespostaAIntercaoId() {
        return respostaAIntercaoId;
    }

    public void setRespostaAIntercaoId(Long respostaAIntercaoId) {
        this.respostaAIntercaoId = respostaAIntercaoId;
    }
}
