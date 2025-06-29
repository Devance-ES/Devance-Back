package br.com.devance.fonar.enums;

public enum UsoAbusivo {
    ALCOOL("Sim, de álcool"),
    DROGAS("Sim, de drogas"),
    NAO("Não"),
    NAO_SEI("Não sei");

    private final String descricao;

    UsoAbusivo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
