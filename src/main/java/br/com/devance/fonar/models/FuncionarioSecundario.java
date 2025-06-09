package br.com.devance.fonar.models;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class FuncionarioSecundario extends Usuario{

    private LocalDate dataCadastro;
    private CargoEnum cargo;

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

    public CargoEnum getCargo() {
        return cargo;
    }

    public void setCargo(CargoEnum cargo) {
        this.cargo = cargo;
    }
}
