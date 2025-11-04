package com.example.BackEndPi.service;

import com.example.BackEndPi.entity.ColecaoJogo;
import com.example.BackEndPi.repository.ColecaoJogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColecaoJogoService {
    private ColecaoJogoRepository colecaoJogoRepository;

    @Autowired
    public ColecaoJogoService(ColecaoJogoRepository colecaoJogoRepository) {
        this.colecaoJogoRepository = colecaoJogoRepository;
    }

    public List<ColecaoJogo> findAll() {
        return colecaoJogoRepository.findAll();
    }
}
