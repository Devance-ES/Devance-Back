package br.com.devance.fonar.dto; // Ou br.com.devance.fonar.dto, se preferir

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Gera getters, setters, toString, equals e hashCode
@NoArgsConstructor // Gera construtor sem argumentos
@AllArgsConstructor // Gera construtor com todos os argumentos
@Builder // Gera o padrão Builder
public class DTOAuthRequest { // Classe renomeada para DTOAuthRequest
    @NotBlank(message = "O CPF/Email é obrigatório para login.")
    private String username; // Nome de usuário, que pode ser CPF ou Email
    @NotBlank(message = "A senha é obrigatória para login.")
    private String senha;
}