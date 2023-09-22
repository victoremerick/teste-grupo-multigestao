package br.victoremerick.testegrupomultigestao.controller;

import br.victoremerick.testegrupomultigestao.database.entity.Processo;
import br.victoremerick.testegrupomultigestao.service.ProcessoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class ProcessoControllerUnitTest {

    @InjectMocks
    private ProcessoController processoController;

    @Mock
    private ProcessoService processoService;

    @Test
    void salvarProcesso_DeveRetornarSucesso_QuandoProcessoNaoExiste() {
        Processo processo = new Processo();
        processo.setNumeroProcesso("12345");

        when(processoService.salvarProcesso(processo)).thenReturn(ResponseEntity.ok("Processo salvo com sucesso."));

        ResponseEntity<?> responseEntity = processoController.salvarProcesso(processo);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("Processo salvo com sucesso.", responseEntity.getBody());
    }

    @Test
    void salvarProcesso_DeveRetornarErro_QuandoProcessoJaExiste() {
        Processo processo = new Processo();
        processo.setNumeroProcesso("12345");

        when(processoService.salvarProcesso(processo)).thenReturn(ResponseEntity.badRequest().body("Número de processo já cadastrado."));

        ResponseEntity<?> responseEntity = processoController.salvarProcesso(processo);

        assertEquals(400, responseEntity.getStatusCodeValue());
        assertEquals("Número de processo já cadastrado.", responseEntity.getBody());
    }
}

