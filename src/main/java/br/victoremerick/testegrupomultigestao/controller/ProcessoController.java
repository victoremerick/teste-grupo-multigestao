package br.victoremerick.testegrupomultigestao.controller;

import br.victoremerick.testegrupomultigestao.database.entity.Processo;
import br.victoremerick.testegrupomultigestao.database.entity.Reu;
import br.victoremerick.testegrupomultigestao.service.ProcessoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/processos")
public class ProcessoController {

    private final ProcessoService processoService;

    @Autowired
    public ProcessoController(ProcessoService processoService) {
        this.processoService = processoService;
    }

    @PostMapping
    @Operation(summary = "Salvar um novo número de processo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Processo salvo com sucesso"),
            @ApiResponse(responseCode = "400", description = "Número de processo já cadastrado",
                    content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar o processo",
                    content = @Content(schema = @Schema(implementation = String.class)))
    })
    public ResponseEntity<?> salvarProcesso(@RequestBody Processo processo) {
        return processoService.salvarProcesso(processo);
    }

    @GetMapping
    @Operation(summary = "Consultar todos os números de processos salvos")
    public List<Processo> consultarProcessos() {
        return processoService.consultarProcessos();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir um número de processo por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Processo excluído com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao excluir o processo",
                    content = @Content(schema = @Schema(implementation = String.class)))
    })
    public ResponseEntity<?> excluirProcesso(@PathVariable Long id) {
        return processoService.excluirProcesso(id);
    }

    @PostMapping("/{numeroProcesso}/adicionar-reu")
    @Operation(summary = "Adicionar um réu a um processo existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Réu adicionado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Processo não encontrado",
                    content = @Content(schema = @Schema(implementation = String.class)))
    })
    public ResponseEntity<?> adicionarReu(@PathVariable String numeroProcesso, @RequestBody Reu reu) {
        return processoService.adicionarReu(numeroProcesso, reu);
    }
}

