package br.com.devance.fonar.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class OutrasInformacoesFONAR {

    @Column(name = "mora_em_local_de_risco")
    private boolean moraEmLocalDeRisco;

    @Column(name = "desconhece_mora_local_de_risco")
    private boolean desconheceMoraLocalDeRisco;

    @Column(name = "dependencia_financeira_agressor")
    private boolean dependenciaFinanceiraAgressor;

    @Column(name = "quer_abrigo_temporario")
    private boolean queAbrigoTemporario;

    public OutrasInformacoesFONAR() {
    }

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