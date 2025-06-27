package br.com.devance.fonar.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PreenchimentoProfissionalFONAR {

    @Column(name = "preenchimento_sem_ajuda")
    private boolean preenchimentoSemAjuda;

    @Column(name = "preenchimento_com_ajuda")
    private boolean preenchimentoComAjuda;

    @Column(name = "vitima_sem_condicoes_responder")
    private boolean vitimaSemCondicoesResponder;

    @Column(name = "vitima_recusou_responder")
    private boolean vitimaRecusouResponder;

    @Column(name = "terceiro_comunicante_preencheu")
    private boolean terceiroComunicantePreencheu;

    public PreenchimentoProfissionalFONAR() {
    }

    public PreenchimentoProfissionalFONAR(boolean preenchimentoSemAjuda, boolean preenchimentoComAjuda, boolean vitimaSemCondicoesResponder,
                                          boolean vitimaRecusouResponder, boolean terceiroComunicantePreencheu) {

        this.preenchimentoSemAjuda = preenchimentoSemAjuda;
        this.preenchimentoComAjuda = preenchimentoComAjuda;
        this.vitimaSemCondicoesResponder = vitimaSemCondicoesResponder;
        this.vitimaRecusouResponder = vitimaRecusouResponder;
        this.terceiroComunicantePreencheu = terceiroComunicantePreencheu;
    }

    public boolean isPreenchimentoSemAjuda() {
        return preenchimentoSemAjuda;
    }

    public void setPreenchimentoSemAjuda(boolean preenchimentoSemAjuda) {
        this.preenchimentoSemAjuda = preenchimentoSemAjuda;
    }

    public boolean isPreenchimentoComAjuda() {
        return preenchimentoComAjuda;
    }

    public void setPreenchimentoComAjuda(boolean preenchimentoComAjuda) {
        this.preenchimentoComAjuda = preenchimentoComAjuda;
    }

    public boolean isVitimaSemCondicoesResponder() {
        return vitimaSemCondicoesResponder;
    }

    public void setVitimaSemCondicoesResponder(boolean vitimaSemCondicoesResponder) {
        this.vitimaSemCondicoesResponder = vitimaSemCondicoesResponder;
    }

    public boolean isVitimaRecusouResponder() {
        return vitimaRecusouResponder;
    }

    public void setVitimaRecusouResponder(boolean vitimaRecusouResponder) {
        this.vitimaRecusouResponder = vitimaRecusouResponder;
    }

    public boolean isTerceiroComunicantePreencheu() {
        return terceiroComunicantePreencheu;
    }

    public void setTerceiroComunicantePreencheu(boolean terceiroComunicantePreencheu) {
        this.terceiroComunicantePreencheu = terceiroComunicantePreencheu;
    }
}