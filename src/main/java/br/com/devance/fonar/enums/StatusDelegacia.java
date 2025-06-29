package br.com.devance.fonar.enums;

public enum StatusDelegacia {
    PENDENTE_VALIDACAO, // Delegacia recém-cadastrada, aguardando aprovação do Super Administrador
    ATIVA,              // Delegacia validada e em pleno funcionamento
    REJEITADA,          // Cadastro da delegacia foi rejeitado pelo Super Administrador
    INATIVA             // Delegacia desativada (por exemplo, por solicitação ou decisão administrativa)
}