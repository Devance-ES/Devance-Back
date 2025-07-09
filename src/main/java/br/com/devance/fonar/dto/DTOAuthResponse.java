package br.com.devance.fonar.dto; // Ou br.com.devance.fonar.dto, se preferir

import br.com.devance.fonar.enums.PerfilUsuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Gera getters, setters, toString, equals e hashCode
@NoArgsConstructor // Gera construtor sem argumentos
@AllArgsConstructor // Gera construtor com todos os argumentos
@Builder // Gera o padrão Builder
public class DTOAuthResponse { // Classe renomeada para DTOAuthResponse
    private String token;
    private Long userId;
    private String cpf; // Ou username principal
    private PerfilUsuario perfil;
    private String message;
}