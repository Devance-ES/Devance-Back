package br.com.devance.fonar.enums;

public enum TipoPreenchimentoProfissional {

    SEM_AJUDA("Vítima respondeu sem ajuda profissional"),
    COM_AJUDA("Vítima respondeu com auxílio profissional"),
    SEM_CONDICOES("Vítima não teve condições de responder"),
    RECUSOU("Vítima recusou-se a preencher"),
    TERCEIRO_COMUNICANTE("Terceiro comunicante respondeu");

    private final String descricao;

    TipoPreenchimentoProfissional(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
