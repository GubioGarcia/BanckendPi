package com.example.BackEndPi.controller;

import com.example.BackEndPi.entity.Usuario;
import com.example.BackEndPi.entity.dtos.UsuarioDTO;
import com.example.BackEndPi.entity.dtos.UsuarioLoginDTO;
import com.example.BackEndPi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> Get() {
        return usuarioService.findAll();
    }

    @GetMapping("{id}")
    public Usuario findById(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

    @GetMapping("/usuarioPorNome/{nome}")
    public List<Usuario> findByNome(@PathVariable String nome) {
        return usuarioService.findByNome(nome);
    }

    @GetMapping("/usuarioPorEmail/{email}")
    public Usuario findByEmail(@PathVariable String email) {
        return usuarioService.findByEmail(email);
    }

    @PostMapping
    public Usuario save(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.save(usuarioDTO);
    }

    @PutMapping
    public Usuario update(@RequestBody Usuario usuario) {
        return usuarioService.update(usuario);
    }

    @PostMapping("/logar")
    public Usuario logar(@RequestBody UsuarioLoginDTO usuarioLoginDTO) {
        return usuarioService.logar(usuarioLoginDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioService.delete(id);
    }
}
