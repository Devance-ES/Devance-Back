package br.com.devance.fonar.enums;

public enum Status {

    CRIADA("Criada"),
    FINALIZADA("Finalizada"),
    EM_ATENDIMENTO("Em atendimento");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
