package br.com.devance.fonar.models;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="tabela_vitimas")
public class Vitima {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="IDvitima")
    private Long idVitima;

    @Column(name="Nome_Vitima")
    private String nome;

    @Column(name="Data_Nascimento")
    private LocalDateTime dataNascimento;
    @Column(name="Contato_vitima")
    private String numeroContato;
    @Column(name="email",unique=true)
    private String email;


    @OneToMany(mappedBy = "vitima")
    private List<Fonar> fonar;

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

    public Long getIdVitima() {
        return idVitima;
    }

    public void setIdVitima(Long idVitima) {
        this.idVitima = idVitima;
    }
}
