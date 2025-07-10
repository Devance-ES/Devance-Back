package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.StatusDelegacia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "delegacias")
public class Delegacia {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false, length = 255)
    private String nome;

    @Getter
    @Setter
    @Column(unique = true, nullable = false, length = 14)
    private String cnpj;

    @Getter
    @Setter
    @Column(name = "endereco", nullable = false, length = 500)
    private String endereço;

    @Getter
    @Setter
    @Column(nullable = false, length = 255)
    private String senha;

    @Getter
    @Setter
    @Column(name = "informacao_contato", length = 255)
    private String informacaoContato;

    @Getter
    @Setter
    @OneToMany(mappedBy = "delegacia")
    private List<Delegado> responsavel;

    @Getter
    @Setter
    @Column(name = "status")
    private StatusDelegacia status;

    @Getter
    @Setter
    @Column(name = "tipo")
    private String tipo;

    @Getter
    @Setter
    @ManyToOne // Uma Delegacia é gerenciada por UM SuperAdministrador
    @JoinColumn(name = "super_administrador_gerenciador_id") // Coluna FK na tabela Delegacias
    private SuperAdministrador superAdministradorGerenciador;

    @Getter
    @Setter
    @Column
    private StatusDelegacia statusDelegacia;

}