package br.com.devance.fonar.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public class Estatisticas
{
    private UUID idEstatistica;
    private String nomeRelatorio;
    private LocalDateTime dataGeracao;
    private LocalDate periodoInicio;
    private LocalDate periodoFim;
    private Map<String, Object> dadosGerados;
    private Usuario geradoPor;

    public Estatisticas(UUID idEstatistica, String nomeRelatorio, LocalDateTime dataGeracao, LocalDate periodoInicio,
                        LocalDate periodoFim, Map<String, Object> dadosGerados, Usuario geradoPor) {
        this.idEstatistica = idEstatistica;
        this.nomeRelatorio = nomeRelatorio;
        this.dataGeracao = dataGeracao;
        this.periodoInicio = periodoInicio;
        this.periodoFim = periodoFim;
        this.dadosGerados = dadosGerados;
        this.geradoPor = geradoPor;
    }

    public UUID getIdEstatistica() {
        return idEstatistica;
    }

    public void setIdEstatistica(UUID idEstatistica) {
        this.idEstatistica = idEstatistica;
    }

    public String getNomeRelatorio() {
        return nomeRelatorio;
    }

    public void setNomeRelatorio(String nomeRelatorio) {
        this.nomeRelatorio = nomeRelatorio;
    }

    public LocalDateTime getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(LocalDateTime dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public LocalDate getPeriodoInicio() {
        return periodoInicio;
    }

    public void setPeriodoInicio(LocalDate periodoInicio) {
        this.periodoInicio = periodoInicio;
    }

    public LocalDate getPeriodoFim() {
        return periodoFim;
    }

    public void setPeriodoFim(LocalDate periodoFim) {
        this.periodoFim = periodoFim;
    }

    public Map<String, Object> getDadosGerados() {
        return dadosGerados;
    }

    public void setDadosGerados(Map<String, Object> dadosGerados) {
        this.dadosGerados = dadosGerados;
    }

    public Usuario getGeradoPor() {
        return geradoPor;
    }

    public void setGeradoPor(Usuario geradoPor) {
        this.geradoPor = geradoPor;
    }

    //Métodos da classe FONAR

    public void gerarPorIdadeVitima() {}

    public void gerarPorIdadeAgressor() {}

    public void gerarPorEscolaridadeVitima() {}

    public void gerarPorEscolaridadeAgressor() {}

    public void gerarPorData(LocalDate dataInicio, LocalDate dataFim) {}

    public void gerarPorGravidadeDenuncia() {}

}
