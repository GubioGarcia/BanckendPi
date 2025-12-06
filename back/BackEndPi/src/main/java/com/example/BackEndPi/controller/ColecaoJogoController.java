package com.example.BackEndPi.controller;

import com.example.BackEndPi.entity.ColecaoJogo;
import com.example.BackEndPi.entity.StatusJogo;
import com.example.BackEndPi.entity.dtos.ColecaoJogoDTO;
import com.example.BackEndPi.entity.dtos.ColecaoJogoUpdateDTO;
import com.example.BackEndPi.service.ColecaoJogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/colecaoDeJogo")
@CrossOrigin(origins = "*")
public class ColecaoJogoController {
    @Autowired
    private ColecaoJogoService colecaoJogoService;

    @GetMapping
    public List<ColecaoJogo> Get() {
        return colecaoJogoService.findAll();
    }

    @GetMapping("/colecaoPorUsuario/{usuarioId}")
    public List<ColecaoJogo> listarPorUsuario(@PathVariable Long usuarioId) {
        return colecaoJogoService.listarPorUsuario(usuarioId);
    }

    @GetMapping("/colecaoPorJogo/{jogoId}")
    public List<ColecaoJogo> listarPorJogo(@PathVariable Long jogoId) {
        return colecaoJogoService.listarPorJogo(jogoId);
    }

    @GetMapping("/colecaoPorStatus/{status}")
    public List<ColecaoJogo> listarPorStatus(@PathVariable StatusJogo status) {
        return colecaoJogoService.listarPorStatus(status);
    }

    @PostMapping
    public ColecaoJogo save(@RequestBody ColecaoJogoDTO colecaoJogoDTO) {
        return colecaoJogoService.save(colecaoJogoDTO);
    }

    @PutMapping
    public ColecaoJogo update(@RequestBody ColecaoJogoUpdateDTO colecaoJogoUpdateDTO) {
        return colecaoJogoService.update(colecaoJogoUpdateDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        colecaoJogoService.delete(id);
    }
}
