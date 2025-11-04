package com.example.BackEndPi.controller;

import com.example.BackEndPi.entity.Jogo;
import com.example.BackEndPi.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class JogoController {
    @Autowired
    private JogoService jogoService;

    @GetMapping("/jogo")
    public List<Jogo> Get() {
        return jogoService.findAll();
    }
}
