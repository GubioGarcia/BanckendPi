package com.example.BackEndPi.service;

import com.example.BackEndPi.entity.ColecaoJogo;
import com.example.BackEndPi.entity.Jogo;
import com.example.BackEndPi.entity.StatusJogo;
import com.example.BackEndPi.entity.Usuario;
import com.example.BackEndPi.entity.dtos.ColecaoJogoDTO;
import com.example.BackEndPi.entity.dtos.ColecaoJogoUpdateDTO;
import com.example.BackEndPi.repository.ColecaoJogoRepository;
import com.example.BackEndPi.repository.JogoRepository;
import com.example.BackEndPi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ColecaoJogoService {
    private ColecaoJogoRepository colecaoJogoRepository;
    private JogoService jogoService;
    private UsuarioService usuarioService;

    @Autowired
    public ColecaoJogoService(ColecaoJogoRepository colecaoJogoRepository) {
        this.colecaoJogoRepository = colecaoJogoRepository;
    }

    public List<ColecaoJogo> findAll() {
        return colecaoJogoRepository.findAll();
    }

    public ColecaoJogo findById(Long id) {
        return colecaoJogoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi encontrada coleção com o ID: " + id));
    }

    public List<ColecaoJogo> listarPorUsuario(Long usuarioId) {
        Usuario usuario = usuarioService.findById(usuarioId);

        return colecaoJogoRepository.findByUsuarioId(usuario.getId());
    }

    public List<ColecaoJogo> listarPorJogo(Long jogoId) {
        Jogo jogo = jogoService.findById(jogoId);

        return colecaoJogoRepository.findByJogoId(jogo.getId());
    }

    public List<ColecaoJogo> listarPorStatus(StatusJogo status) {
        return colecaoJogoRepository.findByStatus(status);
    }

    public ColecaoJogo save(ColecaoJogoDTO colecaoJogoDTO) {
        if (colecaoJogoDTO.usuarioId == null) throw new RuntimeException("Informe o id do usuário.");
        if (colecaoJogoDTO.jogoId == null) throw new RuntimeException("Informe o id do jogo.");
        if (colecaoJogoDTO.status == null) throw new RuntimeException("Informe o status.");
        if (colecaoJogoDTO.status != StatusJogo.QUERO_JOGAR && colecaoJogoDTO.dataInicio ==  null)
            throw new RuntimeException("Informe a data de início.");
        if (colecaoJogoDTO.status == StatusJogo.JOGADO || colecaoJogoDTO.status == StatusJogo.JOGANDO
            && colecaoJogoDTO.dataFim == null)
            throw new RuntimeException("Informe a data de finalização.");

        ColecaoJogo colecaoJogo = new ColecaoJogo();
        colecaoJogo.setUsuarioId(colecaoJogoDTO.usuarioId);
        colecaoJogo.setJogoId(colecaoJogoDTO.jogoId);
        colecaoJogo.setStatus(colecaoJogoDTO.status);
        colecaoJogo.setDataInicio(colecaoJogoDTO.dataInicio != null ? colecaoJogoDTO.dataInicio : null);
        colecaoJogo.setDataFim(colecaoJogoDTO.dataInicio != null ? colecaoJogoDTO.dataInicio : null);

        return colecaoJogoRepository.save(colecaoJogo);
    }

    public ColecaoJogo update(ColecaoJogoUpdateDTO colecaoJogoUpdateDTO) {
        ColecaoJogo colecaoExistente = colecaoJogoRepository.findById(colecaoJogoUpdateDTO.id)
                .orElseThrow(() -> new RuntimeException("Coleção não encontrada com o ID: " + colecaoJogoUpdateDTO.id));

        if (colecaoJogoUpdateDTO.usuarioId != null) {
            Usuario usuario = usuarioService.findById(colecaoJogoUpdateDTO.usuarioId);
            colecaoExistente.setUsuarioId(colecaoJogoUpdateDTO.usuarioId);
        }
        if (colecaoJogoUpdateDTO.jogoId != null) {
            Jogo jogo = jogoService.findById(colecaoJogoUpdateDTO.jogoId);
            colecaoExistente.setJogoId(colecaoJogoUpdateDTO.jogoId);
        }
        if (colecaoJogoUpdateDTO.status != null) colecaoExistente.setStatus(colecaoJogoUpdateDTO.status);
        if (colecaoJogoUpdateDTO.dataInicio != null) colecaoExistente.setDataInicio(colecaoJogoUpdateDTO.dataInicio);
        if (colecaoJogoUpdateDTO.dataFim != null) colecaoExistente.setDataFim(colecaoJogoUpdateDTO.dataFim);

        return colecaoJogoRepository.save(colecaoExistente);
    }

    public void delete(Long id) {
        colecaoJogoRepository.deleteById(id);
    }
}
