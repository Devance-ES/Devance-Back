package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.StatusDelegacia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
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
    private String endereco;

    @Column(nullable = false, length = 255)
    private String senha;

    @Column(name = "informacao_contato", length = 255)
    private String informacaoContato;

    @ManyToOne // Uma delegacia tem UM Delegado responsável
    @JoinColumn(name = "delegado_responsavel_id") // Coluna FK na tabela delegacias
    private Delegado delegadoResponsavel; // O objeto Delegado responsável

    @Column(name = "status")
    private StatusDelegacia status;

    @Column(name = "tipo")
    private String tipo;

    @ManyToOne // Uma Delegacia é gerenciada por UM SuperAdministrador
    @JoinColumn(name = "super_administrador_gerenciador_id") // Coluna FK na tabela Delegacias
    private SuperAdministrador superAdministradorGerenciador;

    @Column
    private StatusDelegacia statusDelegacia;

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

    public String getNome() {
        return nome;
    }
}