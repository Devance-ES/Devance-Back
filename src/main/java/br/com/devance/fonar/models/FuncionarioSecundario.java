package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.Cargo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("FUNCIONARIO_SECUNDARIO")
public class FuncionarioSecundario extends Usuario{

    @Column(name = "data_cadastro_funcionario_sec")
    private LocalDate dataCadastro;

    @Enumerated(EnumType.STRING)
    @Column(name = "cargo_funcionario", length = 50)
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "delegacia_id", nullable = false)
    private Delegacia delegacia;

    @Column (name = "ativo")
    private boolean ativo;

    public FuncionarioSecundario() {
    }

    public FuncionarioSecundario(String nome, String cpf, String email, String senha, LocalDateTime nascimento, LocalDate data){
        super (nome,cpf,email, senha,nascimento);
        this.dataCadastro = data;
    }



    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Delegacia getDelegacia() {
        return delegacia;
    }

    public void setDelegacia(Delegacia delegacia) {
        this.delegacia = delegacia;
    }

    public void registrarFonar(){}

    public void acessarHistorico(){}

    public void uploadFonar(){}
}