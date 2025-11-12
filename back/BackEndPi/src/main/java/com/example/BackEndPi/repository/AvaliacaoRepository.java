package com.example.BackEndPi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BackEndPi.entity.Avaliacao;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    // Buscar todas as avaliações de um jogo específico
    List<Avaliacao> findByJogoId(Long jogoId);
}
