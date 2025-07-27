// src/main/java/br/com/devance/fonar/dtos/DTOAuthResponse.java
package br.com.devance.fonar.dto;

import br.com.devance.fonar.enums.PerfilUsuario; // Certifique-se de importar PerfilUsuario
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DTOAuthResponse {
    private String token;
    private Long userId;
    private String cpf;
    private PerfilUsuario perfil;
    private String message;

}

