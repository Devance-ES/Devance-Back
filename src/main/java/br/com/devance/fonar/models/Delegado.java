package br.com.devance.fonar.models;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Delegado extends Usuario{
    private LocalDate dataCadastro;
    private Delegacia delegacia;

    public Delegado() {
    }

    public Delegado(String nome, String cpf, String email, String senha, LocalDateTime nascimento, LocalDate data, Delegacia delegacia){
        super(nome,cpf, email,senha,nascimento);
        this.dataCadastro = data;
        this.delegacia= delegacia;
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

    public void registrarFonar(){}

    public void acessarHistorico(){}

    public void enviarFonar(){}



}
