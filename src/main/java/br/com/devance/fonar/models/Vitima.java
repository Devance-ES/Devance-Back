package br.com.devance.fonar.models;
import java.time.LocalDateTime;

public class Vitima {

    private String nome;
    private LocalDateTime dataNascimento;
    private String numeroContato;
    private String email;

    public Vitima() {
    }

    public Vitima(String nome, LocalDateTime nascimento,String contato,String email){
        this.nome = nome;
        this.dataNascimento =nascimento;
        this.numeroContato = contato;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNumeroContato() {
        return numeroContato;
    }

    public void setNumeroContato(String numeroContato) {
        this.numeroContato = numeroContato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
