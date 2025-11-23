package com.example.BackEndPi.repository;

import com.example.BackEndPi.entity.Categoria;
import com.example.BackEndPi.entity.Desenvolvedora;
import com.example.BackEndPi.entity.Jogo;
import com.example.BackEndPi.entity.Plataforma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
    List<Jogo> findByTituloContainingIgnoreCase(String titulo);
    List<Jogo> findByPlataforma(Plataforma plataforma);
    List<Jogo> findByCategoria(Categoria categoria);
    List<Jogo> findByAnoLancamento(int anoLancamento);
    List<Jogo> findByDesenvolvedora(Desenvolvedora desenvolvedora);
    List<Jogo> findAllByOrderByMediaNotasDesc();
}
