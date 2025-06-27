package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.TipoAgressaoQ2;
import br.com.devance.fonar.enums.TipoAgressaoQ3;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import lombok.Setter;

import java.util.List;

@Embeddable
public class HistoricoViolenciaFONAR {

    @Column(name = "hist_violencia_ameacou_arma")
    private boolean ameacouArma;

    @Column(name = "hist_violencia_ameacou_faca")
    private boolean ameacouFaca;

    @Column(name = "hist_violencia_ameacou_outra_forma")
    private boolean ameacouOutraForma;

    @Column(name = "hist_violencia_nao_ameacou")
    private boolean naoAmeacou;

    @ElementCollection
    @CollectionTable(name = "fonars_hist_violencia_q2", joinColumns = @JoinColumn(name = "fonar_id"))
    @Column(name = "tipo_agressao_q2")
    @Enumerated(EnumType.STRING)
    private List<TipoAgressaoQ2> agressoesFisicasQ2;

    @ElementCollection
    @CollectionTable(name = "fonars_hist_violencia_q3", joinColumns = @JoinColumn(name = "fonar_id"))
    @Column(name = "tipo_agressao_q3")
    @Enumerated(EnumType.STRING)
    private List<TipoAgressaoQ3> agressoesFisicasQ3;

    @Column(name = "hist_violencia_obrigou_sexo")
    private boolean obrigouSexo;

    @Column(name = "hist_violencia_sentimento_posse")
    private boolean sentimentoPosse;

    @Column(name = "hist_violencia_pertubou_perseguiu_vigiou")
    private boolean pertubouPerseguiuVigiou;

    @Column(name = "hist_violencia_proibiu_visita")
    private boolean proibiuVisita;

    @Column(name = "hist_violencia_proibiu_trabalho_estudo")
    private boolean proibiuTrabalhoEstudo;

    @Column(name = "hist_violencia_contato_insistente")
    private boolean contatoInsistente;

    @Column(name = "hist_violencia_bloqueou_bens")
    private boolean bloqueouBens;

    @Column(name = "hist_violencia_ciumes_e_controle")
    private boolean ciumesEControle;

    @Column(name = "hist_violencia_nenhum_comportamento_acima")
    private boolean nenhumComportamentoAcima;

    @Column(name = "hist_violencia_ja_registrou_bo_antes")
    private boolean jaRegistrouBOAntes;

    @Column(name = "hist_violencia_frequentes_recentemente")
    private boolean frequentesRecentemente;

    public HistoricoViolenciaFONAR() {
    }

    public HistoricoViolenciaFONAR(boolean ameacouArma, boolean ameacouFaca, boolean ameacouOutraForma, boolean naoAmeacou, boolean obrigouSexo, boolean sentimentoPosse, boolean pertubouPerseguiuVigiou,
                                   boolean proibiuVisita, boolean proibiuTrabalhoEstudo, boolean contatoInsistente, boolean bloqueouBens, boolean ciumesEControle, boolean nenhumComportamentoAcima,
                                   boolean jaRegistrouBOAntes, boolean frequentesRecentemente) {

        this.ameacouArma = ameacouArma;
        this.ameacouFaca = ameacouFaca;
        this.ameacouOutraForma = ameacouOutraForma;
        this.naoAmeacou = naoAmeacou;
        this.obrigouSexo = obrigouSexo;
        this.sentimentoPosse = sentimentoPosse;
        this.pertubouPerseguiuVigiou = pertubouPerseguiuVigiou;
        this.proibiuVisita = proibiuVisita;
        this.proibiuTrabalhoEstudo = proibiuTrabalhoEstudo;
        this.contatoInsistente = contatoInsistente;
        this.bloqueouBens = bloqueouBens;
        this.ciumesEControle = ciumesEControle;
        this.nenhumComportamentoAcima = nenhumComportamentoAcima;
        this.jaRegistrouBOAntes = jaRegistrouBOAntes;
        this.frequentesRecentemente = frequentesRecentemente;
    }

