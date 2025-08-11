package br.com.devance.fonar.extensão;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DTOAvaliacaoRisco {

    private Long idFonar;

    @NotBlank(message = "O CPF da vítima é obrigatório.")
    private String cpfVitima;

    @NotBlank(message = "O CPF do agressor é obrigatório.")
    private String cpfAgressor;

    @NotBlank(message = "O nome do agressor é obrigatório.")
    private String nomeAgressor;

    @NotNull(message = "A indicação se o agressor possui arma é obrigatória.")
    private Boolean agressorArmado;

    @NotNull(message = "A indicação se o agressor ameaça de morte é obrigatória.")
    private Boolean agressorAmeacaMorte;

    @NotBlank(message = "A frequência da violência é obrigatória.")
    private String frequenciaViolencia;

    // Construtor padrão
    public DTOAvaliacaoRisco() {}

    // Getters
    public Long getIdFonar() { return idFonar; }
    public String getCpfVitima() { return cpfVitima; }
    public String getCpfAgressor() { return cpfAgressor; }
    public String getNomeAgressor() { return nomeAgressor; }
    public Boolean getAgressorArmado() { return agressorArmado; }
    public Boolean getAgressorAmeacaMorte() { return agressorAmeacaMorte; }
    public String getFrequenciaViolencia() { return frequenciaViolencia; }

    // Setters
    public void setIdFonar(Long idFonar) { this.idFonar = idFonar; }
    public void setCpfVitima(String cpfVitima) { this.cpfVitima = cpfVitima; }
    public void setCpfAgressor(String cpfAgressor) { this.cpfAgressor = cpfAgressor; }
    public void setNomeAgressor(String nomeAgressor) { this.nomeAgressor = nomeAgressor; }
    public void setAgressorArmado(Boolean agressorArmado) { this.agressorArmado = agressorArmado; }
    public void setAgressorAmeacaMorte(Boolean agressorAmeacaMorte) { this.agressorAmeacaMorte = agressorAmeacaMorte; }
    public void setFrequenciaViolencia(String frequenciaViolencia) { this.frequenciaViolencia = frequenciaViolencia; }

    // Padrão Builder
    public static DTOAvaliacaoRiscoBuilder builder() { return new DTOAvaliacaoRiscoBuilder(); }

    public static class DTOAvaliacaoRiscoBuilder {
        private Long idFonar;
        private String cpfVitima;
        private String cpfAgressor;
        private String nomeAgressor;
        private Boolean agressorArmado;
        private Boolean agressorAmeacaMorte;
        private String frequenciaViolencia;

        public DTOAvaliacaoRiscoBuilder idFonar(Long idFonar) { this.idFonar = idFonar; return this; }
        public DTOAvaliacaoRiscoBuilder cpfVitima(String cpfVitima) { this.cpfVitima = cpfVitima; return this; }
        public DTOAvaliacaoRiscoBuilder cpfAgressor(String cpfAgressor) { this.cpfAgressor = cpfAgressor; return this; }
        public DTOAvaliacaoRiscoBuilder nomeAgressor(String nomeAgressor) { this.nomeAgressor = nomeAgressor; return this; }
        public DTOAvaliacaoRiscoBuilder agressorArmado(Boolean agressorArmado) { this.agressorArmado = agressorArmado; return this; }
        public DTOAvaliacaoRiscoBuilder agressorAmeacaMorte(Boolean agressorAmeacaMorte) { this.agressorAmeacaMorte = agressorAmeacaMorte; return this; }
        public DTOAvaliacaoRiscoBuilder frequenciaViolencia(String frequenciaViolencia) { this.frequenciaViolencia = frequenciaViolencia; return this; }

        public DTOAvaliacaoRisco build() {
            DTOAvaliacaoRisco dto = new DTOAvaliacaoRisco();
            dto.idFonar = this.idFonar;
            dto.cpfVitima = this.cpfVitima;
            dto.cpfAgressor = this.cpfAgressor;
            dto.nomeAgressor = this.nomeAgressor;
            dto.agressorArmado = this.agressorArmado;
            dto.agressorAmeacaMorte = this.agressorAmeacaMorte;
            dto.frequenciaViolencia = this.frequenciaViolencia;
            return dto;
        }
    }
}