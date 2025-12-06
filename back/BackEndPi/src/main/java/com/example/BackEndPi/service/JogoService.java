package com.example.BackEndPi.service;

import com.example.BackEndPi.entity.*;
import com.example.BackEndPi.entity.dtos.JogoDTO;
import com.example.BackEndPi.entity.dtos.JogoUpdateDTO;
import com.example.BackEndPi.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JogoService {
    private JogoRepository jogoRepository;

    @Autowired
    public JogoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public List<Jogo> findAll() {
        return jogoRepository.findAll();
    }

    public Jogo findById(Long id) {
        return jogoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi encontrado jogo com o ID: " + id));
    }

    public List<Jogo> findByTitulo(String titulo) {
        if (titulo.trim().isEmpty())
            throw new RuntimeException("Não foi informado o titulo.");

        return jogoRepository.findByTituloContainingIgnoreCase(titulo);
    }

    public List<Jogo> findByPlataforma(Plataforma plataforma) {
        if (plataforma == null)
            throw new RuntimeException("Plataforma não informada.");

        return jogoRepository.findByPlataforma(plataforma);
    }

    public List<Jogo> findByCategoria(Categoria categoria) {
        if (categoria == null)
            throw new RuntimeException("Categoria não informada.");

        return jogoRepository.findByCategoria(categoria);
    }

    public List<Jogo> findByAnoLancamento(int anoLancamento) {
        if (anoLancamento <= 0)
            throw new RuntimeException("Ano de lançamento inválido.");

        return jogoRepository.findByAnoLancamento(anoLancamento);
    }

    public List<Jogo> findByDesenvolvedora(Desenvolvedora desenvolvedora) {
        if (desenvolvedora == null)
            throw new RuntimeException("Desenvolvedora não informada.");

        return jogoRepository.findByDesenvolvedora(desenvolvedora);
    }

    public List<Jogo> listarOrdenadosPorNota() {
        return jogoRepository.findAllByOrderByMediaNotasDesc();
    }

    public Jogo save(JogoDTO jogoDTO) {
        if (jogoDTO.titulo.trim().isEmpty())
            throw new RuntimeException("Informe o título.");
        if (jogoDTO.categoria == null)
            throw new RuntimeException("Informe a categoria.");
        if (jogoDTO.plataforma == null)
            throw new RuntimeException("Informe a plataforma.");
        if (jogoDTO.desenvolvedora == null)
            throw new RuntimeException("Informe a desenvolvedora.");
        if (jogoDTO.capaUrl.trim().isEmpty())
            throw new RuntimeException("Informe uma imagem de capa para o jogo.");
        if (jogoDTO.anoLancamento < 1900 || jogoDTO.anoLancamento > LocalDate.now().getYear())
            throw new RuntimeException("Ano inválido.");

        Jogo jogo = new Jogo();
        jogo.setTitulo(jogoDTO.titulo);
        jogo.setCategoria(jogoDTO.categoria);
        jogo.setPlataforma(jogoDTO.plataforma);
        jogo.setDesenvolvedora(jogoDTO.desenvolvedora);
        jogo.setAnoLancamento(jogoDTO.anoLancamento);
        jogo.setCapaUrl(jogoDTO.capaUrl);
        jogo.setMediaNotas(0);
        jogo.setTotalAvaliacoes(0);

        return jogoRepository.save(jogo);
    }

    public Jogo update(JogoUpdateDTO jogoUpdateDTO) {
        Jogo jogoExistente = jogoRepository.findById(jogoUpdateDTO.id)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado com o ID: " + jogoUpdateDTO.id));

        if (jogoUpdateDTO.titulo != null && !jogoUpdateDTO.titulo.trim().isEmpty()) {
            jogoExistente.setTitulo(jogoUpdateDTO.titulo.trim());
        }

        if (jogoUpdateDTO.categoria != null) jogoExistente.setCategoria(jogoUpdateDTO.categoria);
        if (jogoUpdateDTO.desenvolvedora != null) jogoExistente.setDesenvolvedora(jogoUpdateDTO.desenvolvedora);
        if (jogoUpdateDTO.plataforma != null) jogoExistente.setPlataforma(jogoUpdateDTO.plataforma);
        if (jogoUpdateDTO.capaUrl != null) jogoExistente.setCapaUrl(jogoUpdateDTO.capaUrl);
        if (jogoUpdateDTO.anoLancamento < 1900 || jogoUpdateDTO.anoLancamento > LocalDate.now().getYear()) {
            throw new RuntimeException("Ano inválido.");
        } else {
            jogoExistente.setAnoLancamento(jogoUpdateDTO.anoLancamento);
        }

        return jogoRepository.save(jogoExistente);
    }

    public void delete(Long id) {
        Jogo jogo = findById(id);

        jogoRepository.deleteById(id);
    }
}
