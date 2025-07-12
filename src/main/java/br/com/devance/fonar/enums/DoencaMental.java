package br.com.devance.fonar.enums;

public enum DoencaMental {

    SIM_USA_MEDICACAO("Sim e faz uso de medicação"),
    SIM_NAO_USA_MEDICACAO("Sim e não faz uso de medicação"),
    NAO("Não"),
    NAO_SEI("Não sei");

    private final String descricao;

    DoencaMental(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
