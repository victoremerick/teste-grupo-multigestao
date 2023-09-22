package br.victoremerick.testegrupomultigestao.database.repository;

import br.victoremerick.testegrupomultigestao.database.entity.Processo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessoRepository extends JpaRepository<Processo, Long> {
    Processo findByNumeroProcesso(String numeroProcesso);
}

