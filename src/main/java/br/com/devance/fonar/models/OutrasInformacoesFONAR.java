package br.com.devance.fonar.models;

public class OutrasInformacoesFONAR {

    private boolean moraEmLocalDeRisco;
    private boolean desconheceMoraLocalDeRisco;
    private boolean dependenciaFinanceiraAgressor;
    private boolean queAbrigoTemporario;

    public OutrasInformacoesFONAR(boolean moraEmLocalDeRisco, boolean desconheceMoraLocalDeRisco, boolean dependenciaFinanceiraAgressor, boolean queAbrigoTemporario) {
        this.moraEmLocalDeRisco = moraEmLocalDeRisco;
        this.desconheceMoraLocalDeRisco = desconheceMoraLocalDeRisco;
        this.dependenciaFinanceiraAgressor = dependenciaFinanceiraAgressor;
        this.queAbrigoTemporario = queAbrigoTemporario;
    }

    public boolean isMoraEmLocalDeRisco() {
        return moraEmLocalDeRisco;
    }

    public void setMoraEmLocalDeRisco(boolean moraEmLocalDeRisco) {
        this.moraEmLocalDeRisco = moraEmLocalDeRisco;
    }

    public boolean isQueAbrigoTemporario() {
        return queAbrigoTemporario;
    }

    public void setQueAbrigoTemporario(boolean queAbrigoTemporario) {
        this.queAbrigoTemporario = queAbrigoTemporario;
    }

    public boolean isDependenciaFinanceiraAgressor() {
        return dependenciaFinanceiraAgressor;
    }

    public void setDependenciaFinanceiraAgressor(boolean dependenciaFinanceiraAgressor) {
        this.dependenciaFinanceiraAgressor = dependenciaFinanceiraAgressor;
    }

    public boolean isDesconheceMoraLocalDeRisco() {
        return desconheceMoraLocalDeRisco;
    }

    public void setDesconheceMoraLocalDeRisco(boolean desconheceMoraLocalDeRisco) {
        this.desconheceMoraLocalDeRisco = desconheceMoraLocalDeRisco;
    }
}
