package com.example.BackEndPi.service;

import java.time.LocalDate;
import java.util.List;

import com.example.BackEndPi.entity.Usuario;
import com.example.BackEndPi.entity.dtos.AvaliacaoDTO;
import com.example.BackEndPi.entity.dtos.AvaliacaoUpdateDTO;
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

    private UsuarioService usuarioService;
    private JogoService jogoService;

    public List<Avaliacao> findAll() {
        return avaliacaoRepository.findAll();
    }

    public Avaliacao findById(Long id) {
        return avaliacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi encontrada avaliação com o ID: " + id));
    }

    public List<Avaliacao> findByUsuarioId(Long id) {
        return avaliacaoRepository.findByUsuarioId(id);
    }

    public List<Avaliacao> findByJogoId(Long id) {
        return avaliacaoRepository.findByJogoId(id);
    }

    public Avaliacao save(AvaliacaoDTO avaliacaoDTO) {
        Usuario usuario = usuarioService.findById(avaliacaoDTO.usuarioId);
        if (usuario == null) throw new RuntimeException("Não foi encontrado usuário com o id informado.");

        Jogo jogo = jogoService.findById(avaliacaoDTO.jogoId);
        if (jogo == null) throw new RuntimeException("Não foi encontrado jogo com o id informado.");

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setUsuarioId(avaliacaoDTO.usuarioId);
        avaliacao.setJogoId(avaliacaoDTO.jogoId);
        avaliacao.setNota(avaliacaoDTO.nota);
        avaliacao.setTituloResenha(avaliacaoDTO.tituloResenha.trim());
        avaliacao.setTextoResenha(avaliacaoDTO.textoResenha.trim());
        avaliacao.setDataPublicacao(LocalDate.now());

        // Atualiza estatísticas do jogo
        int totalAtual = jogo.getTotalAvaliacoes();
        double mediaAtual = jogo.getMediaNotas();
        int novoTotal = totalAtual + 1;
        double novaMedia = ((mediaAtual * totalAtual) + avaliacaoDTO.nota) / novoTotal;
        jogo.setTotalAvaliacoes(novoTotal);
        jogo.setMediaNotas(novaMedia);

        // Persiste avaliação e jogo
        Avaliacao novaAvaliacao = avaliacaoRepository.save(avaliacao);
        jogoRepository.save(jogo);

        return novaAvaliacao;
    }

    public Avaliacao update(AvaliacaoUpdateDTO avaliacaoUpdateDTO) {
        Avaliacao avaliacaoExistente = avaliacaoRepository.findById(avaliacaoUpdateDTO.id)
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada com o ID: " + avaliacaoUpdateDTO.id));

        Usuario usuario = usuarioService.findById(avaliacaoUpdateDTO.usuarioId);
        if (usuario == null) throw new RuntimeException("Usuário não encontrado com o id informado.");

        Jogo jogo = jogoService.findById(avaliacaoUpdateDTO.jogoId);
        if (jogo == null) throw new RuntimeException("Jogo não encontrado com o id informado.");

        int notaAntiga = avaliacaoExistente.getNota();

        avaliacaoExistente.setUsuarioId(avaliacaoUpdateDTO.usuarioId);
        avaliacaoExistente.setJogoId(avaliacaoUpdateDTO.jogoId);
        avaliacaoExistente.setNota(avaliacaoUpdateDTO.nota);
        avaliacaoExistente.setTituloResenha(avaliacaoUpdateDTO.tituloResenha.trim());
        avaliacaoExistente.setTextoResenha(avaliacaoUpdateDTO.textoResenha.trim());
        avaliacaoExistente.setDataPublicacao(LocalDate.now());


        int totalAvaliacoes = jogo.getTotalAvaliacoes();
        double mediaAtual = jogo.getMediaNotas();
        double novaMedia = ((mediaAtual * totalAvaliacoes) - notaAntiga + avaliacaoUpdateDTO.nota) / totalAvaliacoes;
        jogo.setMediaNotas(novaMedia);

        Avaliacao novaAvaliacao = avaliacaoRepository.save(avaliacaoExistente);
        jogoRepository.save(jogo);

        return novaAvaliacao;
    }

    public void delete(Long id) {
        Avaliacao avaliacao = avaliacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada com o ID: " + id));

        Jogo jogo = jogoService.findById(avaliacao.getJogoId());
        if (jogo == null) throw new RuntimeException("Jogo não encontrado para a avaliação.");

        int notaRemovida = avaliacao.getNota();
        int totalAtual = jogo.getTotalAvaliacoes();
        double mediaAtual = jogo.getMediaNotas();

        int novoTotal = totalAtual - 1;
        double novaMedia = 0.0;
        if (novoTotal > 0) novaMedia = ((mediaAtual * totalAtual) - notaRemovida) / novoTotal;

        jogo.setTotalAvaliacoes(novoTotal);
        jogo.setMediaNotas(novaMedia);

        avaliacaoRepository.delete(avaliacao);
        jogoRepository.save(jogo);
    }

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
