package br.com.devance.fonar.enums;

public enum TipoAgressaoQ2 {

    QUEIMADURA("Queimadura"),
    ENFORCAMENTO("Enforcamento"),
    SUFOCAMENTO("Sufocamento"),
    TIRO("Tiro"),
    AFOGAMENTO("Afogamento"),
    FACADA("Facada"),
    PAULADA("Paulada"),
    NENHUMA_DAS_AGRESSOES("Nenhuma das agressões");

    private String descricao;

    TipoAgressaoQ2(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
