package br.com.devance.fonar.models;

public class PreenchimentoProfissionalFONAR {

    private boolean preenchimentoSemAjuda;
    private boolean preenchimentoComAjuda;
    private boolean vitimaSemCondicoesResponder;
    private boolean vitimaRecusouResponder;
    private boolean terceiroComunicantePreencheu;

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
