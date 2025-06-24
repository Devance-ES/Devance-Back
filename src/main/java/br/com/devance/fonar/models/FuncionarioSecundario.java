package br.com.devance.fonar.models;
import br.com.devance.fonar.enums.Cargo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="tabela_FuncionarioSecundario")
public class FuncionarioSecundario extends Usuario{
    @Column(name="data-cadastro")
    private LocalDate dataCadastro;
    @Column(name="cargo")
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
