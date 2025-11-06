package com.example.BackEndPi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BackEndPi.entity.ColecaoJogo;
import com.example.BackEndPi.service.ColecaoJogoService;

@RestController
@CrossOrigin(origins = "*")
public class ColecaoJogoController {
    @Autowired
    private ColecaoJogoService colecaoJogoService;

    @GetMapping("/colecaojogo")
    public List<ColecaoJogo> Get() {
        return colecaoJogoService.findAll();
    }
}
