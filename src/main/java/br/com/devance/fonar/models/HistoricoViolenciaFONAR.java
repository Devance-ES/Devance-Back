package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.TipoAgressaoQ2;
import br.com.devance.fonar.enums.TipoAgressaoQ3;

import java.util.List;

public class HistoricoViolenciaFONAR {

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

    public HistoricoViolenciaFONAR(
            boolean ameacouComArmaFogo, boolean ameacouComFaca, boolean ameacouDeOutraForma, boolean naoAmeacou,
           ) {

        this.ameacouArma = ameacouComArmaFogo;
        this.ameacouFaca = ameacouComFaca;
        this.ameacouOutraForma = ameacouDeOutraForma;
        this.naoAmeacou = naoAmeacou;

    }

}
