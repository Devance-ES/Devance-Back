package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.CorRaca;
import br.com.devance.fonar.enums.FaixaEtariaFilhos;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import java.util.List;

@Embeddable
public class SobreVitimaFONAR
{
    @Column(name = "vitima_tem_filhos_com_agressor")
    private boolean temFilhosComAgressor;

    @Column(name = "vitima_qtd_filhos")
    private int qtdFilhos;

    @Column(name = "vitima_filho_fora_rel")
    private boolean filhoForaRel;

    @Column(name = "vitima_qtd_filhos_fora")
    private int qtdFilhosFora;

    @Column(name = "vitima_nao_tem_filhos")
    private boolean naoTemFilhos;

    @ElementCollection
    @CollectionTable(name = "fonars_vitima_faixa_etaria_filhos", joinColumns = @JoinColumn(name = "fonar_id"))
    @Column(name = "faixa_etaria")
    @Enumerated(EnumType.STRING)
    private List<FaixaEtariaFilhos> faixaEtariaFilhos;

    @Column(name = "vitima_tem_filhos_deficientes")
    private boolean temFilhosDeficientes;

    @Column(name = "vitima_qtd_filhos_deficiencia")
    private int qtdFilhosDeficiencia;

    @Column(name = "vitima_conflito_de_guarda")
    private boolean conflitoDeGuarda;

    @Column(name = "vitima_filhos_viram_violencia")
    private boolean filhosViramViolencia;

    @Column(name = "vitima_violencia_gravidez_pos_parto")
    private boolean violenciaGravidezPosParto;

    @Column(name = "vitima_novo_rel_aumenta_violencia")
    private boolean novoRelAumentaViolencia;

    @Column(name = "vitima_possui_deficiencia")
    private boolean possuiDeficiencia;

    @Column(name = "vitima_qual_deficiencia", length = 255)
    private String qualDeficiencia;

    @Column(name = "vitima_cor_raca")
    @Enumerated(EnumType.STRING)
    private CorRaca corRaca;

    public SobreVitimaFONAR() {
    }

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