    public boolean isAmeacouArma() {
        return ameacouArma;
    }

    public void setAmeacouArma(boolean ameacouArma) {
        this.ameacouArma = ameacouArma;
    }

    public boolean isAmeacouFaca() {
        return ameacouFaca;
    }

    public void setAmeacouFaca(boolean ameacouFaca) {
        this.ameacouFaca = ameacouFaca;
    }

    public boolean isAmeacouOutraForma() {
        return ameacouOutraForma;
    }

    public void setAmeacouOutraForma(boolean ameacouOutraForma) {
        this.ameacouOutraForma = ameacouOutraForma;
    }

    public boolean isNaoAmeacou() {
        return naoAmeacou;
    }

    public void setNaoAmeacou(boolean naoAmeacou) {
        this.naoAmeacou = naoAmeacou;
    }

    public List<TipoAgressaoQ2> getAgressoesFisicasQ2() {
        return agressoesFisicasQ2;
    }

    public void setAgressoesFisicasQ2(List<TipoAgressaoQ2> agressoesFisicasQ2) {
        this.agressoesFisicasQ2 = agressoesFisicasQ2;
    }

    public List<TipoAgressaoQ3> getAgressoesFisicasQ3() {
        return agressoesFisicasQ3;
    }

    public void setAgressoesFisicasQ3(List<TipoAgressaoQ3> agressoesFisicasQ3) {
        this.agressoesFisicasQ3 = agressoesFisicasQ3;
    }

    public boolean isObrigouSexo() {
        return obrigouSexo;
    }

    public void setObrigouSexo(boolean obrigouSexo) {
        this.obrigouSexo = obrigouSexo;
    }

    public boolean isSentimentoPosse() {
        return sentimentoPosse;
    }

    public void setSentimentoPosse(boolean sentimentoPosse) {
        this.sentimentoPosse = sentimentoPosse;
    }

    public boolean isPertubouPerseguiuVigiou() {
        return pertubouPerseguiuVigiou;
    }

    public void setPertubouPerseguiuVigiou(boolean pertubouPerseguiuVigiou) {
        this.pertubouPerseguiuVigiou = pertubouPerseguiuVigiou;
    }

    public boolean isProibiuVisita() {
        return proibiuVisita;
    }

    public void setProibiuVisita(boolean proibiuVisita) {
        this.proibiuVisita = proibiuVisita;
    }

    public boolean isProibiuTrabalhoEstudo() {
        return proibiuTrabalhoEstudo;
    }

    public void setProibiuTrabalhoEstudo(boolean proibiuTrabalhoEstudo) {
        this.proibiuTrabalhoEstudo = proibiuTrabalhoEstudo;
    }

    public boolean isContatoInsistente() {
        return contatoInsistente;
    }

    public void setContatoInsistente(boolean contatoInsistente) {
        this.contatoInsistente = contatoInsistente;
    }

    public boolean isBloqueouBens() {
        return bloqueouBens;
    }

    public void setBloqueouBens(boolean bloqueouBens) {
        this.bloqueouBens = bloqueouBens;
    }

    public boolean isCiumesEControle() {
        return ciumesEControle;
    }

    public void setCiumesEControle(boolean ciumesEControle) {
        this.ciumesEControle = ciumesEControle;
    }

    public boolean isNenhumComportamentoAcima() {
        return nenhumComportamentoAcima;
    }

    public void setNenhumComportamentoAcima(boolean nenhumComportamentoAcima) {
        this.nenhumComportamentoAcima = nenhumComportamentoAcima;
    }

    public boolean isJaRegistrouBOAntes() {
        return jaRegistrouBOAntes;
    }

    public void setJaRegistrouBOAntes(boolean jaRegistrouBOAntes) {
        this.jaRegistrouBOAntes = jaRegistrouBOAntes;
    }

    public boolean isFrequentesRecentemente() {
        return frequentesRecentemente;
    }

    public void setFrequentesRecentemente(boolean frequentesRecentemente) {
        this.frequentesRecentemente = frequentesRecentemente;
    }
}