package br.com.devance.fonar.models;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="tabela_adm")
public class SuperAdministrador extends Usuario{
    @Column(name="contato-adm")
    private String contato;

    //ver se recebe @OneToMany
    private List<Delegacia> responsavelPor;

    public SuperAdministrador() {
    }

    public SuperAdministrador(String nome, String cpf, String email, String senha, LocalDateTime nascimento, String contato){
        super (nome,cpf,email, senha, nascimento);
        this.contato = contato;
        this.responsavelPor = new ArrayList<>();
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public List<Delegacia> getResponsavelPor() {
        return responsavelPor;
    }

    public void setResponsavelPor(List<Delegacia> responsavelPor) {
        this.responsavelPor = responsavelPor;
    }

    public void cadastrarDelegacia(Delegacia delegacia) {


    }

    public void removerDelegacia(Delegacia delegacia) {


    }

    public void alterarStatusDelegacia(Delegacia delegacia) {


    }
}
