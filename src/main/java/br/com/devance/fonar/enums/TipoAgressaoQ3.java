package br.com.devance.fonar.enums;

public enum TipoAgressaoQ3 {

    SOCOS("Socos"),
    CHUTES("Chutes"),
    TAPAS("Tapas"),
    EMPURROES("Empurrões"),
    PUXOES_DE_CABELO("Puxões de cabelo"),
    NENHUMA_DAS_AGRESSOES("Nenhuma das agressões");

    private String descricao;

    TipoAgressaoQ3(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
