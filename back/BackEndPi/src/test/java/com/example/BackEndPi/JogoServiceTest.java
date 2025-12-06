/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.BackEndPi;

import com.example.BackEndPi.entity.*;
import com.example.BackEndPi.entity.dtos.JogoUpdateDTO;
import com.example.BackEndPi.entity.dtos.UsuarioDTO;
import com.example.BackEndPi.repository.JogoRepository;
import com.example.BackEndPi.service.JogoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Gubio
 */
public class JogoServiceTest {
    private JogoRepository jogoRepository;
    private JogoService jogoService;

    @BeforeEach
    void setUp() {
        jogoRepository = mock(JogoRepository.class);
        jogoService = new JogoService(jogoRepository);
    }

    @Test
    void deveAtualizarJogoComSucesso() {
        // Arrange
        Jogo jogoExistente = new Jogo();
        jogoExistente.setId(1L);
        jogoExistente.setTitulo("Silent Hill");
        jogoExistente.setAnoLancamento(1999);

        JogoUpdateDTO updateDTO = new JogoUpdateDTO();
        updateDTO.id = 1L;
        updateDTO.titulo = "Silent Hill 2 Remake";
        updateDTO.anoLancamento = 2024;

        when(jogoRepository.findById(1L)).thenReturn(Optional.of(jogoExistente));
        when(jogoRepository.save(any(Jogo.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Jogo atualizado = jogoService.update(updateDTO);

        // Assert
        assertEquals("Silent Hill 2 Remake", atualizado.getTitulo());
        assertEquals(2024, atualizado.getAnoLancamento());
    }

    @Test
    void deveFalharJogoNaoExiste() {
        JogoUpdateDTO updateDTO = new JogoUpdateDTO();
        updateDTO.id = 99L;
        updateDTO.titulo = "Mario";
        updateDTO.anoLancamento = 2020;

        when(jogoRepository.findById(99L)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> jogoService.update(updateDTO));

        assertEquals("Jogo não encontrado com o ID: 99", ex.getMessage());
    }
}
