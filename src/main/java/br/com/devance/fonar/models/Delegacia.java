package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.StatusDelegacia;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "delegacias")
public class Delegacia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(unique = true, nullable = false, length = 14)
    private String cnpj;

    @Column(name = "endereco", nullable = false, length = 500)
    private String endereço;

    @Column(nullable = false, length = 255)
    private String senha;

    @Column(name = "informacao_contato", length = 255)
    private String informacaoContato;

    @OneToMany(mappedBy = "delegacia")
    private List<Delegado> responsavel;

    @ManyToOne // Uma Delegacia é gerenciada por UM SuperAdministrador
    @JoinColumn(name = "super_administrador_gerenciador_id") // Coluna FK na tabela Delegacias
    private SuperAdministrador superAdministradorGerenciador;

    @Column
    private StatusDelegacia statusDelegacia;



    public Delegacia() {
    }

    public Delegacia(String nome, String cnpj, String endereço, String senha, String contato){
        this.nome=nome;
        this.cnpj=cnpj;
        this.endereço=endereço;
        this.senha=senha;
        this.informacaoContato=contato;
        this.responsavel = new ArrayList<>();
    }

    public Delegacia(Long id, String nome, String cnpj, String endereço, String senha, String informacaoContato,
                     List<Delegado> responsavel, SuperAdministrador superAdministradorGerenciador, StatusDelegacia statusDelegacia) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereço = endereço;
        this.senha = senha;
        this.informacaoContato = informacaoContato;
        this.responsavel = responsavel;
        this.superAdministradorGerenciador = superAdministradorGerenciador;
        this.statusDelegacia = statusDelegacia;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getInformacaoContato() {
        return informacaoContato;
    }

    public void setInformacaoContato(String informacaoContato) {
        this.informacaoContato = informacaoContato;
    }

    public List<Delegado> getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(List<Delegado> responsavel) {
        this.responsavel = responsavel;
    }

    public SuperAdministrador getSuperAdministradorGerenciador() {
        return superAdministradorGerenciador;
    }

    public void setSuperAdministradorGerenciador(SuperAdministrador superAdministradorGerenciador) {
        this.superAdministradorGerenciador = superAdministradorGerenciador;
    }

    public StatusDelegacia getStatus() {
        return statusDelegacia;
    }

    public void setStatus(StatusDelegacia statusDelegacia) {
        this.statusDelegacia = statusDelegacia;
    }


    public void adicionarDelegado(Delegado delegado) {


    }

    public void removerDelegado(Delegado delegado) {


    }
}