package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.PerfilUsuario;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("DELEGADO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Delegado extends Usuario{

    @ManyToOne
    @JoinColumn(name = "delegacia_id")
    private Delegacia delegacia;

    @Column(name = "delegado_contato")
    private String delegadoContato;

    public Delegado(String nome, String cpf, String email, String senha,
                    LocalDateTime dataNascimento, PerfilUsuario perfil,
                    String delegadoContato, Delegacia delegacia) {
        super(nome, cpf, email, senha, dataNascimento, perfil);


        this.delegadoContato = delegadoContato;
        this.delegacia = delegacia;
    }
}