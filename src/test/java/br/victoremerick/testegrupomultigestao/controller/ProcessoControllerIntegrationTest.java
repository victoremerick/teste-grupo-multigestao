package br.victoremerick.testegrupomultigestao.controller;

import br.victoremerick.testegrupomultigestao.database.entity.Processo;
import br.victoremerick.testegrupomultigestao.service.ProcessoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProcessoControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProcessoService processoService;

    public void limparRegistros(){
        processoService.consultarProcessos()
                .forEach(processo -> processoService.excluirProcesso(processo.getId()));
    }

    @Test
    void salvarProcesso_DeveRetornarSucesso_QuandoProcessoNaoExiste() {
        limparRegistros();
        String url = "/processos";
        Processo processo = new Processo();
        processo.setNumeroProcesso("12345");

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, processo, String.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Processo salvo com sucesso.", responseEntity.getBody());
    }

    @Test
    void salvarProcesso_DeveRetornarErro_QuandoProcessoJaExiste() {
        limparRegistros();
        String url = "/processos";
        Processo processo = new Processo();
        processo.setNumeroProcesso("12345");

        ResponseEntity<String> responseEntity1 = restTemplate.postForEntity(url, processo, String.class);

        assertEquals(HttpStatus.OK, responseEntity1.getStatusCode());
        assertEquals("Processo salvo com sucesso.", responseEntity1.getBody());

        ResponseEntity<String> responseEntity2 = restTemplate.postForEntity(url, processo, String.class);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity2.getStatusCode());
        assertEquals("Número de processo já cadastrado.", responseEntity2.getBody());
    }

    // Testes similares podem ser escritos para os demais métodos do controller
}

