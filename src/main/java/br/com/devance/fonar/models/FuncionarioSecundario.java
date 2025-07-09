package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.Cargo;

import br.com.devance.fonar.enums.PerfilUsuario;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@DiscriminatorValue("FUNCIONARIO_SECUNDARIO")
public class FuncionarioSecundario extends Usuario{

    @Column(name = "data_cadastro_funcionario_sec")
    private LocalDate dataCadastro;

    @Enumerated(EnumType.STRING)
    @Column(name = "cargo_funcionario", length = 50)
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "delegacia_id")
    private Delegacia delegacia;

    @Column (name = "ativo")
    private boolean ativo;

    @Column (name = "Perfil")
    private PerfilUsuario perfil;

    public FuncionarioSecundario() {
    }

    public FuncionarioSecundario(String nome, String cpf, String email, String senha, LocalDateTime nascimento, LocalDate data){
        super (nome,cpf,email, senha,nascimento);
        this.dataCadastro = data;
    }

    public FuncionarioSecundario(LocalDate dataCadastro, Cargo cargo, Delegacia delegacia, boolean ativo, PerfilUsuario perfil) {
        this.dataCadastro = dataCadastro;
        this.cargo = cargo;
        this.delegacia = delegacia;
        this.ativo = ativo;
        this.perfil = perfil;
    }

    public FuncionarioSecundario(String nome, String cpf, String email, String senha, LocalDateTime dataNascimento, LocalDate dataCadastro, Cargo cargo, Delegacia delegacia, boolean ativo, PerfilUsuario perfil) {
        super(nome, cpf, email, senha, dataNascimento);
        this.dataCadastro = dataCadastro;
        this.cargo = cargo;
        this.delegacia = delegacia;
        this.ativo = ativo;
        this.perfil = perfil;
    }

}