package com.example.BackEndPi.service;

import com.example.BackEndPi.entity.Avaliacao;
import com.example.BackEndPi.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public List<Avaliacao> findAll() {
        return avaliacaoRepository.findAll();
    }
}
