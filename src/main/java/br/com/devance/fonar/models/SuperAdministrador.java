package br.com.devance.fonar.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("SUPER_ADMINISTRADOR")
public class SuperAdministrador extends Usuario{

    @Column(length = 255)
    private String contato;

    @OneToMany(mappedBy = "superAdministradorGerenciador")
    private List<Delegacia> responsavelPor;
    
}