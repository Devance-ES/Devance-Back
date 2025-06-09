package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.CorRaca;
import br.com.devance.fonar.enums.FaixaEtariaFilhos;

import java.util.List;

public class SobreVitimaFONAR
{
    // 1. Informações sobre Filhos
    private boolean temFilhosComAgressor;

    private int qtdFilhos; // Quantidade total de filhos (com ou sem agressor)

    private boolean filhoForaRel; // Se tem filhos de outros relacionamentos

    private int qtdFilhosFora; // Quantidade de filhos de outros relacionamentos

    private boolean naoTemFilhos;

    private List<FaixaEtariaFilhos> faixaEtariaFilhos;

    private boolean temFilhosDeficientes;

    private int qtdFilhosDeficiencia;

    private boolean conflitoDeGuarda;

    private boolean filhosViramViolencia;

    // 2. Condição da Vítima (Violência em contextos específicos)
    private boolean violenciaGravidezPosParto; // Violência ocorrida durante gravidez ou pós-parto

    private boolean novoRelAumentaViolencia; // Se o novo relacionamento da vítima aumentou a violência

    // 3. Condição Física e Demográfica da Vítima
    private boolean possuiDeficiencia; // Se a própria vítima possui deficiência

    private String qualDeficiencia; // Descrição da deficiência, se houver

    private CorRaca corRaca;

    public SobreVitimaFONAR(boolean temFilhosComAgressor, int qtdFilhos, boolean filhoForaRel, int qtdFilhosFora,
                            boolean naoTemFilhos, List<FaixaEtariaFilhos> faixaEtariaFilhos,
                            boolean temFilhosDeficientes, int qtdFilhosDeficiencia, boolean conflitoDeGuarda,
                            boolean filhosViramViolencia, boolean violenciaGravidezPosParto,
                            boolean novoRelAumentaViolencia, boolean possuiDeficiencia, String qualDeficiencia,
                            CorRaca corRaca)
    {
        this.temFilhosComAgressor = temFilhosComAgressor;
        this.qtdFilhos = qtdFilhos;
        this.filhoForaRel = filhoForaRel;
        this.qtdFilhosFora = qtdFilhosFora;
        this.naoTemFilhos = naoTemFilhos;
        this.faixaEtariaFilhos = faixaEtariaFilhos;
        this.temFilhosDeficientes = temFilhosDeficientes;
        this.qtdFilhosDeficiencia = qtdFilhosDeficiencia;
        this.conflitoDeGuarda = conflitoDeGuarda;
        this.filhosViramViolencia = filhosViramViolencia;
        this.violenciaGravidezPosParto = violenciaGravidezPosParto;
        this.novoRelAumentaViolencia = novoRelAumentaViolencia;
        this.possuiDeficiencia = possuiDeficiencia;
        this.qualDeficiencia = qualDeficiencia;
        this.corRaca = corRaca;
    }

    public boolean isTemFilhosComAgressor() {
        return temFilhosComAgressor;
    }

    public void setTemFilhosComAgressor(boolean temFilhosComAgressor) {
        this.temFilhosComAgressor = temFilhosComAgressor;
    }

    public int getQtdFilhos() {
        return qtdFilhos;
    }

    public void setQtdFilhos(int qtdFilhos) {
        this.qtdFilhos = qtdFilhos;
    }

    public boolean isFilhoForaRel() {
        return filhoForaRel;
    }

    public void setFilhoForaRel(boolean filhoForaRel) {
        this.filhoForaRel = filhoForaRel;
    }

    public int getQtdFilhosFora() {
        return qtdFilhosFora;
    }

    public void setQtdFilhosFora(int qtdFilhosFora) {
        this.qtdFilhosFora = qtdFilhosFora;
    }

    public boolean isNaoTemFilhos() {
        return naoTemFilhos;
    }

    public void setNaoTemFilhos(boolean naoTemFilhos) {
        this.naoTemFilhos = naoTemFilhos;
    }

    public List<FaixaEtariaFilhos> getFaixaEtariaFilhos() {
        return faixaEtariaFilhos;
    }

    public void setFaixaEtariaFilhos(List<FaixaEtariaFilhos> faixaEtariaFilhos) {
        this.faixaEtariaFilhos = faixaEtariaFilhos;
    }

    public boolean isTemFilhosDeficientes() {
        return temFilhosDeficientes;
    }

    public void setTemFilhosDeficientes(boolean temFilhosDeficientes) {
        this.temFilhosDeficientes = temFilhosDeficientes;
    }

    public int getQtdFilhosDeficiencia() {
        return qtdFilhosDeficiencia;
    }

    public void setQtdFilhosDeficiencia(int qtdFilhosDeficiencia) {
        this.qtdFilhosDeficiencia = qtdFilhosDeficiencia;
    }

    public boolean isConflitoDeGuarda() {
        return conflitoDeGuarda;
    }

    public void setConflitoDeGuarda(boolean conflitoDeGuarda) {
        this.conflitoDeGuarda = conflitoDeGuarda;
    }

    public boolean isFilhosViramViolencia() {
        return filhosViramViolencia;
    }

    public void setFilhosViramViolencia(boolean filhosViramViolencia) {
        this.filhosViramViolencia = filhosViramViolencia;
    }

    public boolean isViolenciaGravidezPosParto() {
        return violenciaGravidezPosParto;
    }

    public void setViolenciaGravidezPosParto(boolean violenciaGravidezPosParto) {
        this.violenciaGravidezPosParto = violenciaGravidezPosParto;
    }

    public boolean isNovoRelAumentaViolencia() {
        return novoRelAumentaViolencia;
    }

    public void setNovoRelAumentaViolencia(boolean novoRelAumentaViolencia) {
        this.novoRelAumentaViolencia = novoRelAumentaViolencia;
    }

    public boolean isPossuiDeficiencia() {
        return possuiDeficiencia;
    }

    public void setPossuiDeficiencia(boolean possuiDeficiencia) {
        this.possuiDeficiencia = possuiDeficiencia;
    }

    public String getQualDeficiencia() {
        return qualDeficiencia;
    }

    public void setQualDeficiencia(String qualDeficiencia) {
        this.qualDeficiencia = qualDeficiencia;
    }

    public CorRaca getCorRaca() {
        return corRaca;
    }

    public void setCorRaca(CorRaca corRaca) {
        this.corRaca = corRaca;
    }
}
