package br.com.devance.fonar.enums;

public enum Nacionalidade {

    BRASILEIRA("Brasileira"),
    ESTRANGEIRA("Estrangeira"),
    NAO_INFORMADA("Não Informada");

    private String nacionalidade;

    private Nacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }
}
