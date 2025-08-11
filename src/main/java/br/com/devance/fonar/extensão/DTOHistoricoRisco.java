package br.com.devance.fonar.extensão;

import java.time.LocalDateTime;

public class DTOHistoricoRisco {
    private Long id;
    private String cpfAgressor;
    private LocalDateTime dataAvaliacao;
    private String statusRisco;
    private Integer pontuacaoRisco;

    // Construtor padrão
    public DTOHistoricoRisco() {}

    // Construtor completo
    public DTOHistoricoRisco(Long id, String cpfAgressor, LocalDateTime dataAvaliacao, String statusRisco, Integer pontuacaoRisco) {
        this.id = id;
        this.cpfAgressor = cpfAgressor;
        this.dataAvaliacao = dataAvaliacao;
        this.statusRisco = statusRisco;
        this.pontuacaoRisco = pontuacaoRisco;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getCpfAgressor() {
        return cpfAgressor;
    }

    public LocalDateTime getDataAvaliacao() {
        return dataAvaliacao;
    }

    public String getStatusRisco() {
        return statusRisco;
    }

    public Integer getPontuacaoRisco() {
        return pontuacaoRisco;
    }

    // Padrão Builder
    public static DTOHistoricoRiscoBuilder builder() {
        return new DTOHistoricoRiscoBuilder();
    }

    public static class DTOHistoricoRiscoBuilder {
        private Long id;
        private String cpfAgressor;
        private LocalDateTime dataAvaliacao;
        private String statusRisco;
        private Integer pontuacaoRisco;

        public DTOHistoricoRiscoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public DTOHistoricoRiscoBuilder cpfAgressor(String cpfAgressor) {
            this.cpfAgressor = cpfAgressor;
            return this;
        }

        public DTOHistoricoRiscoBuilder dataAvaliacao(LocalDateTime dataAvaliacao) {
            this.dataAvaliacao = dataAvaliacao;
            return this;
        }

        public DTOHistoricoRiscoBuilder statusRisco(String statusRisco) {
            this.statusRisco = statusRisco;
            return this;
        }

        public DTOHistoricoRiscoBuilder pontuacaoRisco(Integer pontuacaoRisco) {
            this.pontuacaoRisco = pontuacaoRisco;
            return this;
        }

        public DTOHistoricoRisco build() {
            return new DTOHistoricoRisco(id, cpfAgressor, dataAvaliacao, statusRisco, pontuacaoRisco);
        }
    }
}