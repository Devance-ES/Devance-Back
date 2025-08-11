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
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("FUNCIONARIO_SECUNDARIO")
@Getter
@Setter
public class FuncionarioSecundario extends Usuario{

    @Enumerated(EnumType.STRING)
    @Column(name = "cargo_funcionario", length = 50)
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "delegacia_id")
    private Delegacia delegacia;

    public FuncionarioSecundario(String nome, String cpf, String email, String senha, LocalDateTime dataNascimento,
                                 PerfilUsuario perfil, Cargo cargo, Delegacia delegacia) {
        super(nome, cpf, email, senha, dataNascimento, perfil);
        this.cargo = cargo;
        this.delegacia = delegacia;
    }

    public FuncionarioSecundario() {
        super();
    }
}