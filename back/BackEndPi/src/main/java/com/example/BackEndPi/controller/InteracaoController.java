package com.example.BackEndPi.controller;

import com.example.BackEndPi.entity.Interacao;
import com.example.BackEndPi.service.InteracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class InteracaoController {
    @Autowired
    private InteracaoService interacaoService;

    @GetMapping("/interacao")
    public List<Interacao> Get() {
        return interacaoService.findAll();
    }
}
