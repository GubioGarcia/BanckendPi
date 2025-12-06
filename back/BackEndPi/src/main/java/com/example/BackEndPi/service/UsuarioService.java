package com.example.BackEndPi.service;

import com.example.BackEndPi.entity.Usuario;
import com.example.BackEndPi.entity.dtos.UsuarioDTO;
import com.example.BackEndPi.entity.dtos.UsuarioLoginDTO;
import com.example.BackEndPi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi encontrado usuário com o ID: " + id));
    }

    public List<Usuario> findByNome(String nome) {
        if (nome.trim().isEmpty())
            throw new RuntimeException("Não foi informado o nome.");

        return usuarioRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Usuario findByEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null)
            throw new RuntimeException("Não foi encontrado usuário com o e-mail: " + email);

        return usuario;
    }

    public Usuario save(UsuarioDTO usuarioDTO) {
        if (usuarioDTO.nome.trim().isEmpty())
            throw new RuntimeException("Nome inválido.");
        if (usuarioDTO.senha.trim().isEmpty() || usuarioDTO.senha.trim().length() != 8)
            throw new RuntimeException("Informe uma senha válida. Deve conter 8 dígitos.");

        validaEmail(usuarioDTO.email);
        if (usuarioRepository.findByEmail(usuarioDTO.email.trim()) != null) {
            throw new RuntimeException("E-mail já possui cadastro.");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.nome.trim());
        usuario.setEmail(usuarioDTO.email.trim());
        usuario.setSenha(usuarioDTO.senha.trim());
        usuario.setBio(usuarioDTO.bio);

        return usuarioRepository.save(usuario);
    }

    public Usuario update(Usuario usuarioAtualizado) {
        Usuario usuarioExistente = usuarioRepository.findById(usuarioAtualizado.getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + usuarioAtualizado.getId()));

        if (usuarioAtualizado.getNome() != null && !usuarioAtualizado.getNome().trim().isEmpty()) {
            usuarioExistente.setNome(usuarioAtualizado.getNome().trim());
        }

        if (usuarioAtualizado.getEmail() != null && !usuarioAtualizado.getEmail().trim().isEmpty()) {
            validaEmail(usuarioAtualizado.getEmail());
            Usuario outroUsuario = usuarioRepository.findByEmail(usuarioAtualizado.getEmail().trim());
            if (outroUsuario != null && !outroUsuario.getId().equals(usuarioAtualizado.getId())) {
                throw new RuntimeException("Este e-mail já está sendo utilizado por outro usuário.");
            }

            usuarioExistente.setEmail(usuarioAtualizado.getEmail().trim());
        }

        if (usuarioAtualizado.getSenha() != null && usuarioAtualizado.getSenha().trim().length() >= 8) {
            usuarioExistente.setSenha(usuarioAtualizado.getSenha().trim());
        }

        usuarioExistente.setBio(usuarioAtualizado.getBio());

        return usuarioRepository.save(usuarioExistente);
    }

    public Usuario logar(UsuarioLoginDTO usuarioLoginDTO) {
        if (usuarioLoginDTO.email.trim().isEmpty())
            throw new RuntimeException("Informe o e-mail.");
        if (usuarioLoginDTO.senha.trim().isEmpty())
            throw new RuntimeException("Informe a senha.");

        validaEmail(usuarioLoginDTO.email);
        Usuario usuario = usuarioRepository.findByEmail(usuarioLoginDTO.email);
        if (usuario == null)
            throw new RuntimeException("Não há usuário cadastrado com este e-mail.");

        if (!usuario.getEmail().equals(usuarioLoginDTO.email) || !usuario.getSenha().equals(usuarioLoginDTO.senha))
            throw new RuntimeException("Erro de login! Verifique os dados informados.");

        return usuario;
    }

    public void delete(Long id) {
        Usuario usuario = findById(id);

        usuarioRepository.deleteById(id);
    }

    public boolean validaEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new RuntimeException("Informe o email.");
        }

        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        if (!email.matches(regex)) {
            throw new RuntimeException("Email inválido.");
        }

        return true;
    }
}
