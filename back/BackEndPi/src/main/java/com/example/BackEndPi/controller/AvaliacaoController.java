package com.example.BackEndPi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BackEndPi.entity.Avaliacao;
import com.example.BackEndPi.service.AvaliacaoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    // Listar todas as avaliações
    @GetMapping
    public List<Avaliacao> getAllAvaliacoes() {
        return avaliacaoService.findAll();
    }

    // Cadastrar nova avaliação e atualizar média do jogo
    @PostMapping
    public Avaliacao criarAvaliacao(@RequestBody Avaliacao avaliacao) {
        return avaliacaoService.salvarAvaliacao(avaliacao);
    }
}
