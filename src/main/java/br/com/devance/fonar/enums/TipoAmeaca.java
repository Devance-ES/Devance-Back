package br.com.devance.fonar.enums;

public enum TipoAmeaca {

    ARMA_DE_FOGO("Sim, utilizando arma de fogo"),
    FACA("Sim, utilizando faca"),
    OUTRA_FORMA("Sim, de outra forma"),
    NAO_AMEACOU("Não");

    private final String descricao;

    TipoAmeaca(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
