package com.example.BackEndPi.controller;

import com.example.BackEndPi.entity.Categoria;
import com.example.BackEndPi.entity.Desenvolvedora;
import com.example.BackEndPi.entity.Jogo;
import com.example.BackEndPi.entity.Plataforma;
import com.example.BackEndPi.entity.dtos.JogoDTO;
import com.example.BackEndPi.entity.dtos.JogoUpdateDTO;
import com.example.BackEndPi.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/jogo")
@CrossOrigin(origins = "*")
public class JogoController {
    @Autowired
    private JogoService jogoService;

    @GetMapping
    public List<Jogo> Get() {
        return jogoService.findAll();
    }

    @GetMapping("/jogoPorId/{id}")
    public Jogo findById(@PathVariable Long id) {
        return jogoService.findById(id);
    }

    @GetMapping("/jogoPorTitulo/{titulo}")
    public List<Jogo> findByTitulo(@PathVariable String titulo) {
        return jogoService.findByTitulo(titulo);
    }

    @GetMapping("/jogoPorNome/{plataforma}")
    public List<Jogo> listarPorPlataforma(@PathVariable Plataforma plataforma) {
        return jogoService.findByPlataforma(plataforma);
    }

    @GetMapping("/jogoPorNome/{categoria}")
    public List<Jogo> listarPorCategoria(@PathVariable Categoria categoria) {
        return jogoService.findByCategoria(categoria);
    }

    @GetMapping("/jogoPorAno/{anoLancamento}")
    public List<Jogo> listarPorAno(@PathVariable int anoLancamento) {
        return jogoService.findByAnoLancamento(anoLancamento);
    }

    @GetMapping("/jogoPorDesenvolvedora/{desenvolvedora}")
    public List<Jogo> listarPorDesenvolvedora(@PathVariable Desenvolvedora desenvolvedora) {
        return jogoService.findByDesenvolvedora(desenvolvedora);
    }

    @GetMapping("/jogoPorNotas")
    public List<Jogo> listarPorNota() {
        return jogoService.listarOrdenadosPorNota();
    }

    @PostMapping
    public Jogo save(@RequestBody JogoDTO jogoDTO) {
        return jogoService.save(jogoDTO);
    }

    @PutMapping
    public Jogo update(@RequestBody JogoUpdateDTO jogoUpdateDTO) {
        return jogoService.update(jogoUpdateDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        jogoService.delete(id);
    }
}
