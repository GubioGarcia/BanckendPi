package com.example.BackEndPi.service;

import com.example.BackEndPi.entity.Interacao;
import com.example.BackEndPi.repository.InteracaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InteracaoService {
    private InteracaoRepository interacaoRepository;

    @Autowired
    public InteracaoService(InteracaoRepository interacaoRepository) {
        this.interacaoRepository = interacaoRepository;
    }

    public List<Interacao> findAll() {
        return interacaoRepository.findAll();
    }
}
