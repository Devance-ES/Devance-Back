package br.com.devance.fonar.extensão;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "riscos_fonar")
public class RiscoFonar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf_vitima")
    private String cpfVitima;

    @Column(name = "cpf_agressor")
    private String cpfAgressor;

    @Column(name = "pontuacao_risco")
    private Integer pontuacaoRisco;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_risco")
    private StatusRisco statusRisco;

    @Column(name = "data_avaliacao")
    private LocalDateTime dataAvaliacao;

    // Construtor padrão necessário pelo JPA
    public RiscoFonar() {}

    // Construtor completo
    public RiscoFonar(Long id, String cpfVitima, String cpfAgressor, Integer pontuacaoRisco, StatusRisco statusRisco, LocalDateTime dataAvaliacao) {
        this.id = id;
        this.cpfVitima = cpfVitima;
        this.cpfAgressor = cpfAgressor;
        this.pontuacaoRisco = pontuacaoRisco;
        this.statusRisco = statusRisco;
        this.dataAvaliacao = dataAvaliacao;
    }

    // Getters
    public Long getId() { return id; }
    public String getCpfVitima() { return cpfVitima; }
    public String getCpfAgressor() { return cpfAgressor; }
    public Integer getPontuacaoRisco() { return pontuacaoRisco; }
    public StatusRisco getStatusRisco() { return statusRisco; }
    public LocalDateTime getDataAvaliacao() { return dataAvaliacao; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setCpfVitima(String cpfVitima) { this.cpfVitima = cpfVitima; }
    public void setCpfAgressor(String cpfAgressor) { this.cpfAgressor = cpfAgressor; }
    public void setPontuacaoRisco(Integer pontuacaoRisco) { this.pontuacaoRisco = pontuacaoRisco; }
    public void setStatusRisco(StatusRisco statusRisco) { this.statusRisco = statusRisco; }
    public void setDataAvaliacao(LocalDateTime dataAvaliacao) { this.dataAvaliacao = dataAvaliacao; }

    // Padrão Builder
    public static RiscoFonarBuilder builder() {
        return new RiscoFonarBuilder();
    }

    public static class RiscoFonarBuilder {
        private Long id;
        private String cpfVitima;
        private String cpfAgressor;
        private Integer pontuacaoRisco;
        private StatusRisco statusRisco;
        private LocalDateTime dataAvaliacao;

        public RiscoFonarBuilder id(Long id) { this.id = id; return this; }
        public RiscoFonarBuilder cpfVitima(String cpfVitima) { this.cpfVitima = cpfVitima; return this; }
        public RiscoFonarBuilder cpfAgressor(String cpfAgressor) { this.cpfAgressor = cpfAgressor; return this; }
        public RiscoFonarBuilder pontuacaoRisco(Integer pontuacaoRisco) { this.pontuacaoRisco = pontuacaoRisco; return this; }
        public RiscoFonarBuilder statusRisco(StatusRisco statusRisco) { this.statusRisco = statusRisco; return this; }
        public RiscoFonarBuilder dataAvaliacao(LocalDateTime dataAvaliacao) { this.dataAvaliacao = dataAvaliacao; return this; }

        public RiscoFonar build() {
            return new RiscoFonar(id, cpfVitima, cpfAgressor, pontuacaoRisco, statusRisco, dataAvaliacao);
        }
    }
}