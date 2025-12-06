package com.example.BackEndPi.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ColecaoJogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long usuarioId;

    @Column(nullable = false)
    private Long jogoId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusJogo status;

    @Column(nullable = true)
    private LocalDate dataInicio;

    @Column(nullable = true)
    private LocalDate dataFim;

    public ColecaoJogo() {
    }

    public ColecaoJogo(Long id, Long usuarioId, Long jogoId, StatusJogo status, LocalDate dataInicio, LocalDate dataFim) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.jogoId = jogoId;
        this.status = status;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
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

    public StatusJogo getStatus() {
        return status;
    }

    public void setStatus(StatusJogo status) {
        this.status = status;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
}
