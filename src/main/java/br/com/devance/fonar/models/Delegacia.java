package br.com.devance.fonar.models;
import jakarta.persistence.Entity;
import org.springframework.boot.context.properties.bind.Name;
import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name="tabela_delegacia")
public class Delegacia {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idDelegacia")
    private Long idDelegacia;

    @Column(name="Nome_Delegacia")
    private String nome;
    @Column(name="CNPJ",unique=true)
    private String cnpj;
    @Column(name="Endereço")
    private String endereço;
    private String senha;
    @Column(name="Contato_Delegacia")
    private String informacaoContato;

    @Column(name="Delegado_Responsável")
    @OneToMany(mappedBy = "delegacia")
    private List<Delegado> responsavel;

    //uma delegacia tem vários Fonars
    @OneToMany(mappedBy = "delegacia")//chave que liga fonar e delegacia
    private List<Fonar> fonar;

    //construtores
    public Delegacia() {
    }

    public Delegacia(String nome, String cnpj, String endereco, String senha, String contato){
        this.nome=nome;
        this.cnpj=cnpj;
        this.endereço=endereco;
        this.senha=senha;
        this.informacaoContato=contato;
        this.responsavel = new ArrayList<>();
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


    public void adicionarDelegado(Delegado delegado) {


    }

    public void  removerDelegado(Delegado delegado) {


    }

    public Long getIdDelegacia() {
        return idDelegacia;
    }

    public void setIdDelegacia(Long idDelegacia) {
        this.idDelegacia = idDelegacia;
    }


}
