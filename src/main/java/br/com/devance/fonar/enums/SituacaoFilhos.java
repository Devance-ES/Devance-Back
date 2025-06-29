package br.com.devance.fonar.enums;

public enum SituacaoFilhos {
    NAO_TEM("Não"),
    COM_AGRESSOR("Sim, com o agressor."),
    DE_OUTRO_RELACIONAMENTO("Sim, de outro relacionamento");

    private final String descricao;

    SituacaoFilhos(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
