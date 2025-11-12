package com.example.BackEndPi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BackEndPi.entity.Avaliacao;
import com.example.BackEndPi.entity.Jogo;
import com.example.BackEndPi.repository.AvaliacaoRepository;
import com.example.BackEndPi.repository.JogoRepository;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private JogoRepository jogoRepository;

    // Retorna todas as avaliações
    public List<Avaliacao> findAll() {
        return avaliacaoRepository.findAll();
    }

    // Salva nova avaliação e atualiza média de notas do jogo
    public Avaliacao salvarAvaliacao(Avaliacao avaliacao) {
        Avaliacao novaAvaliacao = avaliacaoRepository.save(avaliacao);

        // Atualiza a média de notas e total de avaliações do jogo
        Long jogoId = avaliacao.getJogoId();
        Jogo jogo = jogoRepository.findById(jogoId).orElse(null);

        if (jogo != null) {
            List<Avaliacao> avaliacoesDoJogo = avaliacaoRepository.findByJogoId(jogoId);

            double somaNotas = avaliacoesDoJogo.stream()
                    .mapToDouble(Avaliacao::getNota)
                    .sum();

            int totalAvaliacoes = avaliacoesDoJogo.size();
            double media = somaNotas / totalAvaliacoes;

            jogo.setMediaNotas(media);
            jogo.setTotalAvaliacoes(totalAvaliacoes);

            jogoRepository.save(jogo);
        }

        return novaAvaliacao;
    }
}
