package com.example.BackEndPi.repository;

import com.example.BackEndPi.entity.ColecaoJogo;
import com.example.BackEndPi.entity.StatusJogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColecaoJogoRepository extends JpaRepository<ColecaoJogo, Long> {
    List<ColecaoJogo> findByUsuarioId(Long usuarioId);
    List<ColecaoJogo> findByJogoId(Long jogoId);
    List<ColecaoJogo> findByStatus(StatusJogo status);
    List<ColecaoJogo> findByUsuarioIdAndStatus(Long usuarioId, StatusJogo status);
    List<ColecaoJogo> findByUsuarioIdAndJogoId(Long usuarioId, Long jogoId);
}
