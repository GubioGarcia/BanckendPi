/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.BackEndPi;

import com.example.BackEndPi.entity.*;
import com.example.BackEndPi.entity.dtos.*;
import com.example.BackEndPi.repository.UsuarioRepository;
import com.example.BackEndPi.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Gubio
 */
public class UsuarioServiceTest {
    private UsuarioRepository usuarioRepository;
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        usuarioRepository = Mockito.mock(UsuarioRepository.class);
        usuarioService = new UsuarioService(usuarioRepository);
    }

    @Test
    void deveLogarComSucesso() {
        // Arrange
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setEmail("testeLogar@teste.com");
        usuario.setSenha("12345678");

        UsuarioLoginDTO loginDTO = new UsuarioLoginDTO();
        loginDTO.email = "testeLogar@teste.com";
        loginDTO.senha = "12345678";

        when(usuarioRepository.findByEmail("testeLogar@teste.com")).thenReturn(usuario);

        // Act
        Usuario resultado = usuarioService.logar(loginDTO);

        // Assert
        assertNotNull(resultado);
        assertEquals("testeLogar@teste.com", resultado.getEmail());
    }

    @Test
    void deveFalharQuandoSenhaIncorreta() {
        Usuario usuario = new Usuario();
        usuario.setEmail("testeLogar@teste.com");
        usuario.setSenha("abcdefgh");

        UsuarioLoginDTO loginDTO = new UsuarioLoginDTO();
        loginDTO.email = "testeLogar@teste.com";
        loginDTO.senha = "OutraSenha";

        when(usuarioRepository.findByEmail("testeLogar@teste.com")).thenReturn(usuario);

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> usuarioService.logar(loginDTO));

        assertEquals("Erro de login! Verifique os dados informados.", ex.getMessage());
    }
    
    @Test
    void deveCriarUsuarioComSucesso() {
        // Arrange
        UsuarioDTO dto = new UsuarioDTO();
        dto.nome = "Criação teste";
        dto.email = "criacaoTeste@teste.com";
        dto.senha = "asdfghjk";
        dto.bio = "Teste";

        Usuario usuarioSalvo = new Usuario();
        usuarioSalvo.setId(1L);
        usuarioSalvo.setNome(dto.nome);
        usuarioSalvo.setEmail(dto.email);
        usuarioSalvo.setSenha(dto.senha);
        usuarioSalvo.setBio(dto.bio);

        when(usuarioRepository.findByEmail(dto.email)).thenReturn(null);
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuarioSalvo);

        // Act
        Usuario resultado = usuarioService.save(dto);

        // Assert
        assertNotNull(resultado.getId());
        assertEquals("Criação teste", resultado.getNome());
        assertEquals("criacaoTeste@teste.com", resultado.getEmail());
        assertEquals("asdfghjk", resultado.getSenha());
        assertEquals("Teste", resultado.getBio());
    }
}
