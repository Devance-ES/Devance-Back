package br.com.devance.fonar.enums;

public enum TipoComportamento {

    SENTIMENTO_POSSE("Disse algo como: 'se não for minha, não será de mais ninguém'"),
    PERTURBOU_PERSEGUIU_VIGIOU("Perturbou, perseguiu ou vigiou você"),
    PROIBIU_VISITA("Proibiu você de visitar familiares ou amigos"),
    PROIBIU_TRABALHO_ESTUDO("Proibiu você de trabalhar ou estudar"),
    CONTATO_INSISTENTE("Fez contato insistente por telefone, mensagens ou e-mails"),
    BLOQUEOU_BENS("Impediu acesso a bens como dinheiro, documentos ou carro"),
    CIUMES_E_CONTROLE("Comportamento de ciúme excessivo e controle"),
    NENHUM_COMPORTAMENTO_ACIMA("Nenhum dos comportamentos acima listados");

    private final String descricao;

    TipoComportamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
