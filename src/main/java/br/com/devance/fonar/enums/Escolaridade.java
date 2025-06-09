package br.com.devance.fonar.enums;

public enum Escolaridade {

    ANALFABETO("Analfabeto"),
    FUNDAMENTAL_INCOMPLETO("Fundamental Incompleto"),
    FUNDAMENTAL_COMPLETO("Fundamental Completo"),
    MEDIO_INCOMPLETO("Médio Incompleto"),
    MEDIO_COMPLETO("Médio Completo"),
    SUPERIOR_INCOMPLETO("Superior Incompleto"),
    SUPERIOR_COMPLETO("Superior Completo"),
    POS_GRADUACAO_INCOMPLETA("Pós-Graduação Incompleta"),
    POS_GRADUACAO_COMPLETA("Pós-Graduação Completa"),
    NAO_INFORMADO("Não Informado"),
    OUTROS("Outros");

    private final String descricao;

    Escolaridade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
