package br.com.devance.fonar.extensão;

import br.com.devance.fonar.excecoes.ExcecaoRecursoNaoEncontrado;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicoRisco {

    private final RepositorioRiscoFonar repositorioRiscoFonar;
    private final ServicoNotificacao servicoNotificacao;

    public ServicoRisco(RepositorioRiscoFonar repositorioRiscoFonar, ServicoNotificacao servicoNotificacao) {
        this.repositorioRiscoFonar = repositorioRiscoFonar;
        this.servicoNotificacao = servicoNotificacao;
    }

    /**
     * @UseCase Avaliar Risco Preditivo do FONAR (UC01)
     */
    public DTOAvaliacaoRiscoResposta avaliarRisco(DTOAvaliacaoRisco request) {
        if (request.getCpfVitima() == null || request.getCpfVitima().isEmpty() ||
                request.getNomeAgressor() == null || request.getNomeAgressor().isEmpty() ||
                request.getFrequenciaViolencia() == null) {
            return DTOAvaliacaoRiscoResposta.builder().statusRisco("Sem dados suficientes").build();
        }

        int score = calcularPontuacao(request);
        StatusRisco statusRisco = determinarStatusRisco(score);

        RiscoFonar riscoFonar = RiscoFonar.builder()
                .cpfVitima(request.getCpfVitima())
                .cpfAgressor(request.getCpfAgressor())
                .dataAvaliacao(LocalDateTime.now())
                .pontuacaoRisco(score)
                .statusRisco(statusRisco)
                .build();

        repositorioRiscoFonar.save(riscoFonar);

        return DTOAvaliacaoRiscoResposta.builder()
                .statusRisco(statusRisco.getDescricao())
                .pontuacao(score)
                .build();
    }

    /**
     * @UseCase Reavaliar Risco de FONAR Existente (UC03)
     */
    public DTOAvaliacaoRiscoResposta reavaliarRisco(Long id, DTOAvaliacaoRisco request) {
        RiscoFonar riscoExistente = repositorioRiscoFonar.findById(id)
                .orElseThrow(() -> new ExcecaoRecursoNaoEncontrado("Avaliação de risco com o ID " + id + " não encontrada."));

        int score = calcularPontuacao(request);
        StatusRisco statusRisco = determinarStatusRisco(score);

        riscoExistente.setCpfVitima(request.getCpfVitima());
        riscoExistente.setCpfAgressor(request.getCpfAgressor());
        riscoExistente.setPontuacaoRisco(score);
        riscoExistente.setStatusRisco(statusRisco);
        riscoExistente.setDataAvaliacao(LocalDateTime.now());

        repositorioRiscoFonar.save(riscoExistente);

        return DTOAvaliacaoRiscoResposta.builder()
                .statusRisco(statusRisco.getDescricao())
                .pontuacao(score)
                .build();
    }

    /**
     * @UseCase Análise Estatística de Casos de Risco (UC04)
     */
    public DTOEstatisticasRisco gerarEstatisticas() {
        long totalCasos = repositorioRiscoFonar.count();
        long casosBaixo = repositorioRiscoFonar.countByStatusRisco(StatusRisco.BAIXO);
        long casosMedio = repositorioRiscoFonar.countByStatusRisco(StatusRisco.MEDIO);
        long casosAlto = repositorioRiscoFonar.countByStatusRisco(StatusRisco.ALTO);

        return DTOEstatisticasRisco.builder()
                .totalCasos(totalCasos)
                .casosBaixo(casosBaixo)
                .casosMedio(casosMedio)
                .casosAlto(casosAlto)
                .build();
    }

    /**
     * @UseCase Consulta de Histórico de Risco (UC05)
     */
    public List<DTOHistoricoRisco> consultarHistoricoAgressor(String cpfAgressor, String ordenarPor) {
        Sort sort;
        if ("data".equalsIgnoreCase(ordenarPor)) {
            sort = Sort.by(Sort.Direction.DESC, "dataAvaliacao");
        } else {
            sort = Sort.by(Sort.Direction.DESC, "statusRisco");
        }

        List<RiscoFonar> riscos = repositorioRiscoFonar.findByCpfAgressor(cpfAgressor, sort);

        return riscos.stream()
                .map(risco -> DTOHistoricoRisco.builder()
                        .id(risco.getId())
                        .cpfAgressor(risco.getCpfAgressor())
                        .dataAvaliacao(risco.getDataAvaliacao())
                        .statusRisco(risco.getStatusRisco().getDescricao())
                        .pontuacaoRisco(risco.getPontuacaoRisco())
                        .build())
                .collect(Collectors.toList());
    }

    private int calcularPontuacao(DTOAvaliacaoRisco request) {
        int score = 0;
        if ("Diária".equalsIgnoreCase(request.getFrequenciaViolencia())) {
            score += 10;
        } else if ("Semanal".equalsIgnoreCase(request.getFrequenciaViolencia())) {
            score += 5;
        }
        if (Boolean.TRUE.equals(request.getAgressorArmado())) {
            score += 20;
        }
        if (Boolean.TRUE.equals(request.getAgressorAmeacaMorte())) {
            score += 15;
        }
        return score;
    }

    private StatusRisco determinarStatusRisco(int score) {
        if (score > 25) {
            return StatusRisco.ALTO;
        } else if (score > 10) {
            return StatusRisco.MEDIO;
        } else {
            return StatusRisco.BAIXO;
        }
    }

    /**
     * @UseCase Disparar Notificação de Risco Elevado (UC02)
     */
    public void dispararNotificacaoRisco(Long idFonar, int pontuacaoRisco) {
        servicoNotificacao.notificarRiscoElevado(idFonar, pontuacaoRisco);
    }

    public List<RiscoFonar> listarTodosOsRiscos() {
        return repositorioRiscoFonar.findAll();
    }

    public RiscoFonar buscarRiscoPorId(Long id) {
        Optional<RiscoFonar> risco = repositorioRiscoFonar.findById(id);
        if (risco.isEmpty()) {
            throw new ExcecaoRecursoNaoEncontrado("Avaliação de risco com o ID " + id + " não encontrada.");
        }
        return risco.get();
    }
}