package com.example.BackEndPi.service;

import com.example.BackEndPi.entity.Jogo;
import com.example.BackEndPi.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
