package br.com.devance.fonar.models;
import java.util.List;
import java.util.ArrayList;
public class Delegacia {

    private String nome;
    private String cnpj;
    private String endereço;
    private String senha;
    private String informacaoContato;
    private List<Delegado> responsavel;

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
}
