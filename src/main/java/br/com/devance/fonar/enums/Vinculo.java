package br.com.devance.fonar.enums;

public enum Vinculo {

    MARIDO_MULHER("Marido/Mulher"),
    EX_COMPANHEIROS("Ex-companheiros"),
    NAMORADOS("Namorados"),
    AMIGOS("Amigos"),
    PARENTESCO("Parentesco"), // Adicionado para cobrir vínculos familiares como pai/filho, irmão, etc.
    OUTRO("Outro"); // Para qualquer outro vínculo não listado explicitamente

    private final String descricao;

    private Vinculo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
