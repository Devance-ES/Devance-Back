package br.com.devance.fonar.extensão;

import br.com.devance.fonar.excecoes.ExcecaoRecursoNaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/v1/risco")
public class ControladorRisco {

    private final ServicoRisco riscoService;

    public ControladorRisco(ServicoRisco riscoService) {
        this.riscoService = riscoService;
    }

    /**
     * @UseCase Avaliar Risco Preditivo do FONAR (UC01)
     */
    @PostMapping("/avaliar")
    public ResponseEntity<DTOAvaliacaoRiscoResposta> avaliar(@Valid @RequestBody DTOAvaliacaoRisco request) {
        try {
            DTOAvaliacaoRiscoResposta resposta = riscoService.avaliarRisco(request);

            if ("Alto".equals(resposta.getStatusRisco())) {
                riscoService.dispararNotificacaoRisco(request.getIdFonar(), resposta.getPontuacao());
            }

            if ("Sem dados suficientes".equals(resposta.getStatusRisco())) {
                return ResponseEntity.badRequest().body(resposta);
            }
            return ResponseEntity.ok(resposta);
        } catch (ExcecaoRecursoNaoEncontrado e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(DTOAvaliacaoRiscoResposta.builder().statusRisco("Erro de validação: " + e.getMessage()).build());
        }
    }

    /**
     * @UseCase Reavaliar Risco de FONAR Existente (UC03)
     */
    @PutMapping("/reavaliar/{id}")
    public ResponseEntity<DTOAvaliacaoRiscoResposta> reavaliar(@PathVariable Long id, @Valid @RequestBody DTOAvaliacaoRisco request) {
        try {
            DTOAvaliacaoRiscoResposta resposta = riscoService.reavaliarRisco(id, request);
            if ("Alto".equals(resposta.getStatusRisco())) {
                riscoService.dispararNotificacaoRisco(id, resposta.getPontuacao());
            }
            return ResponseEntity.ok(resposta);
        } catch (ExcecaoRecursoNaoEncontrado e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    /**
     * @UseCase Análise Estatística de Casos de Risco (UC04)
     */
    @GetMapping("/estatisticas")
    public ResponseEntity<DTOEstatisticasRisco> obterEstatisticas() {
        DTOEstatisticasRisco estatisticas = riscoService.gerarEstatisticas();
        return ResponseEntity.ok(estatisticas);
    }

    /**
     * @UseCase Consulta de Histórico de Risco (UC05)
     */
    @GetMapping("/historico/{cpfAgressor}")
    public ResponseEntity<List<DTOHistoricoRisco>> consultarHistorico(
            @PathVariable String cpfAgressor,
            @RequestParam(required = false, defaultValue = "risco") String ordenarPor) {
        try {
            List<DTOHistoricoRisco> historico = riscoService.consultarHistoricoAgressor(cpfAgressor, ordenarPor);
            if (historico.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(historico);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Endpoint para buscar todas as avaliações de risco salvas.
     */
    @GetMapping
    public ResponseEntity<List<RiscoFonar>> listarTodos() {
        List<RiscoFonar> riscos = riscoService.listarTodosOsRiscos();
        if (riscos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(riscos);
    }

    /**
     * Endpoint para buscar uma avaliação de risco por ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<RiscoFonar> buscarPorId(@PathVariable Long id) {
        RiscoFonar risco = riscoService.buscarRiscoPorId(id);
        return ResponseEntity.ok(risco);
    }
}