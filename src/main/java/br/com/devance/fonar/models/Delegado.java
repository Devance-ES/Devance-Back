package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.PerfilUsuario;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("DELEGADO")
public class Delegado extends Usuario{
    @Column(name = "data_cadastro_delegado")
    private LocalDate dataCadastro;

    @ManyToOne
    @JoinColumn(name = "delegacia_id")
    private Delegacia delegacia;

    @Column(name = "delegado_contato")
    private String delegadoContato;

    @Column(name = "ativo")
    private boolean ativo;

    @Column (name = "perfil")
    private PerfilUsuario perfil;

}