package br.com.devance.fonar.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate; // Importa LocalDate, mais comum para data de nascimento
import java.time.LocalDateTime;

@Entity
@Table(name = "vitimas_info")
public class Vitima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento; // Usando LocalDate para data de nascimento

    @Column(name = "numero_contato", length = 20)
    private String numeroContato;

    @Column(length = 255)
    private String email;

    public Vitima() {
    }

    public Vitima(String cpf, String nome, LocalDateTime nascimento,String contato,String email){
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento =nascimento.toLocalDate(); // Converte LocalDateTime para LocalDate no construtor
        this.numeroContato = contato;
        this.email = email;
    }

    public String getCpf() {return cpf;}

    public void setCpf(String cpf) {this.cpf = cpf;}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() { // Getter retorna LocalDate
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) { // Setter recebe LocalDate
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}