package br.com.devance.fonar.enums;

public enum RespostasSimNaoNaoSei {

    SIM("Sim"),
    NAO("Não"),
    NAO_SEI("Não sei");

    private final String descricao;

    RespostasSimNaoNaoSei(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
