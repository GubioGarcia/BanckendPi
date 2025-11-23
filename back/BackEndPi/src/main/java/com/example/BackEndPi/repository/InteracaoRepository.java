package com.example.BackEndPi.repository;

import com.example.BackEndPi.entity.Interacao;
import com.example.BackEndPi.entity.TipoInteracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InteracaoRepository extends JpaRepository<Interacao, Long> {
    List<Interacao> findByUsuarioId(Long usuarioId);
    List<Interacao> findByAvaliacaoId(Long jogoId);
    List<Interacao> findByRespostaAIntercaoId(Long id);
    List<Interacao> findByAvaliacaoIdAndTipo(Long avaliacaoId, TipoInteracao tipo);
    long countByAvaliacaoIdAndTipo(Long avaliacaoId, TipoInteracao tipo);
}
