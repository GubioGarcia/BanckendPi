package com.example.BackEndPi.controller;

import com.example.BackEndPi.entity.Avaliacao;
import com.example.BackEndPi.entity.dtos.AvaliacaoDTO;
import com.example.BackEndPi.entity.dtos.AvaliacaoUpdateDTO;
import com.example.BackEndPi.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/avaliacao")
@CrossOrigin(origins = "*")
public class AvaliacaoController {
    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping
    public List<Avaliacao> Get() {
        return avaliacaoService.findAll();
    }

    @GetMapping("/avaliacaoPorId/{id}")
    public Avaliacao findById(@PathVariable Long id) {
        return avaliacaoService.findById(id);
    }

    @GetMapping("/avaliacaoPorUsuario/{id}")
    public List<Avaliacao> findByUsuario(@PathVariable Long id) {
        return avaliacaoService.findByUsuarioId(id);
    }

    @GetMapping("/avaliacaoPorJogo/{id}")
    public List<Avaliacao> findByJogo(@PathVariable Long id) {
        return avaliacaoService.findByJogoId(id);
    }

    @PostMapping
    public Avaliacao save(@RequestBody AvaliacaoDTO avaliacaoDTO) {
        return avaliacaoService.save(avaliacaoDTO);
    }

    @PutMapping
    public Avaliacao update(@RequestBody AvaliacaoUpdateDTO avaliacaoUpdateDTO) {
        return avaliacaoService.update(avaliacaoUpdateDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        avaliacaoService.delete(id);
    }
}
