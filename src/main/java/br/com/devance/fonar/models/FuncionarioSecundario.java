package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.Cargo;

import br.com.devance.fonar.enums.PerfilUsuario;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("FUNCIONARIO_SECUNDARIO")
public class FuncionarioSecundario extends Usuario{

    @Column(name = "data_cadastro_funcionario_sec")
    private LocalDate dataCadastro;

    @Enumerated(EnumType.STRING)
    @Column(name = "cargo_funcionario", length = 50)
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "delegacia_id")
    private Delegacia delegacia;

    @Column (name = "ativo")
    private boolean ativo;

    @Column (name = "Perfil")
    private PerfilUsuario perfil;

}