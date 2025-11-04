package com.example.BackEndPi.controller;

import com.example.BackEndPi.entity.Avaliacao;
import com.example.BackEndPi.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AvaliacaoController {
    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping("/avaliacao")
    public List<Avaliacao> Get() {
        return avaliacaoService.findAll();
    }
}
