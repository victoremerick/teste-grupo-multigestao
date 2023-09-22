package br.victoremerick.testegrupomultigestao.database.repository;

import br.victoremerick.testegrupomultigestao.database.entity.Processo;
import br.victoremerick.testegrupomultigestao.database.entity.Reu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReuRepository extends JpaRepository<Reu, Long> {
}

