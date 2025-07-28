// src/main/java/br/com/devance/fonar/dto/DTOSaidaUsuario.java
package br.com.devance.fonar.dto;

import br.com.devance.fonar.enums.PerfilUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DTOSaidaUsuario {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private PerfilUsuario perfil;
}
