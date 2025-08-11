package br.com.devance.fonar.extensão;

public class DTOAvaliacaoRiscoResposta {

    // CAMPOS DA CLASSE PRINCIPAL
    private String statusRisco;
    private Integer pontuacao;

    // CONSTRUTORES (sem Lombok)
    public DTOAvaliacaoRiscoResposta() { /* Construtor padrão */ }

    public DTOAvaliacaoRiscoResposta(String statusRisco, Integer pontuacao) {
        this.statusRisco = statusRisco;
        this.pontuacao = pontuacao;
    }

    // GETTERS (sem Lombok)
    public String getStatusRisco() {
        return statusRisco;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    // MÉTODO ESTÁTICO QUE RETORNA O BUILDER
    public static DTOAvaliacaoRiscoRespostaBuilder builder() {
        return new DTOAvaliacaoRiscoRespostaBuilder();
    }

    // CLASSE BUILDER INTERNA E ESTÁTICA
    public static class DTOAvaliacaoRiscoRespostaBuilder {

        // CAMPOS DA CLASSE BUILDER
        private String statusRisco;
        private Integer pontuacao;

        // MÉTODOS DO BUILDER PARA DEFINIR OS VALORES
        public DTOAvaliacaoRiscoRespostaBuilder statusRisco(String statusRisco) {
            this.statusRisco = statusRisco;
            return this;
        }

        public DTOAvaliacaoRiscoRespostaBuilder pontuacao(Integer pontuacao) {
            this.pontuacao = pontuacao;
            return this;
        }

        // MÉTODO FINAL QUE CONSTRÓI O OBJETO
        public DTOAvaliacaoRiscoResposta build() {
            return new DTOAvaliacaoRiscoResposta(statusRisco, pontuacao);
        }
    }
}