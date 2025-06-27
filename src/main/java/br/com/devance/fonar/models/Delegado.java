package br.com.devance.fonar.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("DELEGADO")
public class Delegado extends Usuario{
    @Column(name = "data_cadastro_delegado")
    private LocalDate dataCadastro;

    @ManyToOne
    @JoinColumn(name = "delegacia_id", nullable = false)
    private Delegacia delegacia;

    public Delegado() {
    }

    public Delegado(String nome, String cpf, String email, String senha, LocalDateTime nascimento, LocalDate data, Delegacia delegacia){
        super(nome,cpf, email,senha,nascimento);
        this.dataCadastro = data;
        this.delegacia= delegacia;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Delegacia getDelegacia() {
        return delegacia;
    }

    public void setDelegacia(Delegacia delegacia) {
        this.delegacia = delegacia;
    }

    public void registrarFonar(){}

    public void acessarHistorico(){}

    public void enviarFonar(){}
}