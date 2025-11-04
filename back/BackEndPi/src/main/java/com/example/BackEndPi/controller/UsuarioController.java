package com.example.BackEndPi.controller;

import com.example.BackEndPi.entity.Usuario;
import com.example.BackEndPi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario")
    public List<Usuario> Get() {
        return usuarioService.findAll();
    }
}
