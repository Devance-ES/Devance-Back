package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.PerfilUsuario;
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
    @JoinColumn(name = "delegacia_id")
    private Delegacia delegacia;

    @Column(name = "delegado_contato")
    private String delegadoContato;

    @Column(name = "ativo")
    private boolean ativo;

    @Column (name = "perfil")
    private PerfilUsuario perfil;

    public Delegado() {
    }

    public Delegado(String nome, String cpf, String email, String senha, LocalDateTime dataNascimento,
                    LocalDate dataCadastro, Delegacia delegacia, String delegadoContato, boolean ativo,
                    PerfilUsuario perfil) {
        super(nome, cpf, email, senha, dataNascimento);
        this.dataCadastro = dataCadastro;
        this.delegacia = delegacia;
        this.delegadoContato = delegadoContato;
        this.ativo = ativo;
        this.perfil = perfil;
    }

    public Delegado(LocalDate dataCadastro, Delegacia delegacia, String delegadoContato, boolean ativo, PerfilUsuario perfil) {
        this.dataCadastro = dataCadastro;
        this.delegacia = delegacia;
        this.delegadoContato = delegadoContato;
        this.ativo = ativo;
        this.perfil = perfil;
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

    public String getDelegadoContato() {
        return delegadoContato;
    }

    public void setDelegadoContato(String delegadoContato) {
        this.delegadoContato = delegadoContato;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public PerfilUsuario getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilUsuario perfil) {
        this.perfil = perfil;
    }
}