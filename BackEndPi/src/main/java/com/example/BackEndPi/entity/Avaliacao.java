package com.example.BackEndPi.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import jakarta.validation.constraints.*;

@Entity
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long usuarioId;

    @Column(nullable = false)
    private Long jogoId;

    @Column(nullable = false)
    @Min(0)
    @Max(10)
    private int nota;

    @Column(nullable = false, length = 255)
    private String tituloResenha;

    @Column(nullable = false, length = 255)
    private String textoResenha;

    @Column(nullable = false)
    private LocalDate dataPublicacao;

    public Avaliacao() {
    }

    public Avaliacao(Long id, Long usuarioId, Long jogoId, int nota, String tituloResenha, String textoResenha, LocalDate dataPublicacao) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.jogoId = jogoId;
        this.nota = nota;
        this.tituloResenha = tituloResenha;
        this.textoResenha = textoResenha;
        this.dataPublicacao = dataPublicacao;
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

    public Long getJogoId() {
        return jogoId;
    }

    public void setJogoId(Long jogoId) {
        this.jogoId = jogoId;
    }

    @Min(0)
    @Max(10)
    public int getNota() {
        return nota;
    }

    public void setNota(@Min(0) @Max(10) int nota) {
        this.nota = nota;
    }

    public String getTituloResenha() {
        return tituloResenha;
    }

    public void setTituloResenha(String tituloResenha) {
        this.tituloResenha = tituloResenha;
    }

    public String getTextoResenha() {
        return textoResenha;
    }

    public void setTextoResenha(String textoResenha) {
        this.textoResenha = textoResenha;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}
