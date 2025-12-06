package com.example.BackEndPi.service;

import com.example.BackEndPi.entity.Avaliacao;
import com.example.BackEndPi.entity.Interacao;
import com.example.BackEndPi.entity.TipoInteracao;
import com.example.BackEndPi.entity.Usuario;
import com.example.BackEndPi.entity.dtos.InteracaoDTO;
import com.example.BackEndPi.entity.dtos.InteracaoUpdateDTO;
import com.example.BackEndPi.repository.InteracaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InteracaoService {
    private InteracaoRepository interacaoRepository;

    private UsuarioService usuarioService;
    private AvaliacaoService avaliacaoService;

    @Autowired
    public InteracaoService(InteracaoRepository interacaoRepository) {
        this.interacaoRepository = interacaoRepository;
    }

    public List<Interacao> findAll() {
        return interacaoRepository.findAll();
    }

    public Interacao findById(Long id) {
        return interacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi encontrado usuário com o ID: " + id));
    }

    public List<Interacao> findByUsuarioId(Long id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario == null) throw new RuntimeException("Não foi encontrado usuário com o id informado.");

        return interacaoRepository.findByUsuarioId(id);
    }

    public List<Interacao> findByAvaliacaoId(Long id) {
        Avaliacao avaliacao = avaliacaoService.findById(id);
        if (avaliacao == null) throw new RuntimeException("não foi encontada avaliação com o id informado.");

        return interacaoRepository.findByAvaliacaoId(id);
    }

    public long contarCurtidasPorAvaliacao(Long avaliacaoId) {
        Avaliacao avaliacao = avaliacaoService.findById(avaliacaoId);
        if (avaliacao == null) throw new RuntimeException("Avaliação não encontrada com o ID: " + avaliacaoId);

        return interacaoRepository.countByAvaliacaoIdAndTipo(avaliacaoId, TipoInteracao.CURTIDA);
    }

    public Interacao save(InteracaoDTO interacaoDTO) {
        Usuario usuario = usuarioService.findById(interacaoDTO.usuarioId);
        if (usuario == null) throw new RuntimeException("Usuário não encontrado com o id informado.");

        Avaliacao avaliacao = avaliacaoService.findById(interacaoDTO.avaliacaoId);
        if (avaliacao == null) throw new RuntimeException("Avaliação não encontrada com o id informado.");


        Interacao interacao = new Interacao();
        interacao.setUsuarioId(interacaoDTO.usuarioId);
        interacao.setAvaliacaoId(interacaoDTO.avaliacaoId);
        interacao.setTipo(interacaoDTO.tipo);
        interacao.setConteudo(interacaoDTO.conteudo.trim());
        interacao.setData(LocalDate.now());

        if (interacaoDTO.respostaAIntercaoId != null) {
            interacaoRepository.findById(interacaoDTO.respostaAIntercaoId)
                    .orElseThrow(() -> new RuntimeException("Interação de resposta não encontrada."));
            interacao.setRespostaAIntercaoId(interacaoDTO.respostaAIntercaoId);
        }

        return interacaoRepository.save(interacao);
    }

    public Interacao update(InteracaoUpdateDTO interacaoUpdateDTO) {
        Interacao interacaoExistente = interacaoRepository.findById(interacaoUpdateDTO.id)
                .orElseThrow(() -> new RuntimeException("Interação não encontrada com o ID: " + interacaoUpdateDTO.id));

        if (interacaoUpdateDTO.usuarioId != null) {
            Usuario usuario = usuarioService.findById(interacaoUpdateDTO.usuarioId);
            if (usuario == null) throw new RuntimeException("Usuário não encontrado.");
            interacaoExistente.setUsuarioId(interacaoUpdateDTO.usuarioId);
        }

        if (interacaoUpdateDTO.avaliacaoId != null) {
            Avaliacao avaliacao = avaliacaoService.findById(interacaoUpdateDTO.avaliacaoId);
            if (avaliacao == null) throw new RuntimeException("Avaliação não encontrada.");
            interacaoExistente.setAvaliacaoId(interacaoUpdateDTO.avaliacaoId);
        }

        if (interacaoUpdateDTO.tipo != null)  interacaoExistente.setTipo(interacaoUpdateDTO.tipo);
        if (interacaoUpdateDTO.conteudo != null && !interacaoUpdateDTO.conteudo.trim().isEmpty()) {
            interacaoExistente.setConteudo(interacaoUpdateDTO.conteudo.trim());
        }

        if (interacaoUpdateDTO.respostaAIntercaoId != null) {
            interacaoRepository.findById(interacaoUpdateDTO.respostaAIntercaoId)
                    .orElseThrow(() -> new RuntimeException("Interação de resposta não encontrada."));
            interacaoExistente.setRespostaAIntercaoId(interacaoUpdateDTO.respostaAIntercaoId);
        }

        interacaoExistente.setData(LocalDate.now());

        return interacaoRepository.save(interacaoExistente);
    }

    public void delete(Long id) {
        Interacao interacao = interacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interação não encontrada com o ID: " + id));

        List<Interacao> respostas = interacaoRepository.findByRespostaAIntercaoId(interacao.getId());
        if (!respostas.isEmpty()) interacaoRepository.deleteAll(respostas);

        interacaoRepository.delete(interacao);
    }
}
