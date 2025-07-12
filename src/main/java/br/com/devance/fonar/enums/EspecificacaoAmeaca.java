package br.com.devance.fonar.enums;

public enum EspecificacaoAmeaca {

    FILHOS("Filhos"),
    OUTROS_FAMILIARES("Outros familiares"),
    OUTRAS_PESSOAS("Outras pessoas"),
    ANIMAIS("Animais");

    private final String descricao;

    EspecificacaoAmeaca(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
