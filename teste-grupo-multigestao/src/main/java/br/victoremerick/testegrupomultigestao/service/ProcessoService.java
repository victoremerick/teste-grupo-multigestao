package br.victoremerick.testegrupomultigestao.service;

import br.victoremerick.testegrupomultigestao.database.entity.Processo;
import br.victoremerick.testegrupomultigestao.database.entity.Reu;
import br.victoremerick.testegrupomultigestao.database.repository.ProcessoRepository;
import br.victoremerick.testegrupomultigestao.database.repository.ReuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProcessoService {

    private final ProcessoRepository processoRepository;
    private final ReuRepository reuRepository;

    @Autowired
    public ProcessoService(ProcessoRepository processoRepository, ReuRepository reuRepository) {
        this.processoRepository = processoRepository;
        this.reuRepository = reuRepository;
    }

    @Transactional
    public ResponseEntity<String> salvarProcesso(Processo processo) {
        try {
            Processo existingProcesso = processoRepository.findByNumeroProcesso(processo.getNumeroProcesso());
            if (existingProcesso != null) {
                return ResponseEntity.badRequest().body("Número de processo já cadastrado.");
            }
            processoRepository.save(processo);
            return ResponseEntity.ok("Processo salvo com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao salvar o processo.");
        }
    }

    @Transactional
    public ResponseEntity<String> adicionarReu(String numeroProcesso, Reu reu) {
        try {
            Processo existingProcesso = processoRepository.findByNumeroProcesso(numeroProcesso);
            if (existingProcesso != null) {
                reu.setProcesso(existingProcesso);
                reuRepository.save(reu);
            }else{
                return ResponseEntity.badRequest().body("Número de processo não existe.");
            }
            return ResponseEntity.ok("Reu salvo com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao salvar o reu.");
        }
    }

    public List<Processo> consultarProcessos() {
        return processoRepository.findAll();
    }

    @Transactional
    public ResponseEntity
            <?> excluirProcesso(Long id) {
        try {
            processoRepository.deleteById(id);
            return ResponseEntity.ok("Processo excluído com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao excluir o processo.");
        }
    }

    public Processo findByNumeroProcesso(String numeroProcesso) {
        return processoRepository.findByNumeroProcesso(numeroProcesso);
    }
}

