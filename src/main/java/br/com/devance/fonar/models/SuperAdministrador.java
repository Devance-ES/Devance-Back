package br.com.devance.fonar.models;

import java.time.LocalDateTime;

public class SuperAdministrador extends Usuario{
    public SuperAdministrador() {
    }

    public SuperAdministrador(String nome, String cpf, String email, String senha, LocalDateTime nascimento){
        super (nome,cpf,email, senha, nascimento);
    }

}
