package br.com.devance.fonar.models;
import br.com.devance.fonar.enums.Cargo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FuncionarioSecundario extends Usuario{

    private LocalDate dataCadastro;
    private Cargo cargo;

    public FuncionarioSecundario() {
    }

    public FuncionarioSecundario(String nome, String cpf, String email, String senha, LocalDateTime nascimento, LocalDate data){
        super (nome,cpf,email, senha,nascimento);
        this.dataCadastro = data;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }


    public void registrarFonar(){}

    public void acessarHistorico(){}

    public void uploadFonar(){}
}
