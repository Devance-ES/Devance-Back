package br.com.devance.fonar.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("SUPER_ADMINISTRADOR")
public class SuperAdministrador extends Usuario{

    @Column(length = 255)
    private String contato;

    @OneToMany(mappedBy = "superAdministradorGerenciador")
    private List<Delegacia> responsavelPor;

    public SuperAdministrador() {
        this.responsavelPor = new ArrayList<>();
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