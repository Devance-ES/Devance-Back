package br.com.devance.fonar.extensão;

public class DTOEstatisticasRisco {
    private long totalCasos;
    private long casosBaixo;
    private long casosMedio;
    private long casosAlto;

    // Construtor padrão
    public DTOEstatisticasRisco() {}

    // Construtor completo
    public DTOEstatisticasRisco(long totalCasos, long casosBaixo, long casosMedio, long casosAlto) {
        this.totalCasos = totalCasos;
        this.casosBaixo = casosBaixo;
        this.casosMedio = casosMedio;
        this.casosAlto = casosAlto;
    }

    // Getters
    public long getTotalCasos() {
        return totalCasos;
    }

    public long getCasosBaixo() {
        return casosBaixo;
    }

    public long getCasosMedio() {
        return casosMedio;
    }

    public long getCasosAlto() {
        return casosAlto;
    }

    // Padrão Builder
    public static DTOEstatisticasRiscoBuilder builder() {
        return new DTOEstatisticasRiscoBuilder();
    }

    public static class DTOEstatisticasRiscoBuilder {
        private long totalCasos;
        private long casosBaixo;
        private long casosMedio;
        private long casosAlto;

        public DTOEstatisticasRiscoBuilder totalCasos(long totalCasos) {
            this.totalCasos = totalCasos;
            return this;
        }

        public DTOEstatisticasRiscoBuilder casosBaixo(long casosBaixo) {
            this.casosBaixo = casosBaixo;
            return this;
        }

        public DTOEstatisticasRiscoBuilder casosMedio(long casosMedio) {
            this.casosMedio = casosMedio;
            return this;
        }

        public DTOEstatisticasRiscoBuilder casosAlto(long casosAlto) {
            this.casosAlto = casosAlto;
            return this;
        }

        public DTOEstatisticasRisco build() {
            return new DTOEstatisticasRisco(totalCasos, casosBaixo, casosMedio, casosAlto);
        }
    }
}