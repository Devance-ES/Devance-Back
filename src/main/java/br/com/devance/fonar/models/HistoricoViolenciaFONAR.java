package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.TipoAgressaoQ2;
import br.com.devance.fonar.enums.TipoAgressaoQ3;
import lombok.Setter;

import java.util.List;

public class HistoricoViolenciaFONAR {

    @Setter
    private boolean ameacouArma;
    private boolean ameacouFaca;
    private boolean ameacouOutraForma;
    private boolean naoAmeacou;
    private List<TipoAgressaoQ2> agressoesFisicasQ2;
    private List<TipoAgressaoQ3> agressoesFisicasQ3;
    private boolean obrigouSexo;
    private boolean sentimentoPosse;
    private boolean pertubouPerseguiuVigiou;
    private boolean proibiuVisita;
    private boolean proibiuTrabalhoEstudo;
    private boolean contatoInsistente;
    private boolean bloqueouBens;
    private boolean ciumesEControle;
    private boolean nenhumComportamentoAcima;
    private boolean jaRegistrouBOAntes;
    private boolean frequentesRecentemente;

    public HistoricoViolenciaFONAR(boolean ameacouArma, boolean ameacouFaca, boolean ameacouOutraForma, boolean naoAmeacou, boolean obrigouSexo, boolean sentimentoPosse, boolean pertubouPerseguiuVigio,
                                   boolean proibiuVisita, boolean proibiuTrabalhoEstudo, boolean contatoInsistente, boolean bloqueouBens, boolean ciumesEControle, boolean nenhumComportamentoAcima,
                                   boolean jaRegistrouBOAntes, boolean frequentesRecentemente) {

        this.ameacouArma = ameacouArma;
        this.ameacouFaca = ameacouFaca;
        this.ameacouOutraForma = ameacouOutraForma;
        this.naoAmeacou = naoAmeacou;
        this.obrigouSexo = obrigouSexo;
        this.sentimentoPosse = sentimentoPosse;
        this.pertubouPerseguiuVigiou = pertubouPerseguiuVigio;
        this.proibiuVisita = proibiuVisita;
        this.proibiuTrabalhoEstudo = proibiuTrabalhoEstudo;
        this.contatoInsistente = contatoInsistente;
        this.bloqueouBens = bloqueouBens;
        this.ciumesEControle = ciumesEControle;
        this.nenhumComportamentoAcima = nenhumComportamentoAcima;
        this.jaRegistrouBOAntes = jaRegistrouBOAntes;
        this.frequentesRecentemente = frequentesRecentemente;
    }
}
