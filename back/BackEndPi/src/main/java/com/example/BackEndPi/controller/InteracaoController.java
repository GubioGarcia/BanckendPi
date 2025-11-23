package com.example.BackEndPi.controller;

import com.example.BackEndPi.entity.Interacao;
import com.example.BackEndPi.entity.dtos.InteracaoDTO;
import com.example.BackEndPi.entity.dtos.InteracaoUpdateDTO;
import com.example.BackEndPi.service.InteracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/interacao")
@CrossOrigin(origins = "*")
public class InteracaoController {
    @Autowired
    private InteracaoService interacaoService;

    @GetMapping
    public List<Interacao> Get() {
        return interacaoService.findAll();
    }

    @GetMapping("/{id}")
    public Interacao buscarPorId(@PathVariable Long id) {
        return interacaoService.findById(id);
    }

    @GetMapping("/interacaoPorUsuario/{usuarioId}")
    public List<Interacao> listarPorUsuario(@PathVariable Long usuarioId) {
        return interacaoService.findByUsuarioId(usuarioId);
    }

    @GetMapping("/interacaoPorAvaliacao/{avaliacaoId}")
    public List<Interacao> listarPorAvaliacao(@PathVariable Long avaliacaoId) {
        return interacaoService.findByAvaliacaoId(avaliacaoId);
    }

    @GetMapping("/quantidadeDeCurtidasPorAvalicao/{avaliacaoId}")
    public long contarCurtidas(@PathVariable Long avaliacaoId) {
        return interacaoService.contarCurtidasPorAvaliacao(avaliacaoId);
    }

    @PostMapping
    public Interacao save(@RequestBody InteracaoDTO interacaoDTO) {
        return interacaoService.save(interacaoDTO);
    }

    @PutMapping
    public Interacao update(@RequestBody InteracaoUpdateDTO interacaoUpdateDTO) {
        return interacaoService.update(interacaoUpdateDTO);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        interacaoService.delete(id);
    }
}